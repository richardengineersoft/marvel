package com.ricardoluna.marvel;

import com.ricardoluna.marvel.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Entry point for the Marvel API Spring Boot Application.
 * This class initializes the Spring Boot application and makes it ready for incoming HTTP requests.
 * Additionally, it enables configuration properties to be used throughout the application.
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MarvelApiApplication {

	/**
	 * Main method which serves as the entry point for the Java application.
	 *
	 * @param args String .
	 */
	public static void main(String[] args) {
		SpringApplication.run(MarvelApiApplication.class, args);
	}

}
