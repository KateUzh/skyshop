package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItem;
    private final int total;

    public UserBasket(List<BasketItem> basketItem) {
        this.basketItem = basketItem;
        this.total = calcTotal(basketItem);
    }

    public int calcTotal(List<BasketItem> basketItem) {
        return basketItem.stream()
                .mapToInt(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
    }

    public List<BasketItem> getBasketItem() {
        return basketItem;
    }

    public int getTotal() {
        return total;
    }
}
