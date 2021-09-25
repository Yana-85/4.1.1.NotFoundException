package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Гарри Поттер", 300, "Дж.К.Роулинг");
    private Book secondBook = new Book(2, "Властелин Колец", 550, "Дж.Р.Р.Толкин");
    private Book thirdBook = new Book(3, "Зеленая миля", 690, "Стивен Кинг");
    private Book fourthBook = new Book(4, "Остров проклятых", 815, "Деннис Лихэйн");
    private Book fifthBook = new Book(5, "Оно", 950, "Стивен Кинг");
    private Smartphone firstSmartphone = new Smartphone(6, "Galaxy A31", 17000, "Samsung");
    private Smartphone secondSmartphone = new Smartphone(7, "Galaxy A52", 30000, "Samsung");
    private Smartphone thirdSmartphone = new Smartphone(8, "30 Pro Plus", 45000, "Honor");
    private Smartphone fourthSmartphone = new Smartphone(9, "Galaxy Note 20", 60000, "Samsung");
    private Smartphone fifthSmartphone = new Smartphone(10, "Mate 40 Pro", 90000, "Huawei");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
        manager.add(fifthSmartphone);
    }

    @Test
    public void shouldSearchBookByNameIfExists() {
        String name = "Властелин Колец";
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByNameIfNotExists() {
        String name = "Черный квадрат";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthorIfExists() {
        String author = "Деннис Лихэйн";
        Product[] expected = new Product[]{fourthBook};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByAuthorIfNotExists() {
        String author = "Джейн Остин";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByNameIfExists() {
        String name = "30 Pro Plus";
        Product[] expected = new Product[]{thirdSmartphone};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneByNameIfNotExists() {
        String name = "20 Pro Plus";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturerIfExists() {
        String manufacturer = "Huawei";
        Product[] expected = new Product[]{fifthSmartphone};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneByManufacturerIfExists() {
        String manufacturer = "Xiaomi";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductsWithSameAuthor() {
        String author = "Стивен Кинг";
        Product[] expected = new Product[]{thirdBook, fifthBook};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductsWithSameManufacturer() {
        String manufacturer = "Samsung";
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone, fourthSmartphone};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }
}
