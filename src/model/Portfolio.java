package src.model;

import java.util.*;

public class Portfolio {
    private Map<Saham, Integer> sahamHoldings = new HashMap<>();
    private Map<SuratBerhargaNegara, Double> suratBerhargaNegaraHoldings = new HashMap<>();

    public void buySaham(Saham saham, int quantity) {
        sahamHoldings.put(saham, sahamHoldings.getOrDefault(saham, 0) + quantity);
    }

    public boolean sellSaham(Saham saham, int quantity) {
        int owned = sahamHoldings.getOrDefault(saham, 0);
        if (quantity > owned) return false;
        if (quantity == owned) sahamHoldings.remove(saham);
        else sahamHoldings.put(saham, owned - quantity);
        return true;
    }

    public void buySuratBerhargaNegara(SuratBerhargaNegara suratBerhargaNegara, double amount) {
        suratBerhargaNegaraHoldings.put(suratBerhargaNegara, suratBerhargaNegaraHoldings.getOrDefault(suratBerhargaNegara, 0.0) + amount);
    }

    public boolean sellSuratBerhargaNegara(SuratBerhargaNegara suratBerhargaNegara, double amount) {
        double owned = suratBerhargaNegaraHoldings.getOrDefault(suratBerhargaNegara, 0.0);
        if (amount > owned) return false;
        if (amount == owned) suratBerhargaNegaraHoldings.remove(suratBerhargaNegara);
        else suratBerhargaNegaraHoldings.put(suratBerhargaNegara, owned - amount);
        return true;
    }

    public Map<Saham, Integer> getSahamHoldings() {
        return sahamHoldings;
    }

    public Map<SuratBerhargaNegara, Double> getSuratBerhargaNegaraHoldings() {
        return suratBerhargaNegaraHoldings;
    }
}
