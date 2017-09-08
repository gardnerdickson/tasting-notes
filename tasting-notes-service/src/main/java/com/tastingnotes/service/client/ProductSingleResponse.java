package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductSingleResponse extends ProductResponse<Product>
{
}
