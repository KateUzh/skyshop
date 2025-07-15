package org.skypro.skyshop.model.search;


public class SearchResult {
    private final String id;
    private final String name;
    private final String typeContent;

    public SearchResult(String id, String name, String typeContent) {
        this.id = id;
        this.name = name;
        this.typeContent = typeContent;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId().toString(), searchable.getSearchTerm(), searchable.typeContent());
    }
}
