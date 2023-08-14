package com.ricardoluna.marvel.objects;

import lombok.*;

/**
 * Represents the response returned from the Marvel API for character-related requests.
 *
 * <p>
 * This class encapsulates the overall structure of the response, including status
 * codes, copyright details, and the actual payload, which is the character data.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CharacterMarvelResponse {

    /**
     * The HTTP status code of the response.
     */
    private Integer code;

    /**
     * A textual description of the response status, typically 'Ok' if successful.
     */
    private String status;

    /**
     * The copyright statement for the returned data.
     */
    private String copyright;

    /**
     * A textual description of how to attribute the data in public presentations.
     */
    private String attributionText;

    /**
     * An HTML formatted string of attribution information.
     */
    private String attributionHTML;

    /**
     * The ETag header's value from the HTTP response. Useful for caching mechanisms.
     */
    private String etag;

    /**
     * The main payload of the response containing detailed Marvel character data.
     */
    private CharacterMarvelData data;

}