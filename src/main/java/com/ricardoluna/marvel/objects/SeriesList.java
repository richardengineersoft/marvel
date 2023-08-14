package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a list of Marvel series, including details such as availability, count of returned items, and the collection URI.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SeriesList {

    /**
     * Number of available series.
     */
    private int available;

    /**
     * Number of returned series.
     */
    private int returned;

    /**
     * URI that provides more details about the collection of series.
     */
    private String collectionURI;

    /**
     * List of series items.
     */
    private List<Series> items;
}
