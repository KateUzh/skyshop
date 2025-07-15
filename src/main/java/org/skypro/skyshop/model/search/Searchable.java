package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    String getSearchTerm();

    String typeContent();

    UUID getId();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + typeContent();
    }
}