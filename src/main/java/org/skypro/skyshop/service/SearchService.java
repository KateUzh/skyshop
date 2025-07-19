package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> searchTerm(String term) {
        return this.storageService.getAllSearchable().stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getSearchTerm().contains(term))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
