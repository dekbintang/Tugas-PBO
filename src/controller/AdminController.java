package src.controller;

import src.model.Saham;
import src.model.SuratBerhargaNegara;
import src.util.InputUtil;
import src.util.ScreenUtil;

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
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Saham");
            System.out.println("2. Surat Berharga Negara (SBN)");
            System.out.println("3. Logout");
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
                    System.out.println("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void sahamMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Saham ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Tampilkan Daftar Saham");
            System.out.println("4. Kembali");
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
                    System.out.println("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void sbnMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Surat Berharga Negara ===");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Tampilkan Daftar SBN");
            System.out.println("3. Kembali");
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
                    System.out.println("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }

    private static void addSaham() {
        System.out.println("=== Tambah Saham Baru ===");
        String kode = InputUtil.inputString("Kode Saham: ");
        String namaPerusahaan = InputUtil.inputString("Nama Perusahaan: ");
        double harga = InputUtil.inputDouble("Harga Saham: ");

        Saham sahamBaru = new Saham(kode, namaPerusahaan, harga);
        daftarSaham.add(sahamBaru);

        System.out.println("Saham berhasil ditambahkan: " + sahamBaru);
        InputUtil.waitEnter();
    }

    // Metode untuk mengubah harga saham
    private static void modifySahamPrice() {
        System.out.println("=== Ubah Harga Saham ===");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia.");
            InputUtil.waitEnter();
            return;
        }

        // Menampilkan daftar saham
        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSaham.get(i));
        }

        // Memilih saham yang akan diubah harga
        int pilihSaham = InputUtil.inputInt("Pilih saham yang ingin diubah harganya: ");
        if (pilihSaham < 1 || pilihSaham > daftarSaham.size()) {
            System.out.println("Pilihan tidak valid.");
            InputUtil.waitEnter();
            return;
        }

        // Memasukkan harga baru
        Saham sahamDipilih = daftarSaham.get(pilihSaham - 1);
        double hargaBaru = InputUtil.inputDouble("Masukkan harga baru untuk " + sahamDipilih.getCompanyName() + ": ");
        sahamDipilih.setPrice(hargaBaru);

        System.out.println("Harga saham " + sahamDipilih.getCompanyName() + " berhasil diubah menjadi: Rp " + hargaBaru);
        InputUtil.waitEnter();
    }

    // Menampilkan daftar saham
    private static void showSahamList() {
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia.");
        } else {
            System.out.println("=== Daftar Saham ===");
            for (Saham saham : daftarSaham) {
                System.out.println(saham);
            }
        }
        InputUtil.waitEnter();
    }

    // Menambah SBN ke daftar
    private static void addSBN() {
        System.out.println("=== Tambah Surat Berharga Negara (SBN) ===");
        String nama = InputUtil.inputString("Nama SBN: ");
        double bunga = InputUtil.inputDouble("Bunga SBN: ");
        int jangkaWaktu = InputUtil.inputInt("Jangka Waktu (bulan): ");
        String jatuhTempo = InputUtil.inputString("Tanggal Jatuh Tempo (format: dd-MM-yyyy): ");
        double kuota = InputUtil.inputDouble("Kuota SBN: ");

        SuratBerhargaNegara sbnBaru = new SuratBerhargaNegara(nama, bunga, jangkaWaktu, jatuhTempo, kuota);
        daftarSBN.add(sbnBaru);

        System.out.println("SBN berhasil ditambahkan: " + sbnBaru);
        InputUtil.waitEnter();
    }

    // Menampilkan daftar SBN
    private static void showSBNList() {
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN yang tersedia.");
        } else {
            System.out.println("=== Daftar Surat Berharga Negara (SBN) ===");
            for (SuratBerhargaNegara sbn : daftarSBN) {
                System.out.println(sbn);
            }
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
