package com.ricardoluna.marvel.rest;

import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.rest.controller.CharactersController;
import com.ricardoluna.marvel.rest.controller.CollaboratorsController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit test class for the MarvelRestController. This class leverages the Mockito framework for
 * mocking dependencies, and JUnit 5 for assertions and test lifecycle.
 */
public class MarvelRestControllerTest {

    @InjectMocks
    private MarvelRestController marvelRestController;

    @Mock
    private CollaboratorsController collaboratorsController;

    @Mock
    private CharactersController charactersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCollaborators_ValidCharacter() {
        CollaboratorsResponse collaboratorsResponse = new CollaboratorsResponse();
        when(collaboratorsController.getCollaboratorsByName("capamerica")).thenReturn(Mono.just(collaboratorsResponse));

        ResponseEntity<CollaboratorsResponse> response = marvelRestController.getCollaborators("capamerica").block();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(collaboratorsResponse, response.getBody());
    }

    @Test
    public void testGetCollaborators_InvalidCharacter() {
        ResponseEntity<CollaboratorsResponse> response = marvelRestController.getCollaborators("unknown").block();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetCharacters_ValidCharacter() {
        CharactersResponse charactersResponse = new CharactersResponse();
        when(charactersController.getCharactersByName("ironman")).thenReturn(Mono.just(charactersResponse));

        ResponseEntity<CharactersResponse> response = marvelRestController.getCharacters("ironman").block();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(charactersResponse, response.getBody());
    }

    @Test
    public void testGetCharacters_NotFoundCharacter() {
        when(charactersController.getCharactersByName("unknown")).thenReturn(Mono.empty());

        ResponseEntity<CharactersResponse> response = marvelRestController.getCharacters("unknown").block();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
