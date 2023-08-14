package com.ricardoluna.marvel.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

/**
 * Represents the character response information containing character's name and associated comics.
 *
 * <p>
 * This class provides a structured format for representing a Marvel character along with
 * a list of comics they are associated with.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonSerialize
public class CharacterResponseInfo {

    /**
     * The name of the Marvel character.
     */
    @JsonProperty("character")
    private String character;

    /**
     * A list of comic titles or identifiers that the character is associated with.
     */
    @JsonProperty("comics")
    private List<String> comics;
}
