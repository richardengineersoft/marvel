package com.ricardoluna.marvel.service.impl;

import com.ricardoluna.marvel.objects.CharacterMarvelResponse;
import com.ricardoluna.marvel.objects.ComicResponse;
import com.ricardoluna.marvel.objects.MarvelApiRequest;
import com.ricardoluna.marvel.service.CharacterService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * This class implements the CharacterService interface.
 * It provides methods for getting characters from the Marvel API.
 *
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    /**
     * Retrieves information about a specific Marvel character by name.
     * The request contains necessary details for the API call.
     *
     * @param marvelRequest The request object containing parameters for the Marvel API call.
     * @return A Mono wrapping the CharacterMarvelResponse object that contains information about the requested character.
     */
    @Override
    public Mono<CharacterMarvelResponse> getCharacterByName(final MarvelApiRequest marvelRequest) {

        WebClient webClient;webClient = WebClient.builder()
            .baseUrl(marvelRequest.getBaseUrl())
            .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/public/characters")
                        .queryParam("name", marvelRequest.getNameCharacter())
                        .queryParam("apikey", marvelRequest.getPublicKey())
                        .queryParam("ts", marvelRequest.getTs())
                        .queryParam("hash", marvelRequest.getHash())
                        .build())
                .retrieve()
                .bodyToMono(CharacterMarvelResponse.class);
    }

    /**
     * Retrieves a list of comics associated with a specific Marvel character by their ID.
     * The request contains necessary details for the API call.
     *
     * @param idCharacter  The unique identifier of the Marvel character.
     * @param marvelRequest The request object containing parameters for the Marvel API call.
     * @return A Mono wrapping the ComicResponse object which holds a list of comics related to the character.
     */
    @Override
    public Mono<ComicResponse> getCharacterComicsById(final int idCharacter,
                                                      final MarvelApiRequest marvelRequest) {

        WebClient webClient;webClient = WebClient.builder()
                .baseUrl(marvelRequest.getBaseUrl())
            .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/public/characters/{characterId}/comics")
                        .queryParam("apikey", marvelRequest.getPublicKey())
                        .queryParam("ts", marvelRequest.getTs())
                        .queryParam("hash", marvelRequest.getHash())
                        .build(idCharacter))
                .retrieve()
                .bodyToMono(ComicResponse.class);
    }

}
