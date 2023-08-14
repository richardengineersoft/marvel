package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a list of creators associated with a particular Marvel entity, such as a comic or a character.
 * This list provides an overview of the creators involved, with summarized details about each creator.
 */
@NoArgsConstructor  // Indicates that there's a no-args constructor for this class
@AllArgsConstructor  // Indicates that there's a constructor that initializes all fields
@Getter              // Provides getter methods for all fields
@Builder             // Provides a builder pattern for object creation
public class CreatorList {

    /**
     * The total number of creators available for the associated Marvel entity.
     */
    private int available;

    /**
     * The number of creator summaries actually returned in the 'items' list.
     * This can be less than the 'available' count if pagination or filtering is applied.
     */
    private int returned;

    /**
     * The URI (Uniform Resource Identifier) that points to the full list of creators for the associated Marvel entity.
     * This URI can be used to fetch more detailed or complete list of creators.
     */
    private String collectionURI;

    /**
     * A list of summarized creator details. Each summary provides a concise overview of a creator's involvement.
     */
    private List<CreatorSummary> items;

}
