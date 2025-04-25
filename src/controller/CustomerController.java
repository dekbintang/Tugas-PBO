package src.controller;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.model.Portfolio;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.user.Customer;

public class CustomerController {

    public static void menu(Customer customer) {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Customer ===");
            System.out.println("1. Lihat Portofolio");
            System.out.println("2. Beli Saham");
            System.out.println("3. Jual Saham");
            System.out.println("4. Beli Surat Berharga Negara");
            System.out.println("5. Simulasi Kupon SBN");
            System.out.println("6. Logout");
            int pilih = InputUtil.inputInt("Pilih: ");
            switch (pilih) {
                case 1:
                    lihatPortofolio(customer.getPortfolio());
                    break;
                case 2:
                    beliSaham(customer.getPortfolio());
                    break;
                case 3:
                    jualSaham(customer.getPortfolio());
                    break;
                case 4:
                    beliSuratBerhargaNegara(customer.getPortfolio());
                    break;
                case 5:
                    simulasiKuponSBN();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void lihatPortofolio(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Portofolio Anda ===");
        System.out.println("Saham yang dimiliki:");
        portfolio.getSahamHoldings().forEach((saham, quantity) -> {
            System.out.println(saham + " | Jumlah: " + quantity);
        });
        System.out.println("\nSurat Berharga Negara yang dimiliki:");
        portfolio.getSuratBerhargaNegaraHoldings().forEach((sbn, amount) -> {
            System.out.println(sbn + " | Jumlah: Rp " + amount);
        });
        InputUtil.waitEnter();
    }

    private static void beliSaham(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Beli Saham ===");
        String code = InputUtil.inputString("Kode saham yang ingin dibeli: ");
        Saham saham = findSahamByCode(code);
        if (saham == null) {
            System.out.println("Saham tidak ditemukan.");
            InputUtil.waitEnter();
            return;
        }
        int quantity = InputUtil.inputInt("Jumlah yang ingin dibeli: ");
        portfolio.buySaham(saham, quantity);
        System.out.println("Saham " + saham.getCompanyName() + " berhasil dibeli.");
        InputUtil.waitEnter();
    }

    private static void jualSaham(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Jual Saham ===");
        String code = InputUtil.inputString("Kode saham yang ingin dijual: ");
        Saham saham = findSahamByCode(code);
        if (saham == null) {
            System.out.println("Saham tidak ditemukan.");
            InputUtil.waitEnter();
            return;
        }
        int quantity = InputUtil.inputInt("Jumlah yang ingin dijual: ");
        if (portfolio.sellSaham(saham, quantity)) {
            System.out.println("Saham " + saham.getCompanyName() + " berhasil dijual.");
        } else {
            System.out.println("Tidak cukup saham yang dimiliki.");
        }
        InputUtil.waitEnter();
    }

    private static void beliSuratBerhargaNegara(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Beli Surat Berharga Negara ===");
        String name = InputUtil.inputString("Nama SBN yang ingin dibeli: ");
        SuratBerhargaNegara sbn = findSBNByName(name);
        if (sbn == null) {
            System.out.println("SBN tidak ditemukan.");
            InputUtil.waitEnter();
            return;
        }
        double amount = InputUtil.inputDouble("Jumlah yang ingin dibeli (Rp): ");
        if (amount > sbn.getQuota()) {
            System.out.println("Kuota SBN tidak cukup.");
            InputUtil.waitEnter();
            return;
        }
        portfolio.buySuratBerhargaNegara(sbn, amount);
        sbn.reduceQuota(amount);
        System.out.println("SBN " + sbn.getName() + " berhasil dibeli.");
        InputUtil.waitEnter();
    }

    private static void simulasiKuponSBN() {
        ScreenUtil.clearScreen();
        System.out.println("=== Simulasi Kupon SBN per Bulan ===");
        double bunga = InputUtil.inputDouble("Masukkan persentase bunga tahunan (%): ");
        double nominal = InputUtil.inputDouble("Masukkan nominal investasi (Rp): ");

        double kuponPerBulan = (bunga / 12.0 / 100.0) * 0.9 * nominal;

        System.out.printf("Perkiraan kupon yang diterima per bulan: Rp %.2f\n", kuponPerBulan);
        InputUtil.waitEnter();
    }

    private static Saham findSahamByCode(String code) {
        // Cari saham berdasarkan kode (implementasi pencarian bisa dikustomisasi)
        return new Saham(code, "Perusahaan X", 50000.0); // Contoh sementara
    }

    private static SuratBerhargaNegara findSBNByName(String name) {
        // Cari SBN berdasarkan nama (implementasi pencarian bisa dikustomisasi)
        return new SuratBerhargaNegara(name, 5.0, 12, "2026-12-31", 10000000); // Contoh sementara
    }
}
