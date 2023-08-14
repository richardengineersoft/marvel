package com.ricardoluna.marvel.objects;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Represents a Marvel character with various attributes.
 *
 * <p>
 * This class provides a detailed representation of a Marvel character, including its
 * basic information, associated URLs, images, comics, stories, events, and series.
 * It can be used to capture and represent the character's data as retrieved from
 * external services, databases, or other sources.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CharacterMarvel {

    /**
     * The unique identifier for the Marvel character.
     */
    private Integer id;
    /**
     * The name of the Marvel character.
     */
    private String name;

    /**
     * A brief description or background about the character.
     */
    private String description;

    /**
     * The date when the character's information was last modified.
     */
    private Date modified;

    /**
     * The resource URI pointing to the character's detailed page.
     */
    private String resourceURI;

    /**
     * List of URLs associated with the character, including links to Wikipedia, Marvel's
     * official page, and other related sites.
     */
    private List<Url> urls;

    /**
     * Thumbnail image of the character.
     */
    private Image thumbnail;

    /**
     * List of comics associated with the character.
     */
    private ComicsList comics;

    /**
     * List of stories featuring the character.
     */
    private StoryList stories;

    /**
     * List of events in which the character has played a significant role.
     */
    private EventList events;

    /**
     * List of series that feature the character.
     */
    private SeriesList series;

}