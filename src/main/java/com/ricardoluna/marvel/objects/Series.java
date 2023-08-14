package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a Marvel series with its resource URI and name.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Series {

    /**
     * URI to access more detailed information about the series.
     */
    private String resourceURI;

    /**
     * Name of the series.
     */
    private String name;
}
