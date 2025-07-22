package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> products;

    public ProductBasket(Map<UUID, Integer> products) {
        this.products = new HashMap<>();
    }

    public void addProduct(UUID productId) {
        products.computeIfPresent(productId, (k, v) -> (v + 1));
        products.computeIfAbsent(productId, (k) -> (1));
    }

    public Map<UUID, Integer> getProductsInBasket() {
        return Collections.unmodifiableMap(products);
    }
}
