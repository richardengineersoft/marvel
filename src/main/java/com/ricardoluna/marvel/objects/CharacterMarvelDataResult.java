package com.ricardoluna.marvel.objects;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Represents an individual result of Marvel character data.
 *
 * <p>
 * This class encapsulates all the detailed attributes associated with a specific
 * Marvel character. It provides an in-depth view of a character, including their
 * unique identifier, name, description, and various associated details like stories,
 * events, and series.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CharacterMarvelDataResult {

    /**
     * The unique identifier for the Marvel character.
     */
    private Integer id;

    /**
     * The name of the Marvel character.
     */
    private String name;

    /**
     * A brief description of the Marvel character.
     */
    private String description;

    /**
     * The last date when the character's information was modified.
     */
    private Date modified;

    /**
     * The URI that points to the detailed resource about this character.
     */
    private String resourceURI;

    /**
     * List of associated URLs related to this character,
     * for instance, links to different character profiles or external references.
     */
    private List<Url> urls;

    /**
     * An image object that holds the thumbnail URL of the character.
     */
    private Image thumbnail;

    /**
     * List of comics associated with this character.
     */
    private ComicsList comics;

    /**
     * List of stories associated with this character.
     */
    private StoryList stories;

    /**
     * List of events in which this character has appeared.
     */
    private EventList events;

    /**
     * Series of comic issues where this character appears.
     */
    private SeriesList series;

}

