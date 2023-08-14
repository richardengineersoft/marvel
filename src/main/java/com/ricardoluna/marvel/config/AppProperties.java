package com.ricardoluna.marvel.config;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties class for Marvel API.
 * These properties are populated from application properties/yaml files
 * under the prefix "marvel.api".
 *
 * This class aids in providing a strongly-typed representation of
 * configuration properties.
 *
 * <p>
 * Note: It's recommended to always validate configuration properties
 * to fail-fast in case of wrong configurations.
 * </p>
 */
@ConfigurationProperties(prefix = "marvel.api")
@Getter
@Setter
@Validated
public class AppProperties {

    /**
     * Base URL endpoint for Marvel API.
     * This will be the root URL for all the API calls.
     */
    @NotNull
    private String baseurl;

    /**
     * Public API key for Marvel API.
     * This key is used in conjunction with the private key
     * to generate the hash required for API calls.
     */
    @NotNull
    private String key_public;

    /**
     * Private API key for Marvel API.
     * This key is used in conjunction with the public key
     * to generate the hash required for API calls.
     */
    @NotNull
    private String key_private;

}
