package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket basket;
    private final StorageService storageService;

    public BasketService(ProductBasket basket, StorageService storageService) {
        this.basket = basket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        if (storageService.getProductById(id).isEmpty()) {
            throw new IllegalArgumentException("Такого продукта нет в нашем магазине");
        }
        basket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = basket.getProductsInBasket()
                .entrySet()
                .stream()
                .map(pr -> new BasketItem(storageService.getProductById(pr.getKey()).orElseThrow(),
                        pr.getValue()))
                .toList();
        return new UserBasket(items);
    }
}
