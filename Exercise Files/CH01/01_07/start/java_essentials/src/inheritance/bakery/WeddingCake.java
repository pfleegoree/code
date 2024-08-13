package inheritance.bakery;

public class WeddingCake extends Cake {
    public int tiers;

    public WeddingCake() {
        tiers = 3;
        flavor = "Pina Colada";
    }

    public int getTiers() {
        return tiers;
    }

    public void setTiers(int tiers) {
        this.tiers = tiers;
    }
}