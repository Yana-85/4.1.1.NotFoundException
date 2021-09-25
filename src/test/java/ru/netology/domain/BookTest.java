package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Гарри Поттер", 300, "Дж.К.Роулинг");

    @Test
    public void shouldMatchByNameIfExists() {
        String name = "Гарри Поттер";
        assertTrue(book.matches(name));
    }

    @Test
    public void shouldMatchByNameIfNotExists() {
        String name = "Остров проклятых";
        assertFalse(book.matches(name));
    }

    @Test
    public void shouldMatchByAuthorIfExists() {
        String author = "Дж.К.Роулинг";
        assertTrue(book.matches(author));
    }

    @Test
    public void shouldMatchByAuthorIfNotExists() {
        String author = "Стивен Кинг";
        assertFalse(book.matches(author));
    }
}
