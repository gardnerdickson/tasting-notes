package com.tastingnotes.service.cron;

import com.google.cloud.language.v1.Entity;
import com.tastingnotes.service.client.GoogleNlpClient;
import com.tastingnotes.service.client.LcboProduct;
import com.tastingnotes.service.client.LcboProductsClient;
import com.tastingnotes.service.data.Note;
import com.tastingnotes.service.data.NoteRepository;
import com.tastingnotes.service.data.Product;
import com.tastingnotes.service.data.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
class CacheTasks
{
    private static final Logger logger = LoggerFactory.getLogger(CacheTasks.class);

    private static final int DELAY = 12 * 60 * 60 * 1000;

    @Autowired
    private LcboProductsClient lcboProductsClient;

    @Autowired
    private GoogleNlpClient nlpClient;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NoteRepository noteRepository;

    private final Set<Entity.Type> languageEntityTypeExclusions = new HashSet<>(
            Arrays.asList(Entity.Type.LOCATION, Entity.Type.ORGANIZATION, Entity.Type.PERSON)
    );

    @Scheduled(initialDelay = DELAY, fixedDelay = DELAY) // 12 hours
    public void refreshLcboProductCache() throws IOException
    {
        logger.info("Refreshing Redis caches.");

        Iterator<LcboProduct> productIterator = lcboProductsClient.getProductIterator();

        LcboProduct product;
        while (productIterator.hasNext())
        {
            product = productIterator.next();
            if (!productRepository.hasProduct(product.getId()))
            {
                if (product.getTastingNote() != null)
                {
                    Set<String> words = nlpClient.getLanguageEntities(product.getTastingNote(), languageEntityTypeExclusions);
                    saveNotes(words, product.getId());
                }
                if (product.getStyle() != null)
                {
                    Set<String> words = nlpClient.getLanguageEntities(product.getStyle(), languageEntityTypeExclusions);
                    saveNotes(words, product.getId());
                }
                productRepository.saveProduct(new Product(product.getId(), product.getName()));
            }
        }
    }

    private void saveNotes(Collection<String> words, long productId)
    {
        for (String word : words)
        {
            noteRepository.saveNote(new Note(word, Collections.singleton(productId)));
        }
    }
}
