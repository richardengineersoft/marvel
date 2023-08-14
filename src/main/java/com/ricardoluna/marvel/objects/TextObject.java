package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a text object containing type, language, and the actual text.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextObject {

    /**
     * The type of the text object (e.g. "synopsis", "solicit text").
     */
    private String type;

    /**
     * The language of the text.
     */
    private String language;

    /**
     * The actual content of the text.
     */
    private String text;
}
