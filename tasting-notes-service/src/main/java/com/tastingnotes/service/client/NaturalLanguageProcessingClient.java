package com.tastingnotes.service.client;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.language.v1.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NaturalLanguageProcessingClient
{
    public List<String> getLanguageEntities(String text) throws IOException
    {
        LanguageServiceClient languageClient = LanguageServiceClient.create();

        Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
        AnalyzeEntitiesResponse response = languageClient.analyzeEntities(document, EncodingType.UTF8);

        List<Entity> entities = response.getEntitiesList();

        return entities.stream().map(Entity::getName).collect(Collectors.toList());
    }
}
