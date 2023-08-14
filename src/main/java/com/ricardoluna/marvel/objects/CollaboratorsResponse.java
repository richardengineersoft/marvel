package com.ricardoluna.marvel.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents the response containing a list of Marvel comics collaborators and the last synchronization date.
 *
 * <p>
 * This class encapsulates information about various collaborators involved in creating Marvel comics,
 * such as editors (publishers), writers, and colorists. It also includes a timestamp indicating
 * the last synchronization of this data.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize
public class CollaboratorsResponse {

    /**
     * A timestamp (usually in a specific string format) indicating the last time the data was synchronized.
     */
    @JsonProperty("last_sync")
    private String lastSync;

    /**
     * An array of names representing the editors or publishers associated with Marvel comics.
     */
    @JsonProperty("editors")
    private String[] publishers;

    /**
     * An array of names representing the writers associated with Marvel comics.
     */
    @JsonProperty("writers")
    private String[] writers;

    /**
     * An array of names representing the colorists who contributed to the visual aspect of Marvel comics.
     */
    @JsonProperty("colorists")
    private String[] colorists;


}
