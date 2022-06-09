package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {
    @Test
    public void repositorySave() {
        Repository repository = new Repository();
        Book test1 = new Book(1, "Test book", 10.0, "Someone");
        Smartphone test2 = new Smartphone(2, "Test phone", 20.0, "Phone inc.");
        Product[] expected = {test1, test2};
        repository.save(test1);
        repository.save(test2);
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void repositoryDelete() {
        Repository repository = new Repository();
        Book test1 = new Book(1, "Test book", 10.0, "Someone");
        Smartphone test2 = new Smartphone(2, "Test phone", 20.0, "Phone inc.");
        Smartphone test3 = new Smartphone(4, "Test phone 2", 30.0, "Phone inc.");
        repository.save(test1);
        repository.save(test2);
        repository.save(test3);
        Assertions.assertTrue(repository.isHasProduct(2));
        repository.delete(2);
        Assertions.assertFalse(repository.isHasProduct(2));
        repository.delete(2);
        Assertions.assertFalse(repository.isHasProduct(2));
    }

    @Test
    public void managerAdd() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Book book = new Book(1, "Test book", 10.0, "Someone");
        manager.add(book);
        Assertions.assertTrue(repository.isHasProduct(1));
    }

    @Test
    void managerSearch() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Book test1 = new Book(1, "Test book", 10.0, "Someone");
        Smartphone test2 = new Smartphone(2, "Test phone", 20.0, "Phone inc.");
        Smartphone test3 = new Smartphone(4, "Test phone 2", 30.0, "Phone inc.");
        Product[] expected = {test2, test3};
        manager.add(test1);
        manager.add(test2);
        manager.add(test3);
        Product[] actual = manager.searchBy("phone");
        Assertions.assertArrayEquals(expected, actual);
    }
}