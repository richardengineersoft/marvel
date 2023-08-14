package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents the various price points associated with a comic book.
 * Different editions or formats of a comic book might have different pricing,
 * and this class can be used to capture such details.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComicPrice {

    /**
     * Describes the type of the price. For example, it could be values like
     * "printPrice" indicating the cost of the physical edition, "digitalPrice"
     * for the online digital edition, or other relevant price types in the comic industry.
     */
    private String type;

    /**
     * Represents the actual price amount corresponding to the type in the currency
     * unit (e.g., USD). This indicates how much the comic costs for the specified type.
     */
    private float price;
}
