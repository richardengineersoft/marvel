package com.ricardoluna.marvel.rest.controller;

import com.ricardoluna.marvel.config.AppProperties;
import com.ricardoluna.marvel.exceptions.MarvelException;
import com.ricardoluna.marvel.objects.CharacterMarvel;
import com.ricardoluna.marvel.objects.CollaboratorsResponse;
import com.ricardoluna.marvel.objects.Comic;
import com.ricardoluna.marvel.objects.CreatorSummary;
import com.ricardoluna.marvel.service.CharacterService;
import com.ricardoluna.marvel.utils.HelperDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ricardoluna.marvel.exceptions.ErrorCodes.MAR_ERR_O2;
import static com.ricardoluna.marvel.objects.MarvelApiRequest.getMarvelApiRequest;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Controller responsible for handling collaborator-related requests.
 * Provides endpoints to retrieve collaborator information (such as editors, colorists, and writers)
 * associated with a specific character from the Marvel API.
 */
@Controller
public class CollaboratorsController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private AppProperties appProp;

    /**
     * Retrieve collaborators information (editors, colorists, writers) by character's name.
     *
     * @param character Name of the character.
     * @return Mono<CollaboratorsResponse> containing details of the character's collaborators.
     */
    public Mono<CollaboratorsResponse> getCollaboratorsByName(final String character) {

        return characterService.getCharacterByName(getMarvelApiRequest(character, appProp.getBaseurl(),
                        appProp.getKey_private(), appProp.getKey_public()))
                .flatMap(characterMarvel -> {
                    Optional<CharacterMarvel> search = Optional.empty();

                    if (characterMarvel != null && characterMarvel.getData() != null
                            && characterMarvel.getData().getResults() != null) {
                        if (characterMarvel.getData().getResults().size() == 1) {
                            search = Optional.of(characterMarvel.getData().getResults().get(0));
                        } else {
                            search = characterMarvel.getData().getResults().stream()
                                    .filter(c -> c.getName() != null
                                            && character.equals(c.getName())).findFirst();
                        }
                    }

                    if (search.isEmpty()) {
                        throw new MarvelException(MAR_ERR_O2.getCode(), MAR_ERR_O2.getMessage(), NOT_FOUND);
                    }

                    return characterService.getCharacterComicsById(search.get().getId(),
                            getMarvelApiRequest(character, appProp.getBaseurl(),
                                    appProp.getKey_private(), appProp.getKey_public()));
                })
                .flatMap(comicsResponse -> {

                    List<Comic> comics = comicsResponse.getData().getResults();

                    final List<CreatorSummary> collect = comics.stream()
                            .flatMap(comic -> comic.getCreators().getItems().stream())
                            .collect(Collectors.toList());

                    final List<String> editorsList = collect.stream()
                            .filter(creator -> "Editor".equalsIgnoreCase(creator.getRole()))
                            .map(CreatorSummary::getName)
                            .collect(Collectors.toList());

                    final List<String> coloristList = collect.stream()
                            .filter(creator -> "Colorist".equalsIgnoreCase(creator.getRole()))
                            .map(CreatorSummary::getName)
                            .collect(Collectors.toList());

                    final List<String> writersList = collect.stream()
                            .filter(creator -> "Writer".equalsIgnoreCase(creator.getRole()))
                            .map(CreatorSummary::getName)
                            .collect(Collectors.toList());

                    return Mono.just(CollaboratorsResponse.builder()
                            .lastSync(HelperDate.getFormattedDate())
                            .publishers(editorsList.stream().toArray(String[]::new))
                            .colorists(coloristList.stream().toArray(String[]::new))
                            .writers(writersList.stream().toArray(String[]::new))
                            .build());
                });
    }

}