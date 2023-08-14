package com.ricardoluna.marvel.utils;

import org.junit.jupiter.api.Test;

import static com.ricardoluna.marvel.utils.HelperDate.getFormattedDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for MarvelApiUtils. This class focuses on testing utility methods
 * related to Marvel API operations. Each method in the MarvelApiUtils class should have
 * corresponding test cases here to ensure their functionality under different scenarios.
 */
public class MarvelApiUtilsTest {

    @Test
    public void testGetFormattedDate() {
        String formattedDate = getFormattedDate();
        assertNotNull(formattedDate);
        assertTrue(formattedDate.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}"));
    }

}
