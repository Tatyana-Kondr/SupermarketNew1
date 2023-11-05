package Supermarket.model;

public class HouseholdGoods extends Produkt{
    private String material;

    public HouseholdGoods(int barcode, String name, double price, String material) {
        super(barcode, name, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", material: " + material;
    }
}
