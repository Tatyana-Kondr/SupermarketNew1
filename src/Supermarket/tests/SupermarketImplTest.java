package Supermarket.tests;

import Supermarket.dao.Supermarket;
import Supermarket.dao.SupermarketImpl;
import Supermarket.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplTest {

    Supermarket supermarket;
    Produkt[] pr;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketImpl(6);
        pr = new Produkt[5];
        pr[0] = new Food(100, "Bread", 0.99, "10.22.2023", true);
        pr[1] = new MeatFood(101, "Sausage", 4.99, "11.15.2023", false, "Pork");
        pr[2] = new MilkFood(102, "Milk", 1.39, "10.30.2023", true, 3.8);
        pr[3] = new Food(103, "Chips", 2.59, "01.07.2024", false);
        pr[4] = new HouseholdGoods(201, "Vase", 7.99, "glass");

        for (int i = 0; i < pr.length; i++) {
            supermarket.addProduct(pr[i]);
        }
    }

    @Test
    void findProductTest() {
        assertEquals(pr[1], supermarket.findProduct(101));
        assertNull(supermarket.findProduct(300));
    }

    @Test
    void addProductTest() {
        supermarket.printProducts();
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(pr[1]));
        Produkt pr1 = new HouseholdGoods(202, "Basket", 4.5, "plastic");
        assertTrue(supermarket.addProduct(pr1));
        Produkt pr2 = new HouseholdGoods(203, "Basket", 3.5, "plastic");
        assertFalse(supermarket.addProduct(pr2));
        System.out.println("............................");
        supermarket.printProducts();
    }

    @Test
    void updateProductTest() {
        supermarket.printProducts();
        System.out.println("............................");
        supermarket.updateProduct(100, 1.29);
        supermarket.printProducts();
        assertEquals(pr[0], supermarket.updateProduct(100,1.29));
    }

    @Test
    void removeProductTest() {
        assertEquals(pr[1], supermarket.removeProduct(101));
        assertEquals(4, supermarket.quantity());
        assertNull(supermarket.removeProduct(101));
        assertNull(supermarket.findProduct(101));
        supermarket.printProducts();
    }

    @Test
    void quantityTest() {
        assertEquals(5, supermarket.quantity());
    }

    @Test
    void findProductsExpDateTest() {
        assertEquals(pr[2], supermarket.findProductExpDate("10.30.2023"));
        assertNull(supermarket.findProductExpDate("10.31.2024"));
    }

    @Test
    void printProductsTest() {
        supermarket.printProducts();
    }
}