package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents the structured response received after fetching comic details from an API or service.
 * This encapsulates all the meta information and the actual data related to the comic.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ComicResponse {

    /**
     * The HTTP response code received from the server, indicating
     * the success or failure status of the request.
     */
    private Integer code;

    /**
     * Human-readable string providing a brief description of the response.
     * Examples include "Success", "Not Found", etc.
     */
    private String status;

    /**
     * Contains copyright information pertaining to the data or
     * the entity providing the data.
     */
    private String copyright;

    /**
     * A brief line of text that must be displayed to users attributing the source
     * of the data or the entity providing the data.
     */
    private String attributionText;

    /**
     * A more detailed HTML string that must be displayed to users attributing
     * the source of the data or the entity providing the data.
     */
    private String attributionHTML;

    /**
     * ETag (Entity Tag) is used for web caches. It can be considered as a
     * fingerprint of the content, and is a unique identifier assigned to the version of the content.
     */
    private String etag;

    /**
     * The primary data of the response, encapsulating detailed comic-related
     * information like the list of comics, pagination details, etc.
     */
    private ComicData data;
}
