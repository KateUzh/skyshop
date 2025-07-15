package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;
    private final UUID id;


    public SimpleProduct(String productDesignation, int price, UUID id) {
        super(productDesignation, id);
        if (price <= 0) {
            throw new IllegalArgumentException("Недопустимое значение цены!");
        }
        this.price = price;
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public UUID getId() {
        return id;
    }
}