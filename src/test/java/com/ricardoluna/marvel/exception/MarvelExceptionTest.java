package com.ricardoluna.marvel.exception;

import com.ricardoluna.marvel.exceptions.Error;
import com.ricardoluna.marvel.exceptions.MarvelException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MarvelException.
 * This class contains unit tests to verify the correct behavior of the MarvelException class.
 */
class MarvelExceptionTest {

    @Test
    void testExceptionConstructorAndGetters() {
        String expectedCode = "TEST_CODE";
        String expectedMessage = "Test message";
        HttpStatus expectedStatus = HttpStatus.BAD_REQUEST;

        MarvelException exception = new MarvelException(expectedCode, expectedMessage, expectedStatus);

        assertEquals(expectedCode, exception.getCode());
        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(expectedStatus, exception.getHttpStatus());

        List<Error> expectedErrors = Collections.singletonList(new Error());
        exception.setErrors(expectedErrors);
        assertEquals(expectedErrors, exception.getErrors());

        String expectedDescription = "Test Description";
        exception.setDescription(expectedDescription);
        assertEquals(expectedDescription, exception.getDescription());
    }
}
