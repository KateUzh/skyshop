package org.skypro.skyshop.model.basket;

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
        products.put(productId, (products.computeIfAbsent(productId,k->0)+1));
    }

    public Map<UUID, Integer> getProductsInBasket() {
        return Collections.unmodifiableMap(products);
    }
}
