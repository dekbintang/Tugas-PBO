package src.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<SahamHolding> sahamHoldings = new ArrayList<>();
    private List<SuratBerhargaNegaraHolding> suratBerhargaNegaraHoldings = new ArrayList<>();

    public void buySaham(Saham saham, int quantity) {
        for (SahamHolding holding : sahamHoldings) {
            if (holding.getSaham().getCode().equalsIgnoreCase(saham.getCode())) {
                holding.addQuantity(quantity);
                return;
            }
        }
        SahamHolding newHolding = new SahamHolding(saham, quantity, saham.getCode());
        sahamHoldings.add(newHolding);
    }


    public boolean sellSaham(Saham saham, int quantity) {
        SahamHolding existing = findSahamHolding(saham);
        if (existing == null || existing.getQuantity() < quantity) {
            return false;
        }
        if (existing.getQuantity() == quantity) {
            sahamHoldings.remove(existing);
        } else {
            existing.subtractQuantity(quantity);
        }
        return true;
    }

    public void buySuratBerhargaNegara(SuratBerhargaNegara suratBerhargaNegara, double amount) {
        SuratBerhargaNegaraHolding existing = findSuratBerhargaNegaraHolding(suratBerhargaNegara);
        if (existing != null) {
            existing.addAmount(amount);
        } else {
            suratBerhargaNegaraHoldings.add(new SuratBerhargaNegaraHolding(suratBerhargaNegara, amount));
        }
    }
    public List<SahamHolding> getSahamHoldings() {
        return sahamHoldings;
    }

    public List<SuratBerhargaNegaraHolding> getSuratBerhargaNegaraHoldings() {
        return suratBerhargaNegaraHoldings;
    }

    private SahamHolding findSahamHolding(Saham saham) {
        for (SahamHolding holding : sahamHoldings) {
            if (holding.getSaham().equals(saham)) {
                return holding;
            }
        }
        return null;
    }

    private SuratBerhargaNegaraHolding findSuratBerhargaNegaraHolding(SuratBerhargaNegara suratBerhargaNegara) {
        for (SuratBerhargaNegaraHolding holding : suratBerhargaNegaraHoldings) {
            if (holding.getSuratBerhargaNegara().equals(suratBerhargaNegara)) {
                return holding;
            }
        }
        return null;
    }

    public void removeSahamIfExists(Saham saham) {
        sahamHoldings.removeIf(holding -> holding.getSaham().equals(saham));
    }

    public void removeSBNIfExists(SuratBerhargaNegara suratBerhargaNegara) {
        suratBerhargaNegaraHoldings.removeIf(holding -> holding.getSuratBerhargaNegara().equals(suratBerhargaNegara));
    }

}
