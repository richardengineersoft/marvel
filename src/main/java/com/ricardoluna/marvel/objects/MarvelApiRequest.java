package com.ricardoluna.marvel.objects;


import com.ricardoluna.marvel.exceptions.MarvelException;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.Instant;

import static com.ricardoluna.marvel.exceptions.ErrorCodes.MAR_ERR_O3;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Represents a request made to the Marvel API.
 * This class encapsulates all required parameters and helper methods to generate a request.
 */
@Builder
@Getter
public class MarvelApiRequest {

    private String nameCharacter;
    private String baseUrl;
    private String privateKey;
    private String publicKey;
    private String ts;
    private String hash;

    /**
     * Creates and returns a MarvelApiRequest object.
     *
     * @param name        Character's name.
     * @param baseUrl     The base URL of the API.
     * @param privateKey  The private API key.
     * @param publicKey   The public API key.
     * @return            A new MarvelApiRequest object.
     */
    public static MarvelApiRequest getMarvelApiRequest(final String name,
                                                       final String baseUrl,
                                                       final String privateKey,
                                                       final String publicKey) {
        final String ts = generateTs();
        final String hash = generateHash(ts, privateKey, publicKey);

        return MarvelApiRequest.builder()
                .nameCharacter(formatName(name))
                .baseUrl(baseUrl)
                .privateKey(privateKey)
                .publicKey(publicKey)
                .ts(ts)
                .hash(hash)
                .build();
    }

    /**
     * Formats a given name based on some specific rules.
     *
     * @param input   The character's name.
     * @return        Formatted name based on provided rules.
     */
    private static String formatName(final String input) {

        if (input == null) {
            throw new MarvelException(MAR_ERR_O3.getCode(), MAR_ERR_O3.getMessage(), BAD_REQUEST);
        }

        if ("capamerica".equalsIgnoreCase(input)) {
            return "Captain America";
        }

        if (input.toLowerCase().endsWith("man")) {
            return capitalizeFirstLetter(input.substring(0, input.length() - 3))
                    + " Man";
        }
        return input;
    }

    /**
     * Capitalizes the first letter of the given string.
     *
     * @param str   The input string.
     * @return      String with the first letter capitalized.
     */
    private static String capitalizeFirstLetter(final String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1)
                .toUpperCase() + str.substring(1)
                .toLowerCase();
    }

    /**
     * Generates the MD5 hash used for Marvel API authentication.
     *
     * @param ts           The timestamp.
     * @param privateKey   The private API key.
     * @param publicKey    The public API key.
     * @return             MD5 hash.
     */
    private static String generateHash(String ts, String privateKey, String publicKey) {

        return
                DigestUtils
                        .md5Hex(generateTs() + privateKey +
                                publicKey);
    }

    /**
     * Generates a timestamp based on current epoch seconds.
     *
     * @return   The timestamp string.
     */
    private static String generateTs() {
        return String.valueOf(Instant.now().getEpochSecond());
    }


}
