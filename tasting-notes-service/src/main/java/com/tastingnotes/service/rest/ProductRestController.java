package com.tastingnotes.service.rest;

import com.tastingnotes.service.client.NaturalLanguageProcessingClient;
import com.tastingnotes.service.client.Product;
import com.tastingnotes.service.client.ProductsClient;
import com.tastingnotes.service.data.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductRestController
{
    private final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductsClient productsClient;

    @Autowired
    private NaturalLanguageProcessingClient languageClient;

    @Autowired
    private NoteRepository noteRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String test()
    {
        return "This seems to be working.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<Product> getProducts(@RequestParam("notes") String query) throws Exception
    {
        Set<String> notes = new HashSet<>(Arrays.asList(query.split(",")));
        Set<Long> productIds = new HashSet<>();
        notes.stream().forEach(note -> productIds.addAll(noteRepository.findNote(note)));

        return productIds.stream().map(id -> productsClient.getProduct(id)).collect(Collectors.toList());
    }

}
