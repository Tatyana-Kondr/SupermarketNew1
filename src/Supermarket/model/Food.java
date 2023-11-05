package Supermarket.model;

public class Food extends Produkt{
    private String expDate;
    private boolean organic;

    public Food(int barcode, String name, double price, String expDate, boolean organic) {
        super(barcode, name, price);
        this.expDate = expDate;
        this.organic = organic;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", expDate: " + expDate +
                ", organic: " + organic;
    }
}
