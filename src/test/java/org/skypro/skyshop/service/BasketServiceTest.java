package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

        assertEquals(0, result.getTotal());
    }

    @Test
    void givenProduct_whenGetUserBasket_thenReturnProductBasket() {
        UUID testId = UUID.randomUUID();
        Product product = new SimpleProduct("молоко", 155, testId);
        Map<UUID, Product> products = new HashMap<>();
        products.put(testId, product);
        when(productBasket.getProductsInBasket()).thenReturn(Map.of(testId, 2));
        when(storageService.getProductById(testId)).thenReturn(Optional.ofNullable(products.get(testId)));

        UserBasket result = basketService.getUserBasket();

        assertEquals(310, result.getTotal());
    }
}