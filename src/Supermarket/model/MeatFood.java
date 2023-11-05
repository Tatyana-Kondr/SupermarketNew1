package Supermarket.model;

public class MeatFood extends Food{
    private String type;

    public MeatFood(int barcode, String name, double price, String expDate, boolean organic, String type) {
        super(barcode, name, price, expDate, organic);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type: " + type;
    }
}
