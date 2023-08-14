package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents the various dates associated with a comic book.
 * Comics might have different significant dates such as on-sale date,
 * digital publication date, etc., which can be captured using this class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicDate {

    /**
     * Describes the type of date. It could be values like "onsaleDate"
     * indicating the date the comic was first available for purchase,
     * "focDate" which is the final order cutoff date, or other types
     * significant in the comic industry.
     */
    private String type;

    /**
     * Represents the actual date corresponding to the type.
     * This provides the specific day, month, and year of the event.
     */
    private Date date;
}
