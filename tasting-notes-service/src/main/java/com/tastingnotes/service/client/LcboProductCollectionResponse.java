package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class LcboProductCollectionResponse extends LcboProductResponse<List<LcboProduct>>
{
}
