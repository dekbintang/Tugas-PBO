<div align="center">

# 📈 InvestSim CLI — Java OOP Investment Simulator
### *Object-Oriented Terminal Investment & Portfolio Management System*

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Paradigm](https://img.shields.io/badge/Paradigm-Object--Oriented_Programming-007396?style=for-the-badge)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Architecture](https://img.shields.io/badge/Architecture-Modular_MVC-4CAF50?style=for-the-badge)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

<p align="center">
  Aplikasi simulasi investasi pasar modal (Saham & Surat Berharga Negara/SBN) berbasis antarmuka Command Line Interface (CLI). Dibangun dengan menerapkan prinsip fundamental Object-Oriented Programming (OOP) secara mendalam: Pewarisan (Inheritance), Enkapsulasi (Encapsulation), dan Pemisahan Tanggung Jawab Modular.
</p>

</div>

---

## 👥 Tim Pengembang

| Nama | NIM | Kelas / Program Studi |
| :--- | :--- | :--- |
| **I Kadek Bintang Adi Bimantara** | `2405551049` | Teknologi Informasi — Universitas Udayana |
| **Richard Christian Mozart Diazoni** | `2405551019` | Teknologi Informasi — Universitas Udayana |

---

## 📌 Deskripsi Singkat
Aplikasi Java ini menyimulasikan sistem transaksi investasi finansial dua sisi pengguna:
* **Admin Portal**: Menambah, mengubah harga *real-time*, dan menghapus instrumen investasi (Saham & SBN).
* **Customer Portal**: Membeli/menjual lot saham, berinvestasi pada SBN, menjalankan kalkulator simulasi kupon bunga SBN, dan memantau portofolio aset.
* **In-Memory Storage**: Penyimpanan state berbasis koleksi objek (`ArrayList`) dengan validasi input yang ketat.

---

## 🌟 Fitur Utama
- [x] Sistem Autentikasi Pengguna Multi-Role (Admin & Customer)
- [x] Manajemen Pasar Saham (Tambah Saham, Update Harga Dinamis, Hapus)
- [x] Manajemen Surat Berharga Negara (Penerbitan SBN, Kuota, Bunga, dan Tenor)
- [x] Modul Transaksi Customer (Beli/Jual Saham dengan validasi ketersediaan lembar)
- [x] Kalkulator & Simulasi Kupon SBN Bulanan/Tahunan
- [x] Pelacakan Real-time Portofolio & Nilai Investasi
- [x] Arsitektur Bersih berbasis package (`controller`, `model`, `user`, `util`, `view`)

---

## 🏗️ Diagram Kelas UML
<p align="center">
  <img src="https://github.com/user-attachments/assets/834a21de-99cb-467b-bfc0-33a295de84c1" width="100%" alt="UML Class Diagram" />
</p>

---

## 💻 Penerapan Konsep Object-Oriented Programming (OOP)
Program ini mengedepankan modularitas dan arsitektur *clean code*:
1. **Class & Object**: Pemodelan entitas riil dunia finansial (`Saham`, `SBN`, `Portfolio`, `Customer`, `Admin`).
2. **Inheritance (Pewarisan)**: Penggunaan class dasar `User` yang diturunkan menjadi `Admin` dan `Customer`, serta generalisasi produk investasi.
3. **Encapsulation (Enkapsulasi)**: Proteksi atribut menggunakan *access modifier private/protected* dengan *getter* dan *setter* tervalidasi.
4. **Data Structures**: Manajemen daftar dinamis menggunakan Java `ArrayList`.

---

## 📸 Dokumentasi Antarmuka & Alur Kerja

### 1. Menu Utama & Autentikasi
<img src="https://github.com/user-attachments/assets/377b8de8-b2de-4f2e-bd02-88789e244723" width="100%" />
<p align="justify">Tampilan awal menawarkan pemilihan mode login atau keluar. Validasi diterapkan jika kredensial tidak sesuai.</p>

<img src="https://github.com/user-attachments/assets/d1b6bafe-ea8c-41ea-823a-2de6ae83c1e8" width="100%" />

### 2. Panel Admin & Manajemen Produk
<img src="https://github.com/user-attachments/assets/e6422e5d-bd2b-4f41-8c64-2d9f05d94ff5" width="100%" />
<p align="justify">Pusat kontrol admin untuk mengelola instrumen Saham dan Surat Berharga Negara (SBN).</p>

#### Manajemen Saham
<img src="https://github.com/user-attachments/assets/a7dc9ac3-baa9-4daf-9c25-b8f9bec6205b" width="100%" />
<p align="justify">Admin dapat menambahkan emiten baru, mengupdate harga per lembar secara berkala, dan memantau volume saham yang beredar.</p>

*Perbandingan Daftar Saham Sebelum dan Sesudah Perubahan Harga:*  
<img src="https://github.com/user-attachments/assets/1251de54-7314-4708-81e1-598ce327814f" width="100%" />
<img src="https://github.com/user-attachments/assets/d922530b-36d8-4fc2-a818-3fe5b5276943" width="100%" />

#### Manajemen SBN (Surat Berharga Negara)
<img src="https://github.com/user-attachments/assets/ccbf87a9-6358-41a2-87d3-4a23137c2fea" width="100%" />
<img src="https://github.com/user-attachments/assets/56920aa6-49f5-49b1-afca-a6902f26f715" width="100%" />

### 3. Panel Customer & Transaksi Investasi
<img src="https://github.com/user-attachments/assets/883717cf-ccc1-4820-94e7-f30b4adc8176" width="100%" />

#### Portofolio Kepemilikan Aset
<img src="https://github.com/user-attachments/assets/b6447b20-eff3-4e15-b4b9-316fa99c8a42" width="100%" />
<img src="https://github.com/user-attachments/assets/65b41abd-e070-4a09-a456-3c4f0c0c9dc6" width="100%" />

#### Transaksi Pembelian & Penjualan Saham
<p align="justify">Dilengkapi validasi kuota batas lembar saham agar nasabah tidak dapat memesan melebihi pasokan yang tersedia.</p>
<img src="https://github.com/user-attachments/assets/504ab344-89be-4320-a506-f4a1aafcead7" width="100%" />
<img src="https://github.com/user-attachments/assets/f5ce6fc4-da45-42a5-9d92-5725485c5eb1" width="100%" />

#### Simulasi Kupon Imbal Hasil SBN
<img src="https://github.com/user-attachments/assets/21a33d61-736b-4b7c-a83d-0210a7478c5e" width="100%" />
<p align="justify">Kalkulator otomatis untuk menghitung imbal hasil kupon bulanan maupun tahunan sebelum nasabah memutuskan membeli produk obligasi negara.</p>

---

## ⚡ Panduan Menjalankan Proyek

### Prasyarat
* Java Development Kit (JDK) 17 atau versi lebih tinggi.

### Langkah-Langkah
1. **Clone Repositori:**
   ```bash
   git clone https://github.com/dekbintang/Tugas-PBO.git
   cd Tugas-PBO
   ```
2. **Kompilasi Program:**
   ```bash
   javac -d bin src/Main.java src/controller/*.java src/model/*.java src/user/*.java src/util/*.java src/view/*.java
   ```
3. **Jalankan Aplikasi CLI:**
   ```bash
   java -cp bin Main
   ```

---

## 📄 Lisensi
Proyek ini dilisensikan di bawah [Lisensi MIT](LICENSE).
