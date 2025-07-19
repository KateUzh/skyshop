package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;
    private final UUID id;

    public DiscountedProduct(String productDesignation, int basePrice, int discount, UUID id) {
        super(productDesignation, id);
        this.id = id;
        if ((basePrice <= 0) || (discount < 0) || (discount > 100)) {
            throw new IllegalArgumentException("Недопустимое значение цены или скидки!");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount) / 100;
    }

    @Override
    public String toString() {
        return getProductDesignation() + ": " + basePrice + " (" + discount + "%)";
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
