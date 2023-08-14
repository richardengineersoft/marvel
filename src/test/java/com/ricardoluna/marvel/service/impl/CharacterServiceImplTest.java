package com.ricardoluna.marvel.service.impl;

import com.ricardoluna.marvel.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Unit test class for the CharacterService implementation. This class leverages the WebFluxTest
 * annotation for testing reactive web applications in a mock servlet environment. The primary
 * focus is on the CharacterService class. Dependencies are provided by the test context and
 * the actual service methods are invoked to test their behavior.
 */
@WebFluxTest(CharacterService.class)
public class CharacterServiceImplTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private CharacterService characterService;


    @Test
    public void shouldHandleServerUnavailabilityCharacterByName() {
        when(characterService.getCharacterByName(any())).thenReturn(Mono.error(new Exception()));
        this.webClient.get().exchange().expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void shouldHandleServerUnavailability() {
        when(characterService.getCharacterComicsById(anyInt(), any())).thenReturn(Mono.error(new Exception()));
        this.webClient.get().exchange().expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }


}
