package com.ricardoluna.marvel.objects;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a list of comics, typically used to encapsulate a collection of comic entities.
 * This provides a convenient way to group multiple comic entities together, making it easier
 * to manage and transport as a single unit.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ComicsList {

    /**
     * The list of comic entities. Each item in this list represents a distinct
     * comic with its own set of attributes.
     */
    private List<Comic> items;
}