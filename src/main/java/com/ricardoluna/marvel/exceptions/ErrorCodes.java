package com.ricardoluna.marvel.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration representing various application error codes and their associated messages.
 *
 * <p>
 * This enum provides a centralized location for all application-specific error codes
 * and messages, allowing for easier management and consistency.
 * </p>
 */
@Getter
@AllArgsConstructor
public enum ErrorCodes {

    /**
     * Error code indicating that a character was not found for the given name.
     */
    MAR_ERR_O1("MAR_ERR_O1", "Character not found for name: "),

    /**
     * Error code indicating that no comics were found for the provided character ID.
     */
    MAR_ERR_O2("MAR_ERR_O2", "No comics found for character ID: "),

    /**
     * Error code indicating that no comics were found for the provided character ID.
     * Note: This seems redundant with MAR_ERR_O2 and might be an oversight.
     */
    MAR_ERR_O3("MAR_ERR_O3", "No comics found for character ID: "),

    /**
     * Error code indicating an error occurred while parsing characters during the data synchronization process.
     */
    MAR_ERR_O4("MAR_ERR_O4", "SycData : error parse chars ");

    private String code;
    private String message;

}