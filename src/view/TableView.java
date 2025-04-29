package src.view;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.model.SahamHolding;
import src.model.SuratBerhargaNegaraHolding;

import java.util.List;

public class TableView {

    public static void displayMainMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                          MENU UTAMA                             ||");
        System.out.println("=====================================================================");
        System.out.println("|| 1. Login                                                        ||");
        System.out.println("|| 2. Keluar                                                       ||");
        System.out.println("=====================================================================");
    }

    public static void displayAdminMainMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                            Admin Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Kelola Saham                                              ||");
        System.out.println("||   [2] Kelola Surat Berharga Negara (SBN)                        ||");
        System.out.println("||   [3] Logout                                                    ||");
        System.out.println("=====================================================================");
    }

    public static void displaySahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                         Saham Menu Admin                        ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Tambah Saham Baru                                         ||");
        System.out.println("||   [2] Ubah Harga Saham                                          ||");
        System.out.println("||   [3] Lihat Daftar Saham                                        ||");
        System.out.println("||   [4] Hapus Saham                                               ||");
        System.out.println("||   [5] Kembali ke Admin Menu                                     ||");
        System.out.println("=====================================================================");
    }

    public static void displayLogin() {
        System.out.println("=====================================================================");
        System.out.println("||                          Login Menu                             ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   Masukkan Username dan Password untuk Login.                   ||");
        System.out.println("=====================================================================");
    }

    public static void displaySBNMenu() {
        System.out.println("======================================================================");
        System.out.println("||                      Surat Berharga Negara Menu                  ||");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("||   [1] Tambah Surat Berharga Negara Baru                          ||");
        System.out.println("||   [2] Lihat Daftar SBN                                           ||");
        System.out.println("||   [3] Hapus SBN                                                  ||");
        System.out.println("||   [4] Kembali ke Admin Menu                                      ||");
        System.out.println("======================================================================");
    }

    public static void displayCustomerMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                          Customer Menu                          ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||   [1] Lihat Portofolio                                          ||");
        System.out.println("||   [2] Beli Saham                                                ||");
        System.out.println("||   [3] Jual Saham                                                ||");
        System.out.println("||   [4] Beli Surat Berharga Negara (SBN)                          ||");
        System.out.println("||   [5] Simulasi Kupon SBN                                        ||");
        System.out.println("||   [6] Logout                                                    ||");
        System.out.println("=====================================================================");
    }

    public static void displayLoginFailed() {
        System.out.println("=====================================================================");
        System.out.println("||                        Login Gagal                              ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|| Username atau password yang Anda masukkan salah.                ||");
        System.out.println("=====================================================================");
    }

    public static void displayExitMessage() {
        System.out.println("=====================================================================");
        System.out.println("|| Terima kasih telah menggunakan aplikasi. Sampai jumpa!          ||");
        System.out.println("=====================================================================");
    }

    public static void displayInvalidChoice() {
        System.out.println("=====================================================================");
        System.out.println("|| Pilihan tidak valid, silakan coba lagi!                         ||");
        System.out.println("=====================================================================");
    }

    public static void displayLoginSuccess(String username) {
        System.out.println("=====================================================================");
        System.out.printf("||               Login sebagai %s berhasil.                  ||%n", username);
        System.out.println("=====================================================================");
    }

    public static void displayHeaderSBN() {
        System.out.println("=====================================================================");
        System.out.println("||             Tambah Surat Berharga Negara (SBN)                  ||");
        System.out.println("=====================================================================");
    }

    public static void displayHeaderSaham() {
        System.out.println("=====================================================================");
        System.out.println("||                          Tambah Saham                           ||");
        System.out.println("=====================================================================");
    }

    public static void displaySectionHeader(String title) {
        System.out.println("\n---------------- " + title + " ----------------\n");
    }

    public static void displaySahamTable(List<Saham> daftarSaham) {
        System.out.println("=================================================================================");
        System.out.println("||                                 Daftar Saham                                ||");
        System.out.println("=================================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-10s |\n", "No", "Kode", "Nama Perusahaan", "Harga", "Jumlah");
        System.out.println("=================================================================================");

        int no = 1;
        for (Saham saham : daftarSaham) {
            System.out.printf("| %-5d | %-10s | %-20s | %-20s | %-10d |\n",
                    no++, saham.getCode(), saham.getCompanyName(), formatRupiah(saham.getPrice()), saham.getQuantity());
        }

        System.out.println("=================================================================================");
    }

    public static void displaybuySBN(List<SuratBerhargaNegara> daftarSBN) {
        System.out.println("=================================================================================================================");
        System.out.println("||                                        Beli Surat Berharga Negara (SBN)                                     ||");
        System.out.println("=================================================================================================================");
        System.out.printf("| %-5s | %-25s | %-10s | %-10s | %-15s | %-25s |\n", "No", "Nama", "Bunga (%)", "Jangka (bulan)", "Jatuh Tempo", "Kuota Tersedia (Rp)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        int no = 1;
        for (SuratBerhargaNegara sbn : daftarSBN) {
            System.out.printf("| %-5d | %-25s | %-10.2f | %-14d | %-15s | %-25s |\n",
                    no++, sbn.getName(), sbn.getInterestRate(), sbn.getDurationMonths(), sbn.getMaturityDate(), formatRupiah(sbn.getQuota()));
        }
        System.out.println("=================================================================================================================");
    }


    public static String formatRupiah(double amount) {
        return String.format("Rp %,.0f", amount).replace(',', '.');
    }

    public static void displaySBNTable(List<SuratBerhargaNegara> daftarSBN) {
        System.out.println("=================================================================================================================");
        System.out.println("||                                      Daftar Surat Berharga Negara (SBN)                                     ||");
        System.out.println("=================================================================================================================");
        System.out.printf("| %-5s | %-25s | %-10s | %-10s | %-15s | %-25s |\n", "No", "Nama", "Bunga (%)", "Jangka (bulan)", "Jatuh Tempo", "Kuota (Rp)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        int no = 1;
        for (SuratBerhargaNegara sbn : daftarSBN) {
            String formattedQuota = formatRupiah(sbn.getQuota());
            System.out.printf("| %-5d | %-25s | %-10.2f | %-14d | %-15s | %-25s |\n",
                    no++, sbn.getName(), sbn.getInterestRate(), sbn.getDurationMonths(), sbn.getMaturityDate(), formattedQuota);
        }
        System.out.println("=================================================================================================================");
    }

    public static void displayPortfolioSahamTable(List<SahamHolding> holdings) {
        System.out.println("============================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-15s |\n", "No", "Kode", "Nama Perusahaan", "Lembar", "Harga");
        System.out.println("----------------------------------------------------------------------------");

        int no = 1;
        for (SahamHolding holding : holdings) {
            // Menampilkan harga per lembar saham dengan format Rupiah
            System.out.printf("| %-5d | %-10s | %-20s | %-10d | %-15s |\n",
                    no++, holding.getCode(), holding.getSaham().getCompanyName(), holding.getQuantity(), formatRupiah(holding.getSaham().getPrice()));
        }
        System.out.println("============================================================================");
    }

    public static void displayPortfolioSBNTable(List<SuratBerhargaNegaraHolding> holdings) {
        System.out.println("========================================================");
        System.out.printf("| %-5s | %-20s | %-20s |\n", "No", "Nama SBN", "Jumlah Investasi (Rp)");
        System.out.println("--------------------------------------------------------");
        int no = 1;
        for (SuratBerhargaNegaraHolding holding : holdings) {
            String formattedAmount = formatRupiah(holding.getAmount());
            System.out.printf("| %-5d | %-20s | %-21s |\n", no++, holding.getSuratBerhargaNegara().getName(), formattedAmount);
        }
        System.out.println("========================================================");
    }

    public static void displayKuponSimulation(double bunga, double nominal, double kuponPerBulan) {
        System.out.println("=====================================================================");
        System.out.println("||                      Hasil Simulasi Kupon SBN                   ||");
        System.out.println("=====================================================================");
        System.out.printf("Bunga Tahunan\t: %.2f%%%n", bunga);
        System.out.printf("Nominal Investasi\t : %s%n", formatRupiah(nominal));
        System.out.printf("Estimasi Kupon per Bulan: %s%n", formatRupiah(kuponPerBulan));
        System.out.println("=====================================================================");
    }

    public static void displayMessage(String message) {
        System.out.println("=====================================================================");
        System.out.println(message);
        System.out.println("=====================================================================");
    }

    public static void displayMessageAddsbn(String message) {
        System.out.println("=======================================================================================================================");
        System.out.println(message);
        System.out.println("=======================================================================================================================");
    }

    public static void displayStockNotFound() {
        System.out.println("=====================================================================");
        System.out.println("||      Anda tidak memiliki cukup lembar saham untuk dijual.       ||");
        System.out.println("=====================================================================");
    }

    public static void displayStockNotFoundMessage() {
        System.out.println("=====================================================================");
        System.out.println("||                        Saham tidak ditemukan.                   ||");
        System.out.println("=====================================================================");
    }

    public static void displayNoStocksMessage() {
        System.out.println("=====================================================================");
        System.out.println("||                   Anda belum memiliki saham.                    ||");
        System.out.println("=====================================================================");
    }

    public static void displayNoBondsMessage() {
        System.out.println("=====================================================================");
        System.out.println("||                   Anda belum memiliki SBN.                      ||");
        System.out.println("=====================================================================");
    }

    public static void displayPortfolioTitle() {
        System.out.println("=====================================================================");
        System.out.println("===                     Portofolio Anda                           ===");
        System.out.println("=====================================================================");
    }

    public static void displayInformation(Saham sahamBaru) {
        System.out.println("=================================================================================");

        System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-10s |\n", "No", "Kode Saham", "Nama Perusahaan", "Harga", "Jumlah");
        System.out.println("---------------------------------------------------------------------------------");

        String formattedPrice = formatRupiah(sahamBaru.getPrice());

        System.out.printf("| %-5d | %-10s | %-20s | %-20s | %-10d |\n",
                1, sahamBaru.getCode(), sahamBaru.getCompanyName(), formattedPrice, sahamBaru.getQuantity());

        System.out.println("=================================================================================");
    }

}