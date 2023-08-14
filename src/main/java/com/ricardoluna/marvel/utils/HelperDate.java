package com.ricardoluna.marvel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class providing helper methods related to date and time operations.
 * This class is designed to abstract common date-related tasks and offer a centralized way to handle date formatting.
 */
public class HelperDate {

    /**
     * Returns the current date and time in a predefined format: "dd/MM/yyyy HH:mm:ss".
     *
     * @return A formatted string representing the current date and time.
     */
    public static String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

}
