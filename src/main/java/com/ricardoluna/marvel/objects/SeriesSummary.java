package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a summary of a Marvel series,
 * providing essential details
 * such as its resource URI and name.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesSummary {

    /**
     * URI that provides more details about the series.
     */
    private String resourceURI;

    /**
     * Name of the series.
     */
    private String name;
}
