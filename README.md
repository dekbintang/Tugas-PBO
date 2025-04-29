# 📘 Pembuatan Program Investasi Sederhana Berbasis Command Line
## 💻 Deskripsi Singkat
> Hai! Ini adalah proyek kecil kami untuk memenuhi Tugas I PBO.

Aplikasi Java ini dibuat untuk simulasi investasi sederhana dengan dua jenis pengguna:
Admin bisa menambah, mengubah, dan menghapus produk investasi seperti saham dan SBN.
Customer bisa membeli/menjual saham, membeli SBN, simulasi bunga SBN, dan melihat portofolio.
Login menggunakan akun yang sudah di-hardcode dalam program.
Data disimpan di memori tanpa database atau file eksternal.

Program ini juga dilengkapi validasi input untuk memastikan data yang masuk sesuai.
Detail alur program, deskripsi class, dan diagram UML tersedia di bawah.
Kode lengkap sudah dilengkapi komentar untuk memudahkan pemahaman. Selamat mencoba! 🚀

---

## 🧑‍💻 Identitas Anggota
| Nama                               | NIM           |
|------------------------------------|---------------|
| I Kadek Bintang Adi Bimantara      | 2405551049    |
| Richard Christian Mozart Diazoni   | 2405551019    |

---

## 🗺️ Daftar Isi
- [Deskripsi Singkat](#-deskripsi-singkat)
- [Identitas Anggota](#-identitas-anggota)
- [Fitur Utama](#-fitur-utama)
- [Struktur Folder](#-struktur-folder)
- [Cara Menjalankan](#-cara-menjalankan)
- [UML Diagram](#-uml-diagram)
- [Contoh Screenshot](#-contoh-screenshot)
- [Lisensi](#-lisensi)

---

## 🚀 Fitur Utama
- [x] Login Admin dan Customer
- [x] Manajemen Saham (Tambah, Update Harga, Hapus)
- [x] Manajemen Surat Berharga Negara (Tambah SBN)
- [x] Investasi Saham dan SBN untuk Customer
- [x] Simulasi Kupon SBN
- [x] Portofolio Investasi
- [x] Sistem berbasis memori (tanpa database/file)

---

## 🗂️ Struktur Folder
```plaintext
📦 project-root
 ┣ 📂 controller
 ┣ 📂 model
 ┣ 📂 user
 ┣ 📂 util
 ┣ 📂 view
 ┣ 📜 Main.java
