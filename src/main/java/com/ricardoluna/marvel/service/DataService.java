package com.ricardoluna.marvel.service;

import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import reactor.core.publisher.Mono;

/**
 * This service interface defines methods to fetch data related to Marvel characters and their collaborators.
 * Implementing classes would typically handle the business logic associated with fetching details of characters
 * and their respective collaborators.
 */
public interface DataService {
    /**
     * Retrieves a list of collaborators associated with a specific Marvel character based on their name.
     *
     * @param name The name of the Marvel character for which the collaborators are requested.
     * @return A Mono wrapping the CollaboratorsResponse object which holds details of the collaborators associated with the character.
     */
    Mono<CollaboratorsResponse> getCollaborators (final String name);

    /**
     * Retrieves details of a Marvel character based on their name.
     *
     * @param name The name of the Marvel character whose details are requested.
     * @return A Mono wrapping the CharactersResponse object which holds details of the requested character.
     */
    Mono<CharactersResponse> getCharacters (final String name);
}