package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String productDesignation;
    private final UUID id;

    public Product(String productDesignation, UUID id) {
        if ((productDesignation == null) || productDesignation.isBlank()) {
            throw new IllegalArgumentException("Недопустимое название продукта!");
        }
        this.productDesignation = productDesignation;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getProductDesignation() {
        return productDesignation;
    }

    public abstract int getPrice();

    public String toString() {
        return getProductDesignation() + ": " + getPrice();
    }

    public abstract boolean isSpecial();

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return getProductDesignation();
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productDesignation, product.productDesignation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productDesignation);
    }
}
