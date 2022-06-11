package ru.netology.shop;

import ru.netology.shop.exceptions.NotFoundException;

public class Repository {
    private Product[] goods = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[goods.length] = product;
        goods = tmp;
    }

    public Product[] findAll() {
        return goods;
    }

    public Product findById(int productId) {
        for (Product good : goods) {
            if (good.getId() == productId) {
                return good;
            }
        }
        return null;
    }

    public void removeById(int productId) {
        if (findById(productId) != null) {
            Product[] tmp = new Product[goods.length - 1];
            int counter = 0;
            for (Product good : goods) {
                if (good.getId() != productId) {
                    tmp[counter] = good;
                    counter++;
                }
            }
            goods = tmp;
        } else {
            throw new NotFoundException("Element with id: " + productId + " not found");
        }
    }
}