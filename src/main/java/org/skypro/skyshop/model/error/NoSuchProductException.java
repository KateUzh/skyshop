package org.skypro.skyshop.model.error;

import java.util.UUID;


public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(UUID productById) {
        super(productById + " нет в нашем магазине");
    }
}
