package Supermarket.dao;

import Supermarket.model.Produkt;

public interface Supermarket {
    Produkt findProduct(int barcode);
    boolean addProduct(Produkt product);
    Produkt updateProduct(int barcode, double price);
    Produkt removeProduct(int barcode);
    int quantity();
    Produkt findProductExpDate(String expDate);
    void printProducts();

}
