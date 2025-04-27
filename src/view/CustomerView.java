package src.view;

import src.model.Saham;
import src.model.SahamHolding;
import src.model.SuratBerhargaNegara;
import src.model.SuratBerhargaNegaraHolding;
import java.util.List;

public class CustomerView {

    public static void displayPortfolioSahamTable(List<SahamHolding> sahamHoldings) {
        TableView table = new TableView();
        table.setHeaders("No", "Kode", "Nama Perusahaan", "Harga (Rp)", "Jumlah", "Total (Rp)");

        int index = 1;
        for (SahamHolding holding : sahamHoldings) {
            Saham saham = holding.getSaham();
            double total = saham.getPrice() * holding.getQuantity();

            table.addRow(
                    String.valueOf(index++),
                    saham.getCode(),
                    saham.getCompanyName(),
                    String.format("%.2f", saham.getPrice()),
                    String.valueOf(holding.getQuantity()),
                    String.format("%.2f", total)
            );
        }

        table.render();
    }

    public static void displayPortfolioSBNTable(List<SuratBerhargaNegaraHolding> sbnHoldings) {
        TableView table = new TableView();
        table.setHeaders("No", "Nama", "Bunga (%)", "Jangka Waktu", "Jatuh Tempo", "Jumlah (Rp)");

        int index = 1;
        for (SuratBerhargaNegaraHolding holding : sbnHoldings) {
            SuratBerhargaNegara sbn = holding.getSuratBerhargaNegara();

            table.addRow(
                    String.valueOf(index++),
                    sbn.getName(),
                    String.format("%.2f", sbn.getInterestRate()),
                    sbn.getDurationMonths() + " bulan",
                    sbn.getMaturityDate(),
                    String.format("%.2f", holding.getAmount())
            );
        }

        table.render();
    }

    public static void displayAvailableSahamTable(List<Saham> daftarSaham) {
        TableView table = new TableView();
        table.setHeaders("No", "Kode", "Nama Perusahaan", "Harga (Rp)");

        int index = 1;
        for (Saham saham : daftarSaham) {
            table.addRow(
                    String.valueOf(index++),
                    saham.getCode(),
                    saham.getCompanyName(),
                    String.format("%.2f", saham.getPrice())
            );
        }

        table.render();
    }

    public static void displayAvailableSBNTable(List<SuratBerhargaNegara> daftarSBN) {
        TableView table = new TableView();
        table.setHeaders("No", "Nama", "Bunga (%)", "Jangka Waktu", "Jatuh Tempo", "Kuota (Rp)");

        int index = 1;
        for (SuratBerhargaNegara sbn : daftarSBN) {
            table.addRow(
                    String.valueOf(index++),
                    sbn.getName(),
                    String.format("%.2f", sbn.getInterestRate()),
                    sbn.getDurationMonths() + " bulan",
                    sbn.getMaturityDate(),
                    String.format("%.2f", sbn.getQuota())
            );
        }

        table.render();
    }

    public static void displayKuponSimulation(double bunga, double nominal, double kuponPerBulan) {
        TableView table = new TableView();
        table.setHeaders("Nominal (Rp)", "Bunga (%)", "Pajak", "Kupon per Bulan (Rp)");

        table.addRow(
                String.format("%.2f", nominal),
                String.format("%.2f", bunga),
                "10%",
                String.format("%.2f", kuponPerBulan)
        );

        table.render();
    }
}