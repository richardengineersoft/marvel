package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents a summarized view of a comic, providing a concise overview of the comic's details.
 * This summary view is particularly useful when a detailed view of the comic is not necessary,
 * for instance, when listing multiple comics in a compact manner.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicSummary {

    /**
     * The URI (Uniform Resource Identifier) that provides a unique reference to this comic.
     * It can be used to retrieve more detailed information about the comic if needed.
     */
    private String resourceURI;

    /**
     * The name or title of the comic. Provides a quick identification for users or systems.
     */
    private String name;

    }