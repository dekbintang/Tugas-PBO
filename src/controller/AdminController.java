package src.controller;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.view.TableView;

import java.util.List;
import java.util.ArrayList;

public class AdminController {

    // Daftar Saham yang dikelola admin
    static List<Saham> daftarSaham = new ArrayList<>();

    // Daftar Surat Berharga Negara (SBN) yang dikelola admin
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
                    return;
                default:
                    TableView.displayMessage("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void addSaham() {
        ScreenUtil.clearScreen();
        TableView.displayHeader("Tambah Saham Baru");
        String kode = InputUtil.inputString("Kode Saham: ");
        String namaPerusahaan = InputUtil.inputString("Nama Perusahaan: ");
        double harga = InputUtil.inputDouble("Harga Saham: ");
        int kuantitas = InputUtil.inputInt("Jumlah Lembar Saham: ");

        Saham sahamBaru = new Saham(kode, namaPerusahaan, harga, kuantitas);
        daftarSaham.add(sahamBaru);

        TableView.displayInformation(sahamBaru);
        InputUtil.waitEnter();
    }

    // Metode untuk mengubah harga saham
    private static void modifySahamPrice() {
        ScreenUtil.clearScreen();
        TableView.displayHeader("Ubah Harga Saham");
        if (daftarSaham.isEmpty()) {
            TableView.displayMessage("Tidak ada saham yang tersedia.");
            InputUtil.waitEnter();
            return;
        }

        // Menampilkan daftar saham dalam bentuk tabel
        TableView.displaySahamTable(daftarSaham);

        // Memilih saham yang akan diubah harga
        int pilihSaham = InputUtil.inputInt("Pilih saham yang ingin diubah harganya: ");
        if (pilihSaham < 1 || pilihSaham > daftarSaham.size()) {
            TableView.displayMessage("Pilihan tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        // Memasukkan harga baru
        Saham sahamDipilih = daftarSaham.get(pilihSaham - 1);
        double hargaBaru = InputUtil.inputDouble("Masukkan harga baru untuk " + sahamDipilih.getCompanyName() + ": ");
        sahamDipilih.setPrice(hargaBaru);

        TableView.displayMessage("Harga saham " + sahamDipilih.getCompanyName() + " berhasil diubah menjadi: Rp " + hargaBaru);
        InputUtil.waitEnter();
    }

    // Menampilkan daftar saham
    private static void showSahamList() {
        ScreenUtil.clearScreen();
        if (daftarSaham.isEmpty()) {
            TableView.displayMessage("Tidak ada saham yang tersedia.");
        } else {
            TableView.displayHeader("Daftar Saham");
            TableView.displaySahamTable(daftarSaham);
        }
        InputUtil.waitEnter();
    }

    // Menambah SBN ke daftar
    private static void addSBN() {
        ScreenUtil.clearScreen();
        TableView.displayHeader("Tambah Surat Berharga Negara (SBN)");
        String nama = InputUtil.inputString("Nama SBN: ");
        double bunga = InputUtil.inputDouble("Bunga SBN: ");
        int jangkaWaktu = InputUtil.inputInt("Jangka Waktu (bulan): ");
        String jatuhTempo = InputUtil.inputString("Tanggal Jatuh Tempo (format: dd-MM-yyyy): ");
        double kuota = InputUtil.inputDouble("Kuota SBN: ");

        SuratBerhargaNegara sbnBaru = new SuratBerhargaNegara(nama, bunga, jangkaWaktu, jatuhTempo, kuota);
        daftarSBN.add(sbnBaru);

        TableView.displayMessage("SBN berhasil ditambahkan: " + sbnBaru);
        InputUtil.waitEnter();
    }

    // Menampilkan daftar SBN
    private static void showSBNList() {
        ScreenUtil.clearScreen();
        if (daftarSBN.isEmpty()) {
            TableView.displayMessage("Tidak ada SBN yang tersedia.");
        } else {
            TableView.displayHeader("Daftar Surat Berharga Negara (SBN)");
            TableView.displaySBNTable(daftarSBN);
        }
        InputUtil.waitEnter();
    }

    // Getter untuk daftar saham
    public static List<Saham> getDaftarSaham() {
        return daftarSaham;
    }

    // Getter untuk daftar SBN
    public static List<SuratBerhargaNegara> getDaftarSBN() {
        return daftarSBN;
    }
}