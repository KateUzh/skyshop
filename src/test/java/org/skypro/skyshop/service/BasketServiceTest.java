package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.error.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;
    @InjectMocks
    public BasketService basketService;

    @Test
    void givenNotExistentProduct_whenAddProduct_thenThrowException() {
        UUID testId = UUID.randomUUID();
        when(storageService.getProductById(testId)).thenReturn(Optional.empty());

        assertThrows(NoSuchProductException.class, () -> basketService.addProduct(testId));
    }

    @Test
    void givenExistentProduct_whenAddProduct() {
        UUID testId = UUID.randomUUID();
        Product product = mock(Product.class);

        when(storageService.getProductById(testId)).thenReturn(Optional.of(product));

        basketService.addProduct(testId);

        verify(productBasket, times(1)).addProduct(testId);
    }

    @Test
    void givenNullProduct_whenGetUserBasket_thenReturnEmptyProductBasket() {
        when(productBasket.getProductsInBasket()).thenReturn(Map.of());

        UserBasket result = basketService.getUserBasket();

        assertEquals(null, result);
    }

    @Test
    void givenProduct_whenGetUserBasket_thenReturnProductBasket() {
        UUID testId = UUID.randomUUID();
        Product product = new SimpleProduct("молоко", 100, testId);
        BasketItem basketItem = new BasketItem(product, 1);
        List<BasketItem> item = new ArrayList<>();
        item.add(basketItem);
        when(productBasket.getProductsInBasket()).thenReturn(Map.of(testId,1));

        UserBasket result = basketService.getUserBasket();

        assertEquals(new UserBasket(item), result);
    }
}