package com.tastingnotes.service.rest;

import com.tastingnotes.service.client.LcboProductsClient;
import com.tastingnotes.service.client.TastingNotesProduct;
import com.tastingnotes.service.data.NoteRepository;
import com.tastingnotes.service.data.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ProductRestController
{
    private final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    private static final int PRODUCT_LIMIT = 50;

    @Autowired
    private LcboProductsClient lcboProductsClient;

    @Autowired
    private NoteRepository noteRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String test()
    {
        return "This seems to be working.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<TastingNotesProduct> getProducts(@RequestParam("notes") String query) throws Exception
    {
        logger.info("Finding tasting notes for keywords: {}", query);
        Set<String> notes = new HashSet<>(Arrays.asList(query.split(",")));
        Set<Long> productIds = new HashSet<>();
        notes.stream().forEach(note -> productIds.addAll(noteRepository.findNote(note)));
        logger.info("Found {} product IDs");

        List<Long> limited = new ArrayList<>();
        for (Long id : productIds)
        {
            limited.add(id);
            if (limited.size() > PRODUCT_LIMIT)
            {
                break;
            }
        }

        return limited
                .stream()
                .map(id -> lcboProductsClient.getProduct(id))
                .map(TastingNotesProduct::fromLcboProduct)
                .collect(Collectors.toList());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public ResponseEntity<TastingNotesProduct> getProduct(@PathVariable("id") Long id)
    {
        TastingNotesProduct product = TastingNotesProduct.fromLcboProduct(lcboProductsClient.getProduct(id));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
