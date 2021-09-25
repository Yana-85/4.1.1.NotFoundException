package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Product product = new Product(1, "Гарри Поттер", 300);

    @Test
    void shouldMatchByNameIfExists() {
        String name = "Гарри Поттер";
        assertTrue(product.matches(name));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String name = "Остров проклятых";
        assertFalse(product.matches(name));
    }
}
