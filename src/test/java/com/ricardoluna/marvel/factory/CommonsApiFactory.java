package com.ricardoluna.marvel.factory;

import com.ricardoluna.marvel.objects.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * CommonsApiFactory class to manage common functionalities for the API.l
 *
 */
public class CommonsApiFactory {


    public static ComicResponse getFactoryComicResponse() {
        return ComicResponse.builder()
                .code(200)
                .status("Ok")
                .copyright("2023 Marvel")
                .attributionText("Data provided by Marvel. © 2023 Marvel")
                .attributionHTML("<a href='https://www.marvel.com'>Data provided by Marvel. © 2023 Marvel</a>")
                .etag("someEtagValue")
                .data(dummyComicData())
                .build();
    }

    private static ComicData dummyComicData() {

        return
                ComicData.builder()
                        .offset(0)
                        .limit(10)
                        .total(100)
                        .count(10)
                        .results(singletonList(Comic.builder()
                                .id(1)
                                .title("Spider-Man")
                                .description("A comic about Spider-Man.")
                                .issueNumber(1.0)
                                .pageCount(32)
                                .creators(dummyCreatorList())
                                .characters(createSampleCharacterList())
                                .build()))
                        .build();
    }

    private static CharacterList createSampleCharacterList() {
        return CharacterList.builder()
                .items(List.of(createSampleCharacterMarvel()))
                .build();
    }

    private static CharacterMarvel createSampleCharacterMarvel() {
        return CharacterMarvel.builder()
                .id(1011334)
                .name("Spider-Man")
                .description("Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles.")
                .modified(new Date())
                .resourceURI("http://gateway.marvel.com/v1/public/characters/1011334")
                .urls(List.of(createSampleUrl()))
                .thumbnail(createSampleThumbnail())
                .comics(createSampleComicsList())
                .stories(createSampleStoryList())
                .events(createSampleEventList())
                .series(createSampleSeriesList())
                .build();
    }

    private static Url createSampleUrl() {
        return
                Url.builder()
                        .url("http://gateway.marvel.com/v1/").type("zip").build();
    }

    private static CreatorList dummyCreatorList() {

        return
                CreatorList.builder()
                        .available(1)
                        .returned(1)
                        .items(singletonList(CreatorSummary.builder()
                                .name("Stan Lee")
                                .build()))
                        .build();
    }

    private static Series createSampleSeries() {
        return Series.builder().
                resourceURI("http://example.com/series/the-amazing-spiderman")
                .name("comic")
                .build();
    }


    private static SeriesList createSampleSeriesList() {
        return SeriesList.builder()
                .available(1)
                .returned(1)
                .collectionURI("http://example.com/seriesURI")
                .items(singletonList(createSampleSeries()))
                .build();
    }

    private static EventList createSampleEventList() {
        return EventList.builder()
                .items(singletonList(
                        Event.builder().name("Spider man")
                                .resourceURI("http://example.com/seriesURI")
                                .build()))
                .build();
    }

    private static StoryList createSampleStoryList() {
        return StoryList.builder()
                .items(singletonList(
                        Story.builder().type("comic").name("Hulk").resourceURI("http://example.com/seriesURI")
                                .build()))
                .build();
    }

    private static ComicsList createSampleComicsList() {
        return ComicsList.builder()
                .items(singletonList(
                        Comic.builder().resourceURI("http://example.com/seriesURI")
                                .build()))
                .build();
    }

    private static Image createSampleThumbnail() {
        return Image.builder()
                .extension("jpg").path("localhost")
                .build();
    }

    private static CharacterMarvel getCharacterMarvel() {

        return CharacterMarvel.builder()
                .id(1)
                .name("Spiderman")
                .description("A superhero with spider-like abilities.")
                .modified(new Date())
                .resourceURI("http://marvel.com/characters/1")
                .build();
    }


    private static CharacterMarvelData getCharacterMarvelData() {

        return CharacterMarvelData.builder()
                .offset(0)
                .limit(10)
                .total(100)
                .count(10)
                .results(Arrays.asList(getCharacterMarvel()))
                .build();
    }


    public static CharacterMarvelResponse getCharacterMarvelResponse() {

        return CharacterMarvelResponse.builder()
                .code(200)
                .status("OK")
                .copyright("Copyright 2023 Marvel.")
                .attributionText("Data provided by Marvel. © 2023 Marvel")
                .etag("some_etag_value")
                .data(getCharacterMarvelData())
                .build();
    }

    public static MarvelApiRequest getMarvelApiRequest() {
        return
                MarvelApiRequest.
                        getMarvelApiRequest("Iron Man",
                                "http://api.example.com",
                                "privateKeyHere",
                                "publicKeyHere");

    }

}


