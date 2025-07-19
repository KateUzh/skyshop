package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Article> articles;
    private final Map<UUID, Product> products;

    public StorageService() {
        this.articles = new HashMap<>();
        this.products = new HashMap<>();
        addToShop();
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public Collection<Article> getArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchable() {
        Set<Searchable> searchables = new HashSet<>();
        searchables.addAll(products.values());
        searchables.addAll(articles.values());
        return searchables;
    }

    private void addToShop() {
        products.put(UUID.randomUUID(), new SimpleProduct("молоко", 100, UUID.randomUUID()));
        products.put(UUID.randomUUID(), new SimpleProduct("банан", 50, UUID.randomUUID()));
        products.put(UUID.randomUUID(), new DiscountedProduct("морковь", 30, 30,
                UUID.randomUUID()));
        products.put(UUID.randomUUID(), new DiscountedProduct("черника", 220, 30,
                UUID.randomUUID()));
        products.put(UUID.randomUUID(), new FixPriceProduct("курица", UUID.randomUUID()));
        articles.put(UUID.randomUUID(), new Article("Чай",
                "Чёрный крупнолистовой чай без добавок", UUID.randomUUID()));
        articles.put(UUID.randomUUID(), new Article("Чай",
                "Зелёный крупнолистовой чай без добавок", UUID.randomUUID()));
        articles.put(UUID.randomUUID(), new Article("Кофе", "Молотый кофе", UUID.randomUUID()));
    }
}
