package src.view;

import src.model.Saham;
import src.model.SahamHolding;
import src.model.SuratBerhargaNegara;
import src.model.SuratBerhargaNegaraHolding;

import java.util.List;

public class TableView {

    public static void displayCustomerMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                         Customer Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Lihat Portofolio                                           ||");
        System.out.println("||   [2] Beli Saham                                                 ||");
        System.out.println("||   [3] Jual Saham                                                 ||");
        System.out.println("||   [4] Beli Surat Berharga Negara                                 ||");
        System.out.println("||   [5] Simulasi Kupon SBN                                         ||");
        System.out.println("||   [6] Logout                                                     ||");
        System.out.println("=====================================================================");
        System.out.print("Pilih opsi dengan angka: ");
    }

    public static void displayPortfolioSahamTable(List<SahamHolding> sahamHoldings) {
        System.out.println("=====================================================================");
        System.out.println("||                         Portofolio Saham                        ||");
        System.out.println("=====================================================================");
        System.out.printf("%-5s %-10s %-25s %-15s %-10s %-15s%n", "No", "Kode", "Nama Perusahaan", "Harga (Rp)", "Jumlah", "Total (Rp)");
        System.out.println("---------------------------------------------------------------------");

        int index = 1;
        for (SahamHolding holding : sahamHoldings) {
            Saham saham = holding.getSaham();
            double total = saham.getPrice() * holding.getQuantity();
            System.out.printf("%-5d %-10s %-25s %-15.2f %-10d %-15.2f%n",
                    index++,
                    saham.getCode(),
                    saham.getCompanyName(),
                    saham.getPrice(),
                    holding.getQuantity(),
                    total
            );
        }
        System.out.println("=====================================================================");
    }

    public static void displayPortfolioSBNTable(List<SuratBerhargaNegaraHolding> sbnHoldings) {
        System.out.println("=====================================================================");
        System.out.println("||                      Portofolio Surat Berharga                  ||");
        System.out.println("=====================================================================");
        System.out.printf("%-5s %-25s %-10s %-15s %-15s %-15s%n", "No", "Nama", "Bunga (%)", "Jangka Waktu", "Jatuh Tempo", "Jumlah (Rp)");
        System.out.println("---------------------------------------------------------------------");

        int index = 1;
        for (SuratBerhargaNegaraHolding holding : sbnHoldings) {
            SuratBerhargaNegara sbn = holding.getSuratBerhargaNegara();
            System.out.printf("%-5d %-25s %-10.2f %-15s %-15s %-15.2f%n",
                    index++,
                    sbn.getName(),
                    sbn.getInterestRate(),
                    sbn.getDurationMonths() + " bulan",
                    sbn.getMaturityDate(),
                    holding.getAmount()
            );
        }
        System.out.println("=====================================================================");
    }

    public static void displayAvailableSahamTable(List<Saham> daftarSaham) {
        System.out.println("=====================================================================");
        System.out.println("||                        Daftar Saham Tersedia                    ||");
        System.out.println("=====================================================================");
        System.out.printf("%-5s %-10s %-30s %-15s%n", "No", "Kode", "Nama Perusahaan", "Harga (Rp)");
        System.out.println("---------------------------------------------------------------------");

        int index = 1;
        for (Saham saham : daftarSaham) {
            System.out.printf("%-5d %-10s %-30s %-15.2f%n",
                    index++,
                    saham.getCode(),
                    saham.getCompanyName(),
                    saham.getPrice()
            );
        }
        System.out.println("=====================================================================");
    }

    public static void displayAvailableSBNTable(List<SuratBerhargaNegara> daftarSBN) {
        System.out.println("=====================================================================");
        System.out.println("||                   Daftar Surat Berharga Negara                  ||");
        System.out.println("=====================================================================");
        System.out.printf("%-5s %-25s %-10s %-15s %-15s %-15s%n", "No", "Nama", "Bunga (%)", "Jangka Waktu", "Jatuh Tempo", "Kuota (Rp)");
        System.out.println("---------------------------------------------------------------------");

        int index = 1;
        for (SuratBerhargaNegara sbn : daftarSBN) {
            System.out.printf("%-5d %-25s %-10.2f %-15s %-15s %-15.2f%n",
                    index++,
                    sbn.getName(),
                    sbn.getInterestRate(),
                    sbn.getDurationMonths() + " bulan",
                    sbn.getMaturityDate(),
                    sbn.getQuota()
            );
        }
        System.out.println("=====================================================================");
    }

    public static void displayKuponSimulation(double bunga, double nominal, double kuponPerBulan) {
        System.out.println("=====================================================================");
        System.out.println("||                        Simulasi Kupon SBN                       ||");
        System.out.println("=====================================================================");
        System.out.printf("%-20s %-15s %-10s %-20s%n", "Nominal (Rp)", "Bunga (%)", "Pajak", "Kupon per Bulan (Rp)");
        System.out.println("---------------------------------------------------------------------");

        System.out.printf("%-20.2f %-15.2f %-10s %-20.2f%n",
                nominal,
                bunga,
                "10%",
                kuponPerBulan
        );
        System.out.println("=====================================================================");
    }

    public static void displayPortofolioHeader() {
        System.out.println("=====================================================================");
        System.out.println("||                           Portofolio Anda                       ||");
        System.out.println("=====================================================================");
    }

    public static void displaySectionHeader(String title) {
        System.out.println("=====================================================================");
        System.out.printf("|| %-65s ||\n", title);
        System.out.println("=====================================================================");
    }
}
