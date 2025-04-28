package src.controller;

import src.model.*;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.user.Customer;
import src.view.TableView;
//import src.view.TableView;

import static src.controller.AdminController.*;

public class CustomerController {

    public static void menu(Customer customer) {
        while (true) {
            ScreenUtil.clearScreen();
            TableView.displayCustomerMenu();
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
        TableView.displayPortfolioTitle();

        System.out.println("\nSaham yang dimiliki:");
        if (portfolio.getSahamHoldings().isEmpty()) {
                TableView.displayNoStocksMessage();
        } else {
            TableView.displayPortfolioSahamTable(portfolio.getSahamHoldings());
        }

        System.out.println("\nSurat Berharga Negara yang dimiliki:");
        if (portfolio.getSuratBerhargaNegaraHoldings().isEmpty()) {
            TableView.displayNoBondsMessage();
        } else {
            TableView.displayPortfolioSBNTable(portfolio.getSuratBerhargaNegaraHoldings());
        }

        InputUtil.waitEnter();
    }

    private static void beliSaham(Portfolio portfolio) {
        ScreenUtil.clearScreen();
        System.out.println("=== Beli Saham ===");

        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham tersedia.");
            InputUtil.waitEnter();
            return;
        }

        TableView.displaySectionHeader("Daftar Saham");
        TableView.displaySahamTable(daftarSaham);

        String code = InputUtil.inputString("Kode saham yang ingin dibeli: ");
        Saham saham = findSahamByCode(code);
        if (saham == null) {
            TableView.displayStockNotFoundMessage();
            InputUtil.waitEnter();
            return;
        }
        int quantity = InputUtil.inputInt("Jumlah lembar yang ingin dibeli: ");

        if (quantity > saham.getQuantity()) {
            System.out.println("Jumlah lembar yang diminta melebihi stok tersedia (" + saham.getQuantity() + " lembar).");
            InputUtil.waitEnter();
            return;
        }

        portfolio.buySaham(saham, quantity);

        saham.setQuantity(saham.getQuantity() - quantity);

        System.out.println("Saham " + saham.getCompanyName() + " berhasil dibeli sebanyak " + quantity + " lembar.");
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

        TableView.displaySectionHeader("Saham yang Anda Miliki");
        TableView.displayPortfolioSahamTable(portfolio.getSahamHoldings());

        String code = InputUtil.inputString("Kode saham yang ingin dijual: ");
        SahamHolding selectedHolding = null;
        for (SahamHolding holding : portfolio.getSahamHoldings()) {
            if (holding.getSaham().getCode().equalsIgnoreCase(code)) {
                selectedHolding = holding;
                break;
            }
        }

        if (selectedHolding == null) {
            TableView.displayStockNotFound();
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
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            InputUtil.waitEnter();
            return;
        }

        TableView.displaybuySBN(daftarSBN);

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
        double jumlah = InputUtil.inputDouble("Jumlah pembelian Kuota (Rp): ");

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
        TableView.displaySectionHeader("Simulasi Kupon SBN per Bulan");

        double bunga = InputUtil.inputDouble("Masukkan persentase bunga tahunan (%): ");
        double nominal = InputUtil.inputDouble("Masukkan nominal investasi (Rp): ");

        double kuponPerBulan = (bunga / 12.0 / 100.0) * 0.9 * nominal;

        TableView.displaySectionHeader("Hasil Simulasi");
        TableView.displayKuponSimulation(bunga, nominal, kuponPerBulan);
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
