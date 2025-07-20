package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {
    private final Product products;
    private final int quantity;

    public BasketItem(Product products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }
}
