package src.service;

import src.model.SuratBerhargaNegara;
import java.util.List;

public class GovernmentBondService {
    private List<SuratBerhargaNegara> bondList;

    public GovernmentBondService(List<SuratBerhargaNegara> bondList) {
        this.bondList = bondList;
    }

    public void addBond(SuratBerhargaNegara bond) {
        bondList.add(bond);
    }
}
