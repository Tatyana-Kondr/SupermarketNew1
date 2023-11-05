package Supermarket.dao;

import Supermarket.model.Food;
import Supermarket.model.Produkt;

import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket{
    private Produkt[] produkts;
    private int size;

    public SupermarketImpl(int capasity){
        produkts = new Produkt[capasity];
    }

    @Override
    public Produkt findProduct(int barcode) {
        for (int i = 0; i < size; i++) {
            if(produkts[i].getBarcode() == barcode){
                return produkts[i];
            }
        }
        return null;
    }

    @Override
    public boolean addProduct(Produkt product) {
        // не добавляем null, не превышаем capacity, не добавляем уже существующего
        if(product == null || size == produkts.length || findProduct(product.getBarcode()) != null){
            return false;
        }
        produkts[size++] = product;
        return true;
    }

    @Override
    public Produkt updateProduct(int barcode, double price) {
        Produkt produkt = findProduct(barcode);
        if(produkt == null){
            return null;
        }
        produkt.setPrice(price);
        return produkt;
    }

//    @Override
//    public Produkt removeProduct(int barcode) {
//        for (int i = 0; i < size; i++) {
//            if(produkts[i].getBarcode() == barcode){
//                Produkt victim = produkts[i];
//                produkts[i] = produkts[--size];
//                produkts[size] = null;
//                return victim;
//            }
//        }
//        return null;
//    }
    @Override
    public Produkt removeProduct(int barcode) {
        for (int i = 0; i < size; i++) {
            if(produkts[i].getBarcode() == barcode){
                Produkt victim = produkts[i];
                System.arraycopy(produkts, i + 1, produkts, i, size - i - 1);
                produkts[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public Produkt findProductExpDate(String expDate) {
        for (int i = 0; i < size; i++) {
            if(produkts[i] instanceof Food){   // принадлежит классу Food
                Food productExpD = (Food) produkts[i];  //сохраняем в переменную
                if(productExpD.getExpDate().equals(expDate)){
                    return productExpD;    // если даты совпадают, то возвращаем переменную
                }
            }
        }
        return null;
    }

    @Override
    public void printProducts() {
        for (int i = 0; i < size; i++) {
            System.out.println(produkts[i]);
        }
    }
    private Produkt[] findByPredicate(Predicate<Produkt> predicate){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(produkts[i])){
                count++;
            }
        }
        Produkt[] res = new Produkt[count];
        for (int i = 0, j = 0; j < res.length ; i++) {
            if(predicate.test(produkts[i])){
                res[j++] = produkts[i];
            }
        }
        return res;
    }
}
