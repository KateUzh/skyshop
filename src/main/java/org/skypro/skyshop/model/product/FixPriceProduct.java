package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;
    private final UUID id;

    public FixPriceProduct(String productDesignation, UUID id) {
        super(productDesignation, id);
        this.id = id;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    public String toString() {
        return getProductDesignation() + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public UUID getId() {
        return id;
    }
}

