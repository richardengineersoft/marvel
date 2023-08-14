package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a significant occurrence or storyline within the Marvel Universe.
 * Events usually span multiple comics and bring together many characters, often having lasting impacts on the characters and the universe as a whole.
 */
@NoArgsConstructor  // Indicates that there's a no-args constructor for this class
@AllArgsConstructor  // Indicates that there's a constructor that initializes all fields
@Builder             // Provides a builder pattern for object creation
public class Event {

    /**
     * The URI (Uniform Resource Identifier) that points to the full details of the event.
     * This URI can be used to fetch more comprehensive information about the event.
     */
    private String resourceURI;

    /**
     * The name or title of the event. This provides a concise way to refer to the event and is used for identification purposes.
     */
    private String name;

}
