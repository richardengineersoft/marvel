package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents metadata and a list of comics retrieved from the Marvel API or a database.
 * This class is designed to provide pagination and structure to the comic data, making
 * it easier to manage and display a large number of comic entries.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ComicData {

    /**
     * Represents the starting point for the current set of results. Essentially,
     * it determines the "page" you are on if you think in terms of pagination.
     * For example, if you have a limit of 10 and an offset of 20, you are looking
     * at records 21-30.
     */
    private Integer offset;

    /**
     * The maximum number of results that should be returned for the request.
     * It's a form of pagination that controls the size of the data subset.
     * For instance, if the limit is set to 10, only 10 comics (or less) will be returned.
     */
    private Integer limit;

    /**
     * Represents the total number of records available. It's useful when
     * you want to inform the user about the total number of comics or
     * to calculate the total number of "pages" for pagination purposes.
     */
    private Integer total;

    /**
     * Indicates the number of records in the current set. It can be equal
     * to or less than the limit. It's especially useful if the last set
     * of results contains fewer records than the specified limit.
     */
    private Integer count;

    /**
     * The list of comic records that match the criteria specified by the
     * offset and limit. This list contains the actual data being fetched
     * or displayed.
     */
    private List<Comic> results;


}
