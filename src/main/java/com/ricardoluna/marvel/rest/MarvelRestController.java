package com.ricardoluna.marvel.rest;

import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.rest.controller.CharactersController;
import com.ricardoluna.marvel.rest.controller.CollaboratorsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


/**
 * Rest Controller responsible for exposing Marvel API related endpoints.
 * This controller provides endpoints to fetch collaborator and character details
 * associated with a specific character from the Marvel universe.
 */
@RestController
@RequestMapping("/marvel")
public class MarvelRestController {

    @Autowired
    private CollaboratorsController collaboratorsController;

    @Autowired
    private CharactersController charactersController;

    /**
     * Endpoint to retrieve collaborator information (editors, colorists, writers)
     * associated with a specific character from the Marvel universe.
     *
     * @param character Name of the character (e.g. "capamerica", "ironman").
     * @return ResponseEntity containing details of the character's collaborators or error response.
     */
    @GetMapping("/collaborators/characters/{character}")
    @ResponseBody
    public Mono<ResponseEntity<CollaboratorsResponse>> getCollaborators(
            @PathVariable("character")final String character) {

        if (!"capamerica".equalsIgnoreCase(character) && !"ironman".equalsIgnoreCase(character)) {
            return Mono.just(ResponseEntity.badRequest().body(null));
        }

        return collaboratorsController.getCollaboratorsByName(character)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to retrieve character details from the Marvel universe.
     *
     * @param character Name of the character (e.g. "capamerica", "ironman").
     * @return ResponseEntity containing details of the character or error response.
     */
    @GetMapping("/characters/characters/{character}")
    @ResponseBody
    public Mono<ResponseEntity<CharactersResponse>> getCharacters(
            @PathVariable("character")final String character) {

        if (!"capamerica".equalsIgnoreCase(character) && !"ironman".equalsIgnoreCase(character)) {
            return Mono.just(ResponseEntity.badRequest().body(null));
        }
        return charactersController.getCharactersByName(character)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}