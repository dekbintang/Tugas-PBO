package src.view;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.model.SahamHolding;
import src.model.SuratBerhargaNegaraHolding;

import java.util.List;

public class TableView {

    // Menu Admin Utama
    public static void displayAdminMainMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                            Admin Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Kelola Saham                                               ||");
        System.out.println("||   [2] Kelola Surat Berharga Negara (SBN)                         ||");
        System.out.println("||   [3] Logout                                                     ||");
        System.out.println("=====================================================================");
        System.out.print("Pilih: ");
    }

    // Submenu Admin Saham
    public static void displaySahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                         Saham Menu Admin                        ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Tambah Saham Baru                                          ||");
        System.out.println("||   [2] Ubah Harga Saham                                           ||");
        System.out.println("||   [3] Lihat Daftar Saham                                         ||");
        System.out.println("||   [4] Kembali ke Admin Menu                                      ||");
        System.out.println("=====================================================================");
        System.out.print("Pilih: ");
    }

    // Submenu Admin SBN
    public static void displaySBNMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                      Surat Berharga Negara Menu                 ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Tambah Surat Berharga Negara Baru                          ||");
        System.out.println("||   [2] Lihat Daftar SBN                                           ||");
        System.out.println("||   [3] Kembali ke Admin Menu                                      ||");
        System.out.println("=====================================================================");
        System.out.print("Pilih: ");
    }

    // Menu Customer Utama
    public static void displayCustomerMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                          Customer Menu                          ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Lihat Portofolio                                           ||");
        System.out.println("||   [2] Beli Saham                                                 ||");
        System.out.println("||   [3] Jual Saham                                                 ||");
        System.out.println("||   [4] Beli Surat Berharga Negara (SBN)                           ||");
        System.out.println("||   [5] Simulasi Kupon SBN                                         ||");
        System.out.println("||   [6] Logout                                                     ||");
        System.out.println("=====================================================================");
        System.out.print("Pilih: ");
    }

    // Header Section
    public static void displayHeader(String title) {
        System.out.println("=====================================================================");
        System.out.printf("||%-67s||%n", centerText(title, 67));
        System.out.println("=====================================================================");
    }

    public static void displaySectionHeader(String title) {
        System.out.println("\n---------------- " + title + " ----------------\n");
    }

    // Tabel untuk daftar saham
    public static void displaySahamTable(List<Saham> daftarSaham) {
        System.out.println("=====================================================================");
        System.out.printf("| %-5s | %-20s | %-15s | %-10s |\n", "No", "Kode", "Nama Perusahaan", "Harga");
        System.out.println("---------------------------------------------------------------------");
        int no = 1;
        for (Saham saham : daftarSaham) {
            System.out.printf("| %-5d | %-20s | %-15s | Rp%-9.2f |\n",
                    no++, saham.getCode(), saham.getCompanyName(), saham.getPrice());
        }
        System.out.println("=====================================================================");
    }

    // Tabel untuk daftar SBN
    public static void displaySBNTable(List<SuratBerhargaNegara> daftarSBN) {
        System.out.println("==================================================================================================================");
        System.out.printf("| %-5s | %-25s | %-10s | %-10s | %-15s | %-15s |\n", "No", "Nama", "Bunga (%)", "Jangka (bulan)", "Jatuh Tempo", "Kuota (Rp)");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        int no = 1;
        for (SuratBerhargaNegara sbn : daftarSBN) {
            System.out.printf("| %-5d | %-25s | %-10.2f | %-14d | %-15s | %-15.2f |\n",
                    no++, sbn.getName(), sbn.getInterestRate(), sbn.getDurationMonths(), sbn.getMaturityDate(), sbn.getQuota());
        }
        System.out.println("==================================================================================================================");
    }

    // Tabel untuk portfolio saham
    public static void displayPortfolioSahamTable(List<SahamHolding> holdings) {
        System.out.println("=====================================================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n", "No", "Nama Perusahaan", "Jumlah", "Harga");
        System.out.println("---------------------------------------------------------------------");
        int no = 1;
        for (SahamHolding holding : holdings) {
            System.out.printf("| %-5d | %-20s | %-10d | Rp%-9.2f |\n",
                    no++, holding.getSaham().getCompanyName(), holding.getQuantity(), holding.getSaham().getPrice());
        }
        System.out.println("=====================================================================");
    }

    // Tabel untuk portfolio SBN
    public static void displayPortfolioSBNTable(List<SuratBerhargaNegaraHolding> holdings) {
        System.out.println("=====================================================================");
        System.out.printf("| %-5s | %-20s | %-15s |\n", "No", "Nama SBN", "Jumlah Investasi (Rp)");
        System.out.println("---------------------------------------------------------------------");
        int no = 1;
        for (SuratBerhargaNegaraHolding holding : holdings) {
            System.out.printf("| %-5d | %-20s | Rp%-17.2f |\n",
                    no++, holding.getSuratBerhargaNegara().getName(), holding.getInvestmentAmount());
        }
        System.out.println("=====================================================================");
    }

    // Tampilan hasil simulasi kupon
    public static void displayKuponSimulation(double bunga, double nominal, double kuponPerBulan) {
        System.out.println("=====================================================================");
        System.out.println("||                        Hasil Simulasi Kupon SBN                 ||");
        System.out.println("=====================================================================");
        System.out.printf("Bunga Tahunan  : %.2f%%%n", bunga);
        System.out.printf("Nominal Investasi : Rp%.2f%n", nominal);
        System.out.printf("Estimasi Kupon per Bulan (setelah pajak): Rp%.2f%n", kuponPerBulan);
        System.out.println("=====================================================================");
    }

    // Utility untuk center text
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        String pad = " ".repeat(Math.max(0, padding));
        return pad + text;
    }
}
