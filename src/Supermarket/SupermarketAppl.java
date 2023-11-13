package Supermarket;

import Supermarket.dao.SupermarketImpl;
import Supermarket.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        System.out.println("-----------------Array List------------------");
        List<Produkt> produktsList = new ArrayList<>();
        produktsList.add(bread);
        produktsList.add(sausage);
        produktsList.add(milk);
        produktsList.add(chips);
        produktsList.add(vase);
        produktsList.add(new Food(104, "Chocolate", 1.39, "01.12.2023", false));
        for (Produkt p : produktsList) {
            System.out.println(p);
        }

        System.out.println("----------------- sorted Array List ------------------");

        double sum = 0;
        for (Produkt p : produktsList) {
            sum += p.getPrice();
        }
        Comparator<Produkt> comparator = new Comparator<Produkt>() {
            @Override
            public int compare(Produkt o1, Produkt o2) {
                return o1.getName().compareTo(o2.getName()); // сортировка по наименованию
            }
        };
        produktsList.sort(comparator);
        for (Produkt p : produktsList) {
            System.out.println(p);
        }
        System.out.print("You have " + produktsList.size() + " products ");
        System.out.printf("for the sum of %.2f", sum);
        System.out.println(" euro.");

    }
}
