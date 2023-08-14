package com.ricardoluna.marvel.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Represents an application error.
 *
 * This class captures details of an error, including its code, message,
 * severity level, and a detailed description. By implementing {@link Serializable},
 * it ensures the safe serialization of its instances, which can be essential for
 * distributed systems or when storing instances in a session.
 *
 * <p>
 * With the {@link Accessors} annotation, this class supports method chaining
 * which can be useful for constructing instances in a fluid manner.
 * </p>
 *
 * Example:
 * <pre>
 * Error error = new Error().setCode("404")
 *                          .setMessage("Not Found")
 *                          .setLevel("WARNING")
 *                          .setDescription("The requested resource was not found.");
 * </pre>
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Error implements Serializable {

    /** Serialization version UID. */
    private static final long serialVersionUID = 6120691971784445989L;

    /**
     * Represents the unique code of the error.
     */
    @JsonProperty("code")
    private String code;

    /**
     * Contains a brief human-readable message about the error.
     */
    @JsonProperty("message")
    private String message;

    /**
     * Indicates the severity level of the error.
     */
    @JsonProperty("level")
    private String level;

    /**
     * Provides a detailed description about the error.
     */
    @JsonProperty("description")
    private String description;
}