package com.tastingnotes.service.client;

import com.google.cloud.language.v1.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GoogleNlpClient
{
    public Set<String> getLanguageEntities(String text, Set<Entity.Type> entityTypeExclusions) throws IOException
    {
        LanguageServiceClient languageClient = LanguageServiceClient.create();

        Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
        AnalyzeEntitiesResponse response = languageClient.analyzeEntities(document, EncodingType.UTF8);

        List<Entity> entities = response
                .getEntitiesList()
                .stream()
                .filter(entity -> !entityTypeExclusions.contains(entity.getType()))
                .collect(Collectors.toList());

        List<String> words = entities
                .stream()
                .map(Entity::getName)
                .collect(Collectors.toList());

        return new HashSet<>(words);
    }
}
