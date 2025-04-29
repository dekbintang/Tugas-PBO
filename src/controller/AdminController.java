package src.controller;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.user.Customer;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.view.TableView;

import java.util.List;
import java.util.ArrayList;

import static src.view.TableView.formatRupiah;

public class AdminController {

    static List<Saham> daftarSaham = new ArrayList<>();

    static List<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    public static void menu() {
        while (true) {
            ScreenUtil.clearScreen();
            TableView.displayAdminMainMenu();
            int pilih = InputUtil.inputInt("Pilih: ");
            switch (pilih) {
                case 1:
                    sahamMenu();
                    break;
                case 2:
                    sbnMenu();
                    break;
                case 3:
                    return;
                default:
                    TableView.displayMessage("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void sahamMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            TableView.displaySahamMenu();
            int pilih = InputUtil.inputInt("Pilih: ");
            switch (pilih) {
                case 1:
                    addSaham();
                    break;
                case 2:
                    modifySahamPrice();
                    break;
                case 3:
                    showSahamList();
                    break;
                case 4:
                    deleteSaham();
                    break;
                case 5:
                    return;
                default:
                    TableView.displayMessage("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void sbnMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            TableView.displaySBNMenu();
            int pilih = InputUtil.inputInt("Pilih: ");
            switch (pilih) {
                case 1:
                    addSBN();
                    break;
                case 2:
                    showSBNList();
                    break;
                case 3:
                    deleteSBN();
                case 4:
                    return;
                default:
                    TableView.displayMessage("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void addSaham() {
        ScreenUtil.clearScreen();
        TableView.displayHeaderSaham();
        String kode = InputUtil.inputString("Kode Saham: ");
        String namaPerusahaan = InputUtil.inputString("Nama Perusahaan: ");
        double harga = InputUtil.inputDouble("Harga Saham: ");
        int kuantitas = InputUtil.inputInt("Jumlah Lembar Saham: ");

        Saham sahamBaru = new Saham(kode, namaPerusahaan, harga, kuantitas);
        daftarSaham.add(sahamBaru);

        TableView.displayInformation(sahamBaru);
        InputUtil.waitEnter();
    }

    private static void modifySahamPrice() {
        ScreenUtil.clearScreen();
        if (daftarSaham.isEmpty()) {
            TableView.displayMessage("Tidak ada saham yang tersedia.");
            InputUtil.waitEnter();
            return;
        }

        TableView.displaySahamTable(daftarSaham);

        int pilihSaham = InputUtil.inputInt("Pilih saham yang ingin diubah harganya: ");
        if (pilihSaham < 1 || pilihSaham > daftarSaham.size()) {
            TableView.displayMessage("Pilihan tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        Saham sahamDipilih = daftarSaham.get(pilihSaham - 1);
        double hargaBaru = InputUtil.inputDouble("Masukkan harga baru untuk " + sahamDipilih.getCompanyName() + ": ");
        sahamDipilih.setPrice(hargaBaru);

        TableView.displayMessage("Harga saham " + sahamDipilih.getCompanyName() + " berhasil diubah menjadi: " + formatRupiah(hargaBaru));
        InputUtil.waitEnter();
    }

    private static void showSahamList() {
        ScreenUtil.clearScreen();
        if (daftarSaham.isEmpty()) {
            TableView.displayMessage("Tidak ada saham yang tersedia.");
        } else {
            TableView.displaySahamTable(daftarSaham);
        }
        InputUtil.waitEnter();
    }

    private static void deleteSaham() {
        ScreenUtil.clearScreen();
        if (daftarSaham.isEmpty()) {
            TableView.displayMessage("Tidak ada saham yang tersedia untuk dihapus.");
            InputUtil.waitEnter();
            return;
        }

        TableView.displaySahamTable(daftarSaham);

        int pilihSaham = InputUtil.inputInt("Pilih nomor saham yang ingin dihapus: ");
        if (pilihSaham < 1 || pilihSaham > daftarSaham.size()) {
            TableView.displayMessage("Pilihan tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        Saham sahamDihapus = daftarSaham.remove(pilihSaham - 1);
        AppController.getCustomer().getPortfolio().removeSahamIfExists(sahamDihapus);

        TableView.displayMessage("Saham " + sahamDihapus.getCompanyName() + " berhasil dihapus.");
        InputUtil.waitEnter();
    }

    private static void addSBN() {
        ScreenUtil.clearScreen();
        TableView.displayHeaderSBN();
        String nama = InputUtil.inputString("Nama SBN: ");
        double bunga = InputUtil.inputDouble("Bunga SBN (%): ");
        int jangkaWaktu = InputUtil.inputInt("Jangka Waktu (bulan): ");
        String jatuhTempo = InputUtil.inputString("Tanggal Jatuh Tempo (format: DD-MM-YYYY): ");
        double kuota = InputUtil.inputDouble("Kuota SBN yang tersedia: ");

        SuratBerhargaNegara sbnBaru = new SuratBerhargaNegara(nama, bunga, jangkaWaktu, jatuhTempo, kuota);
        daftarSBN.add(sbnBaru);

        TableView.displayMessageAddsbn("SBN berhasil ditambahkan: " + sbnBaru);
        InputUtil.waitEnter();
    }

    private static void showSBNList() {
        ScreenUtil.clearScreen();
        if (daftarSBN.isEmpty()) {
            TableView.displayMessage("Tidak ada SBN yang tersedia.");
        } else {
            TableView.displaySBNTable(daftarSBN);
        }
        InputUtil.waitEnter();
    }

    private static void deleteSBN() {
        ScreenUtil.clearScreen();
        if (daftarSBN.isEmpty()) {
            TableView.displayMessage("Tidak ada SBN yang tersedia untuk dihapus.");
            InputUtil.waitEnter();
            return;
        }

        TableView.displaySBNTable(daftarSBN);

        int pilihSBN = InputUtil.inputInt("Pilih nomor SBN yang ingin dihapus: ");
        if (pilihSBN < 1 || pilihSBN > daftarSBN.size()) {
            TableView.displayMessage("Pilihan tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        SuratBerhargaNegara sbnDihapus = daftarSBN.remove(pilihSBN - 1);

        Customer customer = AppController.getCustomer();
        customer.getPortfolio().removeSBNIfExists(sbnDihapus);

        TableView.displayMessage("SBN " + sbnDihapus.getName() + " berhasil dihapus.");
        InputUtil.waitEnter();
    }


    public static List<Saham> getDaftarSaham() {
        return daftarSaham;
    }

    public static List<SuratBerhargaNegara> getDaftarSBN() {
        return daftarSBN;
    }
}