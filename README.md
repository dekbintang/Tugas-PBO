# InvestSim — Simulasi Investasi CLI

Aplikasi simulasi investasi Saham dan Surat Berharga Negara (SBN) berbasis command line. Dibangun dengan Java menerapkan prinsip OOP: inheritance, encapsulation, dan arsitektur modular.

## Tim

| Nama | NIM |
| :--- | :--- |
| I Kadek Bintang Adi Bimantara | 2405551049 |
| Richard Christian Mozart Diazoni | 2405551019 |

## Fitur

- Login multi-role (Admin & Customer)
- Manajemen saham: tambah, update harga, hapus
- Manajemen SBN: penerbitan, kuota, bunga, tenor
- Transaksi customer: beli/jual saham, beli SBN
- Simulasi kupon SBN (bulanan & tahunan)
- Portofolio investasi real-time
- Validasi input dan ketersediaan lembar/kuota

## UML

<img src="https://github.com/user-attachments/assets/834a21de-99cb-467b-bfc0-33a295de84c1" width="100%" />

## Arsitektur

```
src/
├── Main.java
├── controller/     # Logika bisnis
├── model/          # Entitas (Saham, SBN, Portfolio)
├── user/           # Admin, Customer (inheritance dari User)
├── util/           # Validasi input
└── view/           # Tampilan CLI
```

Konsep OOP yang diterapkan:
- **Inheritance** — class `Admin` dan `Customer` mewarisi `User`
- **Encapsulation** — akses atribut via getter/setter
- **Modular MVC** — pemisahan model, view, dan controller

## Dokumentasi

### Login & Menu Admin
<img src="https://github.com/user-attachments/assets/377b8de8-b2de-4f2e-bd02-88789e244723" width="100%" />
<img src="https://github.com/user-attachments/assets/e6422e5d-bd2b-4f41-8c64-2d9f05d94ff5" width="100%" />

### Manajemen Saham
<img src="https://github.com/user-attachments/assets/a7dc9ac3-baa9-4daf-9c25-b8f9bec6205b" width="100%" />

### Portofolio Customer
<img src="https://github.com/user-attachments/assets/65b41abd-e070-4a09-a456-3c4f0c0c9dc6" width="100%" />

### Simulasi Kupon SBN
<img src="https://github.com/user-attachments/assets/21a33d61-736b-4b7c-a83d-0210a7478c5e" width="100%" />

## Setup

```bash
git clone https://github.com/dekbintang/Tugas-PBO.git
cd Tugas-PBO
javac -d bin src/Main.java src/controller/*.java src/model/*.java src/user/*.java src/util/*.java src/view/*.java
java -cp bin Main
```

Membutuhkan JDK 17+.

## Lisensi

[MIT](LICENSE)
