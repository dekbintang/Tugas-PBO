package src.model;

public class SahamHolding {
    private Saham saham;
    private int quantity;

    public SahamHolding(Saham saham, int quantity) {
        this.saham = saham;
        this.quantity = quantity;
    }

    public Saham getSaham() {
        return saham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void subtractQuantity(int amount) {
        this.quantity -= amount;
    }
}
