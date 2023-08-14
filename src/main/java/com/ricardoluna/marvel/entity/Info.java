package com.ricardoluna.marvel.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an entity in the 'info' table within the 'data' schema of the database.
 *
 * This class serves as a Hibernate entity to map Java objects to database rows
 * and vice versa. The primary key for this entity is represented by the {@link InfoID}
 * embedded composite key.
 *
 * <p>
 * Always keep the entity and its corresponding table in sync to avoid ORM-related issues.
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="info", schema="data" )
public class Info {

    /**
     * Composite primary key for the 'info' entity, mapped as an embedded ID.
     */
    @EmbeddedId
    private InfoID infoId;

    /**
     * Represents the 'response' column in the 'info' table.
     * This field is mandatory and cannot be null in the database.
     */
    @Column(name = "response", nullable = false)
    private String response;


}