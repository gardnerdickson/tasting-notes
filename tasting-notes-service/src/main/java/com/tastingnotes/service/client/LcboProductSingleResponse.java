package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class LcboProductSingleResponse extends LcboProductResponse<LcboProduct>
{
}
