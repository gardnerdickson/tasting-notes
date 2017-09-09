package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LcboProductCollectionResponse extends LcboProductResponse<Collection<LcboProduct>>
{
}
