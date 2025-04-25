package src.model;

import java.util.Objects;

public class SuratBerhargaNegara {
    private String name;
    private double interestRate;
    private int durationMonths;
    private String maturityDate;
    private double quota;

    public SuratBerhargaNegara(String name, double interestRate, int durationMonths, String maturityDate, double quota) {
        this.name = name;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
        this.maturityDate = maturityDate;
        this.quota = quota;
    }

    public String getName() {
        return name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public double getQuota() {
        return quota;
    }

    public void reduceQuota(double amount) {
        this.quota -= amount;
    }

    @Override
    public String toString() {
        return name + " | Bunga: " + interestRate + "% | Jangka: " + durationMonths + " bulan | Jatuh Tempo: " + maturityDate + " | Kuota: Rp " + quota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuratBerhargaNegara that = (SuratBerhargaNegara) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
