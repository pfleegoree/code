package inheritance.bakery;
public class Cake {
    public String flavor;
    private double price;
    public Cake() {
        flavor = "vanilla";
    }
    public Cake(String flavor) {
        setPrice(9.99);
        setFlavor(flavor);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavour) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}