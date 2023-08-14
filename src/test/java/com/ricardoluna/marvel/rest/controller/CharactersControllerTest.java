package com.ricardoluna.marvel.rest.controller;

import com.ricardoluna.marvel.config.AppProperties;
import com.ricardoluna.marvel.exceptions.MarvelException;
import com.ricardoluna.marvel.objects.*;
import com.ricardoluna.marvel.service.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static com.ricardoluna.marvel.factory.CommonsApiFactory.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * Unit test class for the CharactersController. This class leverages the Mockito framework for
 * mocking dependencies, and JUnit 5 for assertions and test lifecycle.
 */
@ExtendWith(MockitoExtension.class)
public class CharactersControllerTest {

    @InjectMocks
    CharactersController charactersController;

    @Mock
    CharacterService characterService;
    @Mock
    AppProperties appProp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCharactersByName() throws MarvelException {

            when(characterService.getCharacterComicsById(anyInt(), any(MarvelApiRequest.class)))
                    .thenReturn(Mono.just(getFactoryComicResponse()));
            when(characterService.getCharacterByName(any(MarvelApiRequest.class)))
                    .thenReturn(Mono.just(getCharacterMarvelResponse()));

            CharactersResponse result = charactersController.getCharactersByName("ironman").block();

            assertNotNull(result);
        }
}
