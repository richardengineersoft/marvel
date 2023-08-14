package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a collection or list of significant events within the Marvel Universe.
 * This list provides a summarized view of various events, making it easier to manage and refer to them collectively.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventList {

    /**
     * A list containing multiple events from the Marvel Universe.
     * Each event in this list provides a brief overview, typically with its name and a resource URI pointing to its full details.
     */
    private List<Event> items;

}
