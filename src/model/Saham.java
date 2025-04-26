package src.model;

public class Saham {
    private String code;
    private String companyName;
    private double price;
    private int quantity;

    public Saham(String code, String companyName, double price) {
        this.code = code;
        this.companyName = companyName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return code + " - " + companyName + " (Rp " + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saham saham = (Saham) o;
        return code.equals(saham.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
