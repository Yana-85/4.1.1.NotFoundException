package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone firstSmartphone = new Smartphone(6, "Galaxy A31", 17000, "Samsung");

    @Test
    public void shouldMatchByNameIfExists() {
        String name = "Galaxy A31";
        assertTrue(firstSmartphone.matches(name));
    }

    @Test
    public void shouldMatchByNameIfNotExists() {
        String name = "30 Pro Plus";
        assertFalse(firstSmartphone.matches(name));
    }

    @Test
    public void shouldMatchByManufacturerIfExists() {
        String manufacturer = "Samsung";
        assertTrue(firstSmartphone.matches(manufacturer));
    }

    @Test
    public void shouldMatchByManufacturerIfNotExists() {
        String manufacturer = "Honor";
        assertFalse(firstSmartphone.matches(manufacturer));
    }
}
