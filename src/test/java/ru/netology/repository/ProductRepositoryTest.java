package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "Гарри Поттер", 300, "Дж.К.Роулинг");
    private Book secondBook = new Book(2, "Властелин Колец", 550, "Дж.Р.Р.Толкин");
    private Book thirdBook = new Book(3, "Зеленая миля", 690, "Стивен Кинг");
    private Book fourthBook = new Book(4, "Остров проклятых", 815, "Деннис Лихэйн");
    private Book fifthBook = new Book(5, "Оно", 950, "Стивен Кинг");

    @BeforeEach
    public void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthBook);
        repository.save(fifthBook);
    }

    @Test
    public void shouldRemoveIfExists() {
        int removeId = 5;
        repository.removeById(removeId);
        Product[] expected = new Product[]{firstBook, secondBook, thirdBook, fourthBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfNotExists() {
        int removeId = 6;
        repository.findById(removeId);
        Product expected = null;
        Product actual = repository.findById(removeId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdIfNotExist() {
        int removeId = 6;
        assertThrows(NotFoundException.class, () -> repository.removeById(removeId));
    }
}
