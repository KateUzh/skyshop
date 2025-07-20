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
        if (products.containsKey(productId)) {
            products.put(productId, products.get(productId) + 1);
        } else products.put(productId, 1);
    }

    public Map<UUID, Integer> getProductsInBasket() {
        return Collections.unmodifiableMap(products);
    }
}
