package com.ricardoluna.marvel.service;

import com.ricardoluna.marvel.objects.CharacterMarvelResponse;
import com.ricardoluna.marvel.objects.ComicResponse;
import com.ricardoluna.marvel.objects.MarvelApiRequest;
import reactor.core.publisher.Mono;

/**
 * This service interface defines methods to interact with Marvel character data.
 * Implementing classes would typically handle the business logic associated with fetching
 * character details and their associated comics.
 */
public interface CharacterService {

    /**
     * Retrieve Marvel character details based on the provided request parameters.
     *
     * @param marvelRequest The request object containing necessary details like character name, API keys, etc.
     * @return A Mono wrapping the CharacterMarvelResponse object which holds the details of the requested character.
     */
    Mono<CharacterMarvelResponse> getCharacterByName(final MarvelApiRequest marvelRequest);

    /**
     * Retrieves a list of comics associated with a specific Marvel character by their ID.
     * The request contains necessary details for the API call.
     *
     * @param idCharacter  The unique identifier of the Marvel character.
     * @param marvelRequest The request object containing parameters for the Marvel API call.
     * @return A Mono wrapping the ComicResponse object which holds a list of comics related to the character.
     */
    Mono<ComicResponse> getCharacterComicsById(final int idCharacter, final MarvelApiRequest marvelRequest);

}
