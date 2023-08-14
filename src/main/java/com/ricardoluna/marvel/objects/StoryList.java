package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a list of Marvel stories.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class StoryList {

    /**
     * A list containing multiple Marvel stories.
     */
    private List<Story> items;
}
