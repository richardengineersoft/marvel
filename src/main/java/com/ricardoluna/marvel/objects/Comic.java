package com.ricardoluna.marvel.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Marvel comic book and its various attributes.
 *
 * <p>
 * This class captures detailed information about a single Marvel comic issue, including its
 * identification details, title, descriptions, related URLs, series summary, and various other
 * associated attributes such as its creators, characters, stories, and events.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comic {

    /**
     * The unique ID of the comic.
     */
    private Integer id;
    /**
     * The unique digital ID of the comic for online versions.
     */
    private Integer digitalId;
    /**
     * The title or name of the comic issue.
     */
    private String title;

    /**
     * The issue number for this comic. This represents the chronological order
     * of this comic within a series. Fractional values are possible for
     * intermediary or special issues.
     */
    private Double issueNumber;

    /**
     * A description or subtitle for variants of the main comic.
     * For instance, a variant might have a different cover art
     * or other distinguishing feature from the main comic issue.
     */
    private String variantDescription;

    /**
     * A textual description or summary of the comic's storyline, themes, or events.
     */
    private String description;

    /**
     * The date or timestamp when the comic's information was last modified.
     * It could be in a format like "YYYY-MM-DD HH:MM:SS".
     */
    private String modified;

    /**
     * The International Standard Book Number (ISBN) for the comic. This is a unique identifier
     * typically used for books, but it can also be assigned to comics or graphic novels.
     * It helps in cataloging and tracking publications.
     */
    private String isbn;

    /**
     * The Universal Product Code (UPC) for the comic. This is a barcode symbology used for
     * tracking trade items in stores. In the context of comics, it often appears on the
     * cover and is used for inventory and sales tracking.
     */
    private String upc;

    /**
     * The Diamond Distribution code assigned to the comic. Diamond Comic Distributors
     * is a major distributor of English-language comic books, and they assign unique codes
     * to products to help retailers order copies.
     */
    private String diamondCode;

    /**
     * The European Article Number (EAN) for the comic. It's similar to the UPC
     * but is used more broadly internationally. It's a 13-digit barcode standard
     * which includes the country of origin and a check digit.
     */
    private String ean;

    /**
     * The International Standard Serial Number (ISSN) for the comic or series.
     * This is a unique eight-digit identifier used to classify serial publications,
     * such as magazines or journals. For comics, it might apply to periodicals
     * or recurring series.
     */
    private String issn;

    /**
     * The format in which the comic is presented. This can include types like
     * "Paperback", "Hardcover", "Digital", etc. It provides insight into the physical
     * or digital presentation of the comic.
     */
    private String format;

    /**
     * The total number of pages in the comic, including all content like advertisements,
     * letter pages, and backup stories. It provides a measure of the comic's length.
     */
    private Integer pageCount;

    /**
     * A list of textual elements associated with the comic. This could include things
     * like introductions, summaries, or other descriptive text that provides more
     * context or detail about the comic's content or themes.
     */
    private List<TextObject> textObjects;

    /**
     * The canonical URL identifier for this comic. The resourceURI is a unique link to
     * the specific resource within the Marvel API that provides more details about
     * this particular comic.
     */
    private String resourceURI;

    /**
     * A list of URLs related to the comic. These can include links to the Marvel website,
     * digital purchase pages, or other online resources where more information or
     * purchase options for the comic are available.
     */
    private List<Url> urls;

    /**
     * Summary information about the series to which this comic belongs. The series
     * provides broader context by grouping related comics together, often telling
     * an overarching story or theme across multiple issues.
     */
    private SeriesSummary series;

    /**
     * A list of variant covers for this comic. Variants are alternative versions
     * of a comic issue, often featuring different cover artwork or other collectible
     * distinctions. They're commonly used for promotional purposes or to commemorate
     * special events.
     */
    private List<ComicSummary> variants;

    /**
     * A list of comic collections that include this comic issue. Collections
     * typically group multiple issues together, often in a bound format like
     * a trade paperback or hardcover, which can represent a complete story arc
     * or a selection of related stories.
     */
    private List<ComicSummary> collections;

    /**
     * A list of individual comic issues that are included within this collection.
     * For example, a trade paperback might collect several individual issues of
     * a comic series into one volume. This attribute helps to identify which
     * specific issues are part of this collective volume.
     */
    private List<ComicSummary> collectedIssues;

    /**
     * A list of key dates associated with this comic, such as its original publication
     * date, digital release date, or any other relevant milestones. Each date is
     * typically paired with a descriptive label to clarify its significance.
     */
    private List<ComicDate> dates;

    /**
     * A list of prices for this comic. This can include the original print price,
     * digital purchase price, or any other relevant pricing information. Each price
     * is typically associated with a type or label, such as "print price" or
     * "digital purchase".
     */
    private List<ComicPrice> prices;

    /**
     * A representative image (often the cover art) for this comic. Thumbnails are
     * typically smaller, optimized versions of the main image used for previews
     * and listings. It provides a quick visual reference for readers to recognize
     * the comic.
     */
    private Image thumbnail;

    /**
     * A list of images related to this comic. This can include variant covers,
     * interior page previews, or any other artwork associated with this issue.
     * These images allow readers to get a deeper visual insight into the comic's content.
     */
    private List<Image> images;

    /**
     * A comprehensive list of individuals who contributed to the creation of this
     * comic. This includes writers, artists, colorists, letterers, and other key roles.
     * The CreatorList object encapsulates detailed information about each creator's
     * contribution, helping to give credit to the talents behind the comic.
     */
    private CreatorList creators;

    /**
     * A list of all the characters that appear in this comic. This can range
     * from main characters to minor characters. The CharacterList object provides
     * details about each character's name, appearance, and significance within the story.
     * This helps readers to identify familiar faces or get introduced to new ones.
     */
    private CharacterList characters;

    /**
     * A detailed breakdown of the narrative arcs or subplots within this comic.
     * The StoryList encompasses individual story elements, from main plots to
     * side stories, giving readers an overview of the narrative structure and themes.
     * Each story in this list might have its own title, description, and importance.
     */
    private StoryList stories;

    /**
     * All the significant events or crossovers that this comic is a part of or
     * references. Events in the Marvel universe are major story arcs that span
     * multiple issues and often involve multiple characters or teams. The EventList
     * gives readers context about the larger narratives in which this comic plays a role.
     */
    private EventList events;

}
