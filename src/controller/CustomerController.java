package src.controller;

import src.model.Saham;
import src.model.SuratBerhargaNegara;

import java.text.DecimalFormat;
import java.util.*;

public class CustomerController {
    private final ArrayList<Saham> daftarSaham = new ArrayList<>();
    private final ArrayList<SuratBerhargaNegara> daftarSBN = new ArrayList<>();
    private final Map<Saham, Integer> sahamDimiliki = new HashMap<>();
    private final Map<SuratBerhargaNegara, Double> sbnDimiliki = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("#,###.00");

    public void tambahSaham(Saham saham) {
        daftarSaham.add(saham);
    }

    public void tambahSBN(SuratBerhargaNegara sbn) {
        daftarSBN.add(sbn);
    }

    public void tampilkanDaftarSaham() {
        System.out.println("\n=== Daftar Saham Tersedia ===");
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham saham = daftarSaham.get(i);
            System.out.printf("%d. %s (Kode: %s) - Harga: Rp %s\n",
                    i + 1,
                    saham.getNamaPerusahaan(),
                    saham.getKode(),
                    df.format(saham.getHarga()));
        }
    }

    public void tampilkanDaftarSBN() {
        System.out.println("\n=== Daftar SBN Tersedia ===");
        for (int i = 0; i < daftarSBN.size(); i++) {
            SuratBerhargaNegara sbn = daftarSBN.get(i);
            System.out.printf("%d. %s - Bunga: %.2f%% - Jangka Waktu: %d tahun - Kuota: Rp %s\n",
                    i + 1,
                    sbn.getNama(),
                    sbn.getBunga(),
                    sbn.getJangkaWaktu(),
                    df.format(sbn.getKuotaNasional()));
        }
    }

    public void beliSaham() {
        tampilkanDaftarSaham();
        System.out.print("Pilih nomor saham yang ingin dibeli: ");
        int pilihan = scanner.nextInt();

        if (pilihan < 1 || pilihan > daftarSaham.size()) {
            System.out.println("❌ Pilihan tidak valid.");
            return;
        }

        Saham sahamDipilih = daftarSaham.get(pilihan - 1);
        System.out.print("Masukkan jumlah lembar saham yang ingin dibeli: ");
        int jumlahLembar = scanner.nextInt();

        double totalHarga = sahamDipilih.getHarga() * jumlahLembar;
        System.out.println("Total harga: Rp " + df.format(totalHarga));

        sahamDimiliki.put(sahamDipilih, sahamDimiliki.getOrDefault(sahamDipilih, 0) + jumlahLembar);
        System.out.println("✅ Pembelian saham berhasil!");
    }

    public void beliSBN() {
        tampilkanDaftarSBN();
        System.out.print("Pilih nomor SBN yang ingin dibeli: ");
        int pilihan = scanner.nextInt();

        if (pilihan < 1 || pilihan > daftarSBN.size()) {
            System.out.println("❌ Pilihan tidak valid.");
            return;
        }

        SuratBerhargaNegara sbnDipilih = daftarSBN.get(pilihan - 1);
        System.out.print("Masukkan nominal pembelian (maks: Rp " + df.format(sbnDipilih.getKuotaNasional()) + "): ");
        double nominalPembelian = scanner.nextDouble();

        if (nominalPembelian > sbnDipilih.getKuotaNasional()) {
            System.out.println("❌ Nominal melebihi kuota.");
            return;
        }

        sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominalPembelian);
        sbnDimiliki.put(sbnDipilih, sbnDimiliki.getOrDefault(sbnDipilih, 0.0) + nominalPembelian);
        System.out.println("✅ Pembelian SBN berhasil!");
    }

    public void tampilkanPortofolio() {
        System.out.println("\n=== Portofolio Anda ===");

        // Portofolio Saham
        System.out.println("\n📊 Saham yang Dimiliki:");
        double totalSahamNominal = 0.0;
        double totalNilaiPasarSaham = 0.0;

        for (Map.Entry<Saham, Integer> entry : sahamDimiliki.entrySet()) {
            Saham saham = entry.getKey();
            int jumlah = entry.getValue();
            double nominal = saham.getHarga() * jumlah;
            double nilaiPasar = nominal;
            totalSahamNominal += nominal;
            totalNilaiPasarSaham += nilaiPasar;
            System.out.printf("%s - %d lembar - Total: Rp %s - Nilai Pasar: Rp %s\n",
                    saham.getNamaPerusahaan(),
                    jumlah,
                    df.format(nominal),
                    df.format(nilaiPasar));
        }

        System.out.println("Total Nilai Pembelian Saham: Rp " + df.format(totalSahamNominal));
        System.out.println("Total Nilai Pasar Saham: Rp " + df.format(totalNilaiPasarSaham));

        // Portofolio SBN
        System.out.println("\n📄 SBN yang Dimiliki:");
        double totalSBNNominal = 0.0;
        double totalKuponBulanan = 0.0;

        for (Map.Entry<SuratBerhargaNegara, Double> entry : sbnDimiliki.entrySet()) {
            SuratBerhargaNegara sbn = entry.getKey();
            double nominal = entry.getValue();
            double kuponBulanan = (sbn.getBunga() / 12.0 / 100.0) * 0.9 * nominal;

            totalSBNNominal += nominal;
            totalKuponBulanan += kuponBulanan;

            System.out.printf("%s - Nominal: Rp %s - Kupon/Bulan: Rp %s\n",
                    sbn.getNama(),
                    df.format(nominal),
                    df.format(kuponBulanan));
        }

        System.out.println("Total Nominal SBN: Rp " + df.format(totalSBNNominal));
        System.out.println("Total Kupon Bulanan dari SBN: Rp " + df.format(totalKuponBulanan));
    }
}
