package src.model;

public class SahamHolding {
    private Saham saham;
    private int quantity;
    private String code;

    public SahamHolding(Saham saham, int quantity, String code) {
        this.saham = saham;
        this.quantity = quantity;
        this.code = code;
    }

    public SahamHolding(Saham saham, int quantity) {
    }

    public Saham getSaham() {
        return saham;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void subtractQuantity(int amount) {
        this.quantity -= amount;
    }
}
