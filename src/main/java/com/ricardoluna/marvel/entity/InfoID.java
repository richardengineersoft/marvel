package com.ricardoluna.marvel.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents the composite primary key for the 'info' entity.
 *
 * This class defines the unique constraint for the 'info' entity and is
 * used as an embedded ID within the {@link Info} entity. The primary key
 * consists of character, context, and the synchronization date fields.
 *
 * <p>
 * As this class implements {@link Serializable}, it ensures the safe serialization
 * of its instances, which is essential for distributed systems or when storing
 * instances in a session.
 * </p>
 */
@Embeddable
public class InfoID implements Serializable {

    /**
     * Represents the character part of the composite key.
     */
    private String character;

    /**
     * Represents the context part of the composite key.
     */
    private String context;

    /**
     * Represents the synchronization timestamp part of the composite key.
     * This field indicates the time when the data was synchronized.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesync;

    /**
     * Constructs a new instance of InfoID with the provided key fields.
     *
     * @param character The character part of the key.
     * @param context   The context part of the key.
     * @param datesync  The synchronization timestamp part of the key.
     */
    public InfoID (String character, String context, Date datesync){
        this.character = character;
        this.context = context;
        this.datesync = datesync;
    }

    /**
     * Default constructor for JPA/Hibernate use.
     */
    public InfoID (){
    }
}