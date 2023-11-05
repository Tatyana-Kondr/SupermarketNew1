package Supermarket.model;

public class MilkFood extends Food{
    private double fat;

    public MilkFood(int barcode, String name, double price, String expDate, boolean organic, double fat) {
        super(barcode, name, price, expDate, organic);
        this.fat = fat;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return super.toString() + ", fat: " + fat + "%";
    }
}
