package src.model;

import src.model.Investasi;

public class Saham extends Investasi {
    private String kode;
    private String namaPerusahaan;
    private double harga;

    // Constructor
    public Saham(String kode, String namaPerusahaan, double harga) {
        super(namaPerusahaan, harga);  // Nama perusahaan dan harga diwariskan dari Investasi
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }

    // Getter dan Setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Saham [Kode: " + kode + ", Nama Perusahaan: " + namaPerusahaan + ", Harga: " + harga + "]");
    }
}
