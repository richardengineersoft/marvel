package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a Marvel story, detailing its unique resource URI, name, and type.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Story {

    /**
     * URI that provides more details about the story.
     */
    private String resourceURI;

    /**
     * Name of the story.
     */
    private String name;

    /**
     * Type of the story, describing its nature or genre.
     */
    private String type;
}
