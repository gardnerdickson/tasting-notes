package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LcboProductSingleResponse extends LcboProductResponse<LcboProduct>
{
}
