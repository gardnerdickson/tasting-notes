package com.tastingnotes.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController
{
    @RequestMapping("/hello")
    public String test()
    {
        return "This seems to be working.";
    }

}
