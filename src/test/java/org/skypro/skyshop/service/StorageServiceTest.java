package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.Map;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StorageServiceTest {
    @Mock
    private Map<UUID, Article> articles;
    @Mock
    private Map<UUID, Product> products;

    @InjectMocks
    public StorageService storageService;

    @Test
    void givenProduct_whenAddToShop_thenProductAdd() {
        Product milk = new SimpleProduct("молоко", 100, UUID.randomUUID());
        when(products.put(milk.getId(), milk)).thenReturn(milk);

        Product result = products.put(milk.getId(), milk);

        Assertions.assertEquals(result, milk);

    }
}