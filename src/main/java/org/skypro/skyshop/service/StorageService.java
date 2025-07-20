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

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    private void addToShop() {

        Product milk = new SimpleProduct("молоко", 100, UUID.randomUUID());
        Product banana = new SimpleProduct("банан", 50, UUID.randomUUID());
        Product chocolate = new SimpleProduct("шоколад", 150, UUID.randomUUID());
        Product carrot = new DiscountedProduct("морковь", 30, 30, UUID.randomUUID());
        Product blueberry = new DiscountedProduct("черника", 220, 30,
                UUID.randomUUID());
        Product chicken = new FixPriceProduct("курица", UUID.randomUUID());
        Article blackTeaArticle = new Article("Чай", "Чёрный крупнолистовой чай без добавок",
                UUID.randomUUID());
        Article greenTeaArticle = new Article("Чай", "Зелёный крупнолистовой чай без добавок",
                UUID.randomUUID());
        Article coffeeArticle = new Article("Кофе", "Молотый кофе", UUID.randomUUID());

        products.put(milk.getId(), milk);
        products.put(banana.getId(), banana);
        products.put(chocolate.getId(), chocolate);
        products.put(carrot.getId(), carrot);
        products.put(blueberry.getId(), blueberry);
        products.put(chicken.getId(), chicken);
        articles.put(blackTeaArticle.getId(), blackTeaArticle);
        articles.put(greenTeaArticle.getId(), greenTeaArticle);
        articles.put(coffeeArticle.getId(), coffeeArticle);
    }
}
