package com.ricardoluna.marvel.objects;

import lombok.*;

import java.util.List;

/**
 * Represents the data associated with Marvel characters retrieved in paginated form.
 *
 * <p>
 * This class captures details about the pagination and the actual results (list of characters).
 * It provides a comprehensive view of the data fetched, often from APIs that return data
 * in a paginated manner. This includes details about the current offset, limit set
 * for retrieval, total number of records, count of the current set of results,
 * and the actual list of characters.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CharacterMarvelData {

    /**
     * The current offset (position) from where the results are started.
     */
    private Integer offset;

    /**
     * The limit for the number of results to be retrieved. This often
     * corresponds to the 'page size'.
     */
    private Integer limit;

    /**
     * The total number of records available.
     */
    private Integer total;

    /**
     * The number of results currently being displayed or fetched. This
     * is usually <= limit.
     */
    private Integer count;

    /**
     * The actual list of Marvel characters fetched in the current request.
     */
    private List<CharacterMarvel> results;

}

