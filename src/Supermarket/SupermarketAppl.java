package Supermarket;

import Supermarket.dao.SupermarketImpl;
import Supermarket.model.*;

public class SupermarketAppl {
    public static void main(String[] args) {
        SupermarketImpl supermarket = new SupermarketImpl(7);

        Produkt bread = new Food(100, "Bread", 0.99, "10.22.2023", true);
        Produkt sausage = new MeatFood(101, "Sausage", 4.99, "11.15.2023", false, "Pork");
        Produkt milk = new MilkFood(102, "Milk", 1.39, "10.30.2023", true, 3.8);
        Produkt chips = new Food(103, "Chips", 2.59, "01.07.2024", false);
        Produkt vase = new HouseholdGoods(201, "Vase", 7.99, "glass");
        supermarket.addProduct(bread);
        supermarket.addProduct(sausage);
        supermarket.addProduct(milk);
        supermarket.addProduct(chips);
        supermarket.addProduct(vase);
        supermarket.printProducts();

        String targetExpD = "10.22.2023";
        Produkt foundProduct = supermarket.findProductExpDate(targetExpD);
        if ( foundProduct != null) {
            System.out.println("Product is found: " + foundProduct.getName() + ", Barcode: " + foundProduct.getBarcode() + ", expiration date: " + targetExpD);
            } else {
            System.out.println("Product this expiration date is not found.");
        }
    }



}
