package org.skypro.skyshop.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @ValueSource(strings = {"ко", "Ко", "кО", "КО"})
    @ParameterizedTest
    void whenSearchTermIsGiven_thenSearchTermReturnResultSize(String term) {
        when(storageService.getAllSearchable()).thenReturn(List.of(
                new SimpleProduct("молоко", 100, UUID.randomUUID()),
                new SimpleProduct("банан", 50, UUID.randomUUID()),
                new SimpleProduct("шоколад", 150, UUID.randomUUID()),
                new DiscountedProduct("морковь", 30, 30, UUID.randomUUID()),
                new DiscountedProduct("черника", 220, 30,
                        UUID.randomUUID()),
                new FixPriceProduct("курица", UUID.randomUUID()),
                new Article("Чай", "Чёрный крупнолистовой чай без добавок",
                        UUID.randomUUID()),
                new Article("Чай", "Зелёный крупнолистовой чай без добавок",
                        UUID.randomUUID()),
                new Article("Кофе", "Молотый кофе", UUID.randomUUID())));

        List<SearchResult> results = searchService.searchTerm(term);

        assertEquals(4, results.size());
    }
}
