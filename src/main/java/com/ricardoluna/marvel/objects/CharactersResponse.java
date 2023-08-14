package com.ricardoluna.marvel.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents the response containing a list of Marvel characters and the last synchronization date.
 *
 * <p>
 * This class encapsulates a list of Marvel characters along with a timestamp indicating the last synchronization.
 * The timestamp can be helpful for clients to determine if they need to update their local data.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize
public class CharactersResponse {

    /**
     * A timestamp (usually in a specific string format) indicating the last time the data was synchronized.
     */
    @JsonProperty("last_sync")
    private String lastSync;

    /**
     * A list of {@link CharacterResponseInfo} objects that represent individual Marvel characters and their associated data.
     */
    @JsonProperty("characters")
    private List<CharacterResponseInfo> characters;

}