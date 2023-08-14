package com.ricardoluna.marvel.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardoluna.marvel.entity.Info;
import com.ricardoluna.marvel.entity.InfoID;
import com.ricardoluna.marvel.exceptions.MarvelException;
import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.repository.InfoRepository;
import com.ricardoluna.marvel.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Date;

import static com.ricardoluna.marvel.exceptions.ErrorCodes.MAR_ERR_O4;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * SyncData class synchronizes data from the Marvel API.
 */
@Slf4j
@EnableScheduling
@Service
public class SyncData {

    @Value("${syncdata.characters}")
    private String characters;

    @Autowired
    private DataService characterService;

    @Autowired
    private InfoRepository infoRepository;

    @Scheduled(cron = "0 0 1 * * ?")
    /** This annotation specifies that the syncData()
    * method should be executed every hour at 1:00 AM.*/
    public void syncData() throws Exception {
        log.info("syncData : execution");

        Arrays.stream(characters.split(",")).forEach(character -> {
            Mono<CollaboratorsResponse> responseCollaborators = characterService.getCollaborators(character);
            Mono<CharactersResponse> responseCharacters = characterService.getCharacters(character);

            log.info("syncData : info : " + character + " : collaborators : " + responseCollaborators.block());
            log.info("syncData : info : " + character + " : characters : " + responseCharacters.block());

            ObjectMapper objectMapper = new ObjectMapper();


            Info infoChars = new Info();
            InfoID infoIDChars = new InfoID(character, "characters", new Date());

            String jsonChars = null;
            String jsonCollaborators = null;

            try {
                jsonChars = objectMapper.writeValueAsString(responseCharacters.block());
            } catch (JsonProcessingException e) {
                log.info(MAR_ERR_O4.getMessage());
                throw new MarvelException(MAR_ERR_O4.getCode(), MAR_ERR_O4.getMessage(), INTERNAL_SERVER_ERROR);
            }

            try {
                jsonCollaborators = objectMapper.writeValueAsString(responseCollaborators.block());
            } catch (JsonProcessingException e) {
                log.info(MAR_ERR_O4.getMessage());
                throw new MarvelException(MAR_ERR_O4.getCode(), MAR_ERR_O4.getMessage(), INTERNAL_SERVER_ERROR);
            }

            infoChars.setInfoId(infoIDChars);
            infoChars.setResponse(jsonChars);

            Info infoCollaborators = new Info();
            InfoID infoIDCollaborators = new InfoID(character, "collaborators", new Date());
            infoCollaborators.setInfoId(infoIDCollaborators);
            infoCollaborators.setResponse(jsonCollaborators);

            infoRepository.save(infoChars);
            infoRepository.save(infoCollaborators);
        });
    }

}