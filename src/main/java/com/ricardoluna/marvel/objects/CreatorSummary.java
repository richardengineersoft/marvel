package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a summary of a creator's details in the Marvel Universe.
 * This summary provides a brief overview of a creator's involvement and can be associated with various Marvel entities such as comics, characters, etc.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CreatorSummary {

    /**
     * The URI (Uniform Resource Identifier) that points to the full details of the creator.
     * This URI can be used to fetch more comprehensive information about the creator.
     */
    private String resourceURI;

    /**
     * The name of the creator. This could be the full name or a pseudonym, depending on the creator's preference or Marvel's documentation.
     */
    private String name;

    /**
     * Describes the role or contribution of the creator in the associated Marvel entity.
     * Examples of roles include "writer", "illustrator", "inker", etc.
     */
    private String role;

}
