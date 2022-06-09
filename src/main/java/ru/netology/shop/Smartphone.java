package ru.netology.shop;

public class Smartphone extends Product {
    public String manufacturer;

    public Smartphone(int id, String name, double price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}