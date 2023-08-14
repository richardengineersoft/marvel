package com.ricardoluna.marvel.rest.controller;

import com.ricardoluna.marvel.config.AppProperties;
import com.ricardoluna.marvel.exceptions.MarvelException;
import com.ricardoluna.marvel.objects.CharacterResponseInfo;
import com.ricardoluna.marvel.objects.CharactersResponse;
import com.ricardoluna.marvel.service.CharacterService;
import com.ricardoluna.marvel.utils.HelperDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ricardoluna.marvel.exceptions.ErrorCodes.MAR_ERR_O1;
import static com.ricardoluna.marvel.exceptions.ErrorCodes.MAR_ERR_O2;
import static com.ricardoluna.marvel.objects.MarvelApiRequest.getMarvelApiRequest;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Controller responsible for handling character-related requests.
 * Provides endpoints to retrieve character information by name
 * and associated comic data from the Marvel API.
 */
@Controller
public class CharactersController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private AppProperties appProp;

    /**
     * Retrieve character information by its name and associated comics.
     *
     * @param character Name of the character.
     * @return Mono<CharactersResponse> containing character details and associated comics.
     */
    public Mono<CharactersResponse> getCharactersByName(final String character) {

        return characterService.getCharacterByName(
                        (getMarvelApiRequest(character, appProp.getBaseurl(),
                                appProp.getKey_private(), appProp.getKey_public()))
                )
                .flatMap(characterMarvelResponse -> {
                    if (characterMarvelResponse != null &&
                            characterMarvelResponse.getData() != null &&
                            !characterMarvelResponse.getData().getResults().isEmpty()) {

                        int idCharacter = characterMarvelResponse.getData().getResults().get(0).getId();

                        return characterService.getCharacterComicsById(idCharacter,
                                        getMarvelApiRequest(character, appProp.getBaseurl(),
                                                appProp.getKey_private(), appProp.getKey_public()))
                                .flatMap(comicResponse -> {

                                    if (comicResponse != null &&
                                            comicResponse.getData() != null &&
                                            !comicResponse.getData().getResults().isEmpty()) {
                                        Map<String, CharacterResponseInfo> groupChars = new HashMap<>();

                                        comicResponse.getData().getResults().stream().forEach(comicResult -> {
                                            comicResult.getCharacters().getItems().stream().forEach(charComic -> {
                                                CharacterResponseInfo charTarget = groupChars.get(charComic.getName());
                                                if (charTarget == null) {
                                                    charTarget = new CharacterResponseInfo();
                                                    charTarget.setCharacter(charComic.getName());
                                                    List<String> comicsChar = new ArrayList<>();
                                                    charTarget.setComics(comicsChar);
                                                    groupChars.put(charComic.getName(), charTarget);
                                                }
                                                charTarget.getComics().add(comicResult.getTitle());
                                            });
                                        });

                                        return Mono.just(CharactersResponse.builder()
                                                .lastSync(HelperDate.getFormattedDate())
                                                .characters(groupChars.values().stream().toList())
                                                .build());
                                    } else {
                                        throw new MarvelException(MAR_ERR_O2.getCode(), MAR_ERR_O2.getMessage(), NOT_FOUND);
                                    }
                                });
                    } else {
                        throw new MarvelException(MAR_ERR_O1.getCode(), MAR_ERR_O1.getMessage(), NOT_FOUND);
                    }
                });
    }

}
