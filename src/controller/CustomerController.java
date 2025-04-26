package src.controller;

import src.model.*;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.user.Customer;

import static src.controller.AdminController.*;

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
        for (SahamHolding holding : portfolio.getSahamHoldings()) {
            System.out.println(holding.getSaham() + " | Jumlah: " + holding.getQuantity());
        }

        System.out.println("\nSurat Berharga Negara yang dimiliki:");
        for (SuratBerhargaNegaraHolding holding : portfolio.getSuratBerhargaNegaraHoldings()) {
            System.out.println(holding.getSuratBerhargaNegara() + " | Jumlah: Rp " + holding.getAmount());
        }

        InputUtil.waitEnter();
    }

    private static void beliSaham(Portfolio portfolio) {
        ScreenUtil  .clearScreen();
        System.out.println("=== Beli Saham ===");
        System.out.println("=== Daftar Saham ===");
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham saham = daftarSaham.get(i);
            System.out.printf("%d. %s (%s) - Harga: Rp%.2f\n", (i + 1), saham.getCompanyName(), saham.getCode(), saham.getPrice());
        }
        String code = InputUtil.inputString("Kode saham yang ingin dibeli: ");
        Saham saham = findSahamByCode(code);
        if (saham == null) {
            System.out.println("Saham tidak ditemukan.");
            InputUtil.waitEnter();
            return;
        }
        int quantity = InputUtil.inputInt("Jumlah lembar yang ingin dibeli: ");
        portfolio.buySaham(saham, quantity);
        System.out.println("Saham " + saham.getCompanyName() + " berhasil dibeli.");
        InputUtil.waitEnter();
    }

    private static void jualSaham(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Jual Saham ===");
        if (portfolio.getSahamHoldings().isEmpty()) {
            System.out.println("Anda tidak memiliki saham.");
            InputUtil.waitEnter();
            return;
        }

        int index = 1;
        for (SahamHolding holding : portfolio.getSahamHoldings()) {
            Saham saham = holding.getSaham();
            int quantity = holding.getQuantity();
            System.out.printf("%d. %s (%s) - Harga: Rp%.2f | Jumlah: %d lembar\n",
                    index, saham.getCompanyName(), saham.getCode(), saham.getPrice(), quantity);
            index++;
        }

        String code = InputUtil.inputString("Kode saham yang ingin dijual: ");
        SahamHolding selectedHolding = null;
        for (SahamHolding holding : portfolio.getSahamHoldings()) {
            if (holding.getSaham().getCode().equalsIgnoreCase(code)) {
                selectedHolding = holding;
                break;
            }
        }

        if (selectedHolding == null) {
            System.out.println("Saham tidak ditemukan di portofolio Anda.");
            InputUtil.waitEnter();
            return;
        }

        int quantityToSell = InputUtil.inputInt("Jumlah lembar yang ingin dijual: ");
        if (quantityToSell <= 0 || quantityToSell > selectedHolding.getQuantity()) {
            System.out.println("Jumlah lembar tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        boolean success = portfolio.sellSaham(selectedHolding.getSaham(), quantityToSell);
        if (success) {
            System.out.println("Saham " + selectedHolding.getSaham().getCompanyName() + " berhasil dijual sebanyak " + quantityToSell + " lembar.");
        } else {
            System.out.println("Gagal menjual saham.");
        }
        InputUtil.waitEnter();
    }


    private static void beliSuratBerhargaNegara(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Beli Surat Berharga Negara ===");

        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            InputUtil.waitEnter();
            return;
        }

        System.out.println("Daftar SBN:");
        for (int i = 0; i < daftarSBN.size(); i++) {
            SuratBerhargaNegara sbn = daftarSBN.get(i);
            System.out.printf("%d. %s - Bunga: %.2f%%, Kuota: Rp%.2f\n", (i + 1), sbn.getName(), sbn.getInterestRate(), sbn.getQuota());
        }

        // Tanya nama SBN yang ingin dibeli
        String namaSBN = InputUtil.inputString("Nama Surat Berharga Negara yang ingin dibeli: ");

// Cari SBN berdasarkan nama
        SuratBerhargaNegara sbnDipilih = findSBNByName(namaSBN);

// Cek apakah ketemu
        if (sbnDipilih == null) {
            System.out.println("SBN tidak ditemukan.");
            InputUtil.waitEnter();
            return;
        }

// Kalau ketemu, lanjut input jumlah
        double jumlah = InputUtil.inputDouble("Jumlah pembelian (Rp): ");

// Validasi jumlah
        if (jumlah <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0.");
            InputUtil.waitEnter();
            return;
        }

        if (jumlah > sbnDipilih.getQuota()) {
            System.out.println("Jumlah melebihi kuota tersedia.");
            InputUtil.waitEnter();
            return;
        }

// Kalau lolos semua validasi, di sini bisa lanjut proses pembelian


        sbnDipilih.setQuota(sbnDipilih.getQuota() - jumlah);
        portfolio.buySuratBerhargaNegara(sbnDipilih, jumlah);

        System.out.println("Berhasil membeli SBN " + sbnDipilih.getName() + " sebesar Rp " + jumlah);
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
        for (Saham saham : getDaftarSaham()) {
            if (saham.getCode().equalsIgnoreCase(code)) {
                return saham;
            }
        }
        return null; // Tidak ditemukan
    }

    private static SuratBerhargaNegara findSBNByName(String name) {
        for (SuratBerhargaNegara sbn : getDaftarSBN()) {
            if (sbn.getName().equalsIgnoreCase(name)) {
                return sbn;
            }
        }
        return null; // Tidak ditemukan
    }
}
