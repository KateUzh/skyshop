package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ShopController {
    StorageService storageService = new StorageService();

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String pattern) {
        return this.storageService.getAllSearchable().stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getSearchTerm().contains(pattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
