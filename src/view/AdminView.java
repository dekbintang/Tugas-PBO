package src.view;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import java.util.List;

public class AdminView {

    public static void displaySahamTable(List<Saham> daftarSaham) {
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

    public static void displaySBNTable(List<SuratBerhargaNegara> daftarSBN) {
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
}