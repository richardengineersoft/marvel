package com.ricardoluna.marvel.scheduler;

import com.ricardoluna.marvel.entity.Info;
import com.ricardoluna.marvel.service.DataService;
import com.ricardoluna.marvel.repository.InfoRepository;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.objects.CharactersResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

/**
 * Unit test class for the SyncData service. This class leverages the Mockito framework for
 * mocking dependencies and JUnit 5 for assertions and test lifecycle. Test properties are
 * specifically defined for isolated testing scenarios.
 */
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {"syncdata.characters=character1,character2"})
public class SyncDataTest {

    @InjectMocks
    private SyncData syncData;

    @Mock
    private DataService characterService;

    @Mock
    private InfoRepository infoRepository;

    @BeforeEach
    public void setUp() {

        ReflectionTestUtils.setField(syncData, "characters", "character1,character2");
    }

    @Test
    public void testSyncData() throws Exception {

        when(characterService.getCollaborators("character1")).thenReturn(Mono.just(new CollaboratorsResponse()));
        when(characterService.getCharacters("character1")).thenReturn(Mono.just(new CharactersResponse()));

        when(characterService.getCollaborators("character2")).thenReturn(Mono.just(new CollaboratorsResponse()));
        when(characterService.getCharacters("character2")).thenReturn(Mono.just(new CharactersResponse()));


        syncData.syncData();


        verify(characterService, times(2)).getCollaborators(anyString());
        verify(characterService, times(2)).getCharacters(anyString());

        verify(infoRepository, times(4)).save(any(Info.class));
    }


}
