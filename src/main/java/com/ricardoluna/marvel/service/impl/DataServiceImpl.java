package com.ricardoluna.marvel.service.impl;

import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.service.DataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * This class implements the DataService interface.
 * It provides methods for accessing data from "name".
 *
 */
@Service
public class DataServiceImpl implements DataService {

    @Value("${syncdata.baseurl}")
    private String baseUrl;


    @Override
    public Mono<CollaboratorsResponse> getCollaborators(final String name) {
        WebClient webClient;
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        Mono<CollaboratorsResponse> responseCollaborators = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/marvel/collaborators/{characterName}")
                        .build(name))
                .retrieve()
                .bodyToMono(CollaboratorsResponse.class);

        return responseCollaborators;
    }

    @Override
    public Mono<CharactersResponse> getCharacters(final String name) {
        WebClient webClient;
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        Mono<CharactersResponse> responseCharacters = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/marvel/characters/{characterName}")
                        .build(name))
                .retrieve()
                .bodyToMono(CharactersResponse.class);

        return responseCharacters;
    }

}