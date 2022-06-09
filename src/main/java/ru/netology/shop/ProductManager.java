package ru.netology.shop;

public class ProductManager {

    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    private Product[] addToArray(Product[] sourceArray, Product toAdd) {
        Product[] tmp = new Product[sourceArray.length + 1];
        for (int i = 0; i < sourceArray.length; i++) {
            tmp[i] = sourceArray[i];
        }
        tmp[sourceArray.length] = toAdd;
        sourceArray = tmp;
        return sourceArray;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                result = addToArray(result, product);
            }
        }
        return result;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}