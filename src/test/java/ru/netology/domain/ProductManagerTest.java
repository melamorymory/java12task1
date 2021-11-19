package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product book1 = new Book(1, "Dune", 300, "Gerbert");
    Product book2 = new Book(2, "Naruto", 500, "Kishimoto");
    Product book3 = new Book(3, "Naruto", 550, "Kishimoto");
    Product smartphone1 = new Smartphone(11, "Galaxy", 30_000, "Samsung");
    Product smartphone2 = new Smartphone(22, "IPhone", 50_000, "Apple");
    Product cat = new Product(1, "Sirius", 0);

    @BeforeEach
            public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(cat);
    }

    @Test
    void shouldSearchABookByName() {
        Product[] actual = manager.searchBy("Naruto");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Gerbert");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchASmartphoneByName() {
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchByProducer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotSearchNonExistent() {
        Product[] actual = manager.searchBy("Sasuke");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
    @Test
    void shouldNotSearchACat() {
        Product[] actual = manager.searchBy("Sirius");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchABooksWithSameNames() {
        manager.add(book3);
        Product[] actual = manager.searchBy("Naruto");
        Product[] expected = new Product[]{book2, book3};
        assertArrayEquals(actual, expected);
    }
}