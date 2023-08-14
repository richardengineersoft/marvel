package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a URL object with a type and the actual URL.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {

    /**
     * The type of the URL (e.g. "detail", "wiki").
     */
    private String type;

    /**
     * The actual URL.
     */
    private String url;
}
