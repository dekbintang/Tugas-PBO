package src.model;

public class SuratBerhargaNegaraHolding {
    private SuratBerhargaNegara suratBerhargaNegara;
    private double amount;

    public SuratBerhargaNegaraHolding(SuratBerhargaNegara suratBerhargaNegara, double amount) {
        this.suratBerhargaNegara = suratBerhargaNegara;
        this.amount = amount;
    }

    public SuratBerhargaNegara getSuratBerhargaNegara() {
        return suratBerhargaNegara;
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double value) {
        this.amount += value;
    }

    public void subtractAmount(double value) {
        this.amount -= value;
    }
}
