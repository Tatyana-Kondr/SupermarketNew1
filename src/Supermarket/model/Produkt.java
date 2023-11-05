package Supermarket.model;

public abstract class Produkt {
    protected int barcode;
    protected String name;
    protected  double price;

    public Produkt(int barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produkt produkt = (Produkt) o;

        return barcode == produkt.barcode;
    }

    @Override
    public int hashCode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "Product - " +
                "barcode: " + barcode +
                ", name: " + name +
                ", price: " + price + "€";
    }
}
