package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    ProductManager manager;

    Product first = new Book(1, "Gordost i predugdenia", 1, "Ostin");
    Product second = new Book(2, "Dgein Eer", 2, "Bronte");
    Product third = new Smartphone(3, "1C0", 3, "Samsung");
    Product forth = new Smartphone(4, "2C0", 4, "Nokia");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
    }


    @Test
    public void searchBookName() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Gordost i predugdenia");
        Product[] expected = new Product[] {first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookAuthor() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Bronte");
        Product[] expected = new Product[] {second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneName() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("1C0");
        Product[] expected = new Product[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneManufacturer() {
        Product[] returned = new Product[] {first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[] {forth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchNull() {
        Product[] returned = new Product[] {};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Gordost i predugdenia");
        Product[] expected = new Product[] {};
        assertArrayEquals(expected, actual);
    }
}
