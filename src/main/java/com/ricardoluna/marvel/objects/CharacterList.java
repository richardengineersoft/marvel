package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a list of Marvel characters.
 *
 * <p>
 * This class acts as a container for a list of Marvel characters. It provides utility in scenarios where
 * a group of characters needs to be treated or manipulated as a single entity, especially during data
 * serialization/deserialization in contexts like REST API calls.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CharacterList {

    /**
     * List of Marvel characters. This can be an empty list but never null.
     */
    private List<CharacterMarvel> items;

}
