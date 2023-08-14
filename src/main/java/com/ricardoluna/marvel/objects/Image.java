package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents an image resource from the Marvel universe. This class captures essential
 * image details, including its path and extension, enabling efficient image management and retrieval.
 * Typically used to depict various Marvel entities like characters, comics, events, etc.
 */
@NoArgsConstructor  // Indicates that there's a no-argument constructor for this class
@AllArgsConstructor  // Indicates that there's a constructor that initializes all fields
@Builder             // Provides a builder pattern for object creation
public class Image {

    /**
     * The path for the image, excluding the file extension. This is usually the base URL
     * where the image can be accessed. Combine with the extension to get the full URL.
     */
    private String path;

    /**
     * The file extension for the image (e.g., "jpg", "png"). This should be combined
     * with the path to retrieve the actual image.
     */
    private String extension;

}
