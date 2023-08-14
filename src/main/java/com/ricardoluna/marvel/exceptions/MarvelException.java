package com.ricardoluna.marvel.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Custom exception class for handling Marvel application specific errors.
 *
 * <p>
 * This exception encapsulates error details like error code, message, and an associated HTTP status.
 * This can be useful for returning standardized error responses in a REST API context.
 * </p>
 */
@Getter
@Setter
public class MarvelException extends RuntimeException {

    /**
     * Unique error code associated with the exception.
     */
    private String code;

    /**
     * Message detailing the nature of the exception.
     */
    private String message;

    /**
     * Extended description providing more insights about the exception. This is optional and can be null.
     */
    private String description;

    /**
     * List of errors that could be associated with this exception. Useful in scenarios where multiple
     * validation or business logic errors need to be collected and returned at once.
     */
    private List<Error> errors;

    /**
     * HTTP status that should be returned to the client when this exception is thrown.
     */
    private HttpStatus httpStatus;

    /**
     * Constructor to initialize the exception with a specific error code, custom message, and an associated HTTP status.
     *
     * @param code Unique error code associated with the exception.
     * @param customMessage Message detailing the nature of the exception.
     * @param httpStatus HTTP status that should be returned to the client.
     */
    public MarvelException(final String code, final String customMessage, final HttpStatus httpStatus) {
        this.code = code;
        this.message = customMessage;
        this.httpStatus = httpStatus;
    }
}
