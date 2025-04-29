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

## 🚀 Fitur Utama
- [x] Login Admin dan Customer
- [x] Manajemen Saham (Tambah, Update Harga, Hapus)
- [x] Manajemen Surat Berharga Negara (Tambah SBN)
- [x] Investasi Saham dan SBN untuk Customer
- [x] Simulasi Kupon SBN
- [x] Portofolio Investasi
- [x] Sistem berbasis memori (tanpa database/file)

---

## 🛠️ Bagaimana Program Dijalankan

Program ini dijalankan dengan menerapkan konsep Object-Oriented Programming (OOP) secara menyeluruh dalam desain dan implementasinya. Program mengutamakan modularitas, pemisahan tanggung jawab antar class, serta penggunaan alur kontrol yang terstruktur agar lebih terorganisir dan mudah dikembangkan.

Konsep yang Digunakan

- ✅ Penggunaan Class dan Object
- 🔄 Penggunaan Flow Control
- 📦 Penggunaan ArrayList
- 🧬 Penerapan Inheritance (Pewarisan)
- 🔐 Penerapan Encapsulation (Enkapsulasi)

## ⚙️Penjelasan Program
Berikut adalah tampilan hasil penggunaan program pemesanan online, lengkap dengan beberapa screenshot. Penjelasan mengenai alur kerja kode dijabarkan setelah bagian ini.

## Menu Utama
<img src="https://github.com/user-attachments/assets/377b8de8-b2de-4f2e-bd02-88789e244723" width="100%" />
Pada tampilan awal, pengguna akan disajikan dengan menu utama yang menawarkan dua opsi utama: login dan keluar. Dari sini, pengguna dapat memilih untuk masuk ke dalam sistem dengan login, atau keluar dari aplikasi. Tampilan ini menjadi titik awal sebelum masuk ke sistem sebagai admin atau customer.

## Login Gagal
<img src="https://github.com/user-attachments/assets/d1b6bafe-ea8c-41ea-823a-2de6ae83c1e8" width="100%" />
<img src="https://github.com/user-attachments/assets/e9140a04-8929-43ba-bfc7-338153e86e7f" width="100%" />

## Login Admin
<img src="https://github.com/user-attachments/assets/ebf11aba-c68e-413e-86da-6faf2984698a" width="100%" />
<img src="https://github.com/user-attachments/assets/1e9409b6-027c-4c43-b7c0-04ca0bc154b1" width="100%" />
Setelah memilih login, pengguna yang berperan sebagai admin akan diminta memasukkan username dan password mereka. Jika informasi yang dimasukkan benar, maka sistem akan menampilkan pesan bahwa login berhasil, dan pengguna diarahkan ke menu admin. Jika tidak sesuai, sistem akan meminta untuk mengulang login kembali.

## Menu Admin
<img src="https://github.com/user-attachments/assets/e6422e5d-bd2b-4f41-8c64-2d9f05d94ff5" width="100%" />
Menu ini memungkinkan admin untuk mengelola dua jenis produk investasi, yaitu saham dan surat berharga negara (SBN). Terdapat tiga opsi: kelola saham, kelola SBN, dan logout. Menu ini adalah pusat kontrol bagi admin untuk mengatur data investasi yang tersedia dalam sistem.

## Menu Saham
<img src="https://github.com/user-attachments/assets/a3ae912e-c27b-4d13-a7dd-c9df5528e085" width="100%" />
Dalam menu ini, admin bisa menambahkan data saham baru, mengubah harga saham yang sudah ada, melihat daftar saham yang tersedia, atau kembali ke menu sebelumnya. Fitur ini penting untuk memperbarui informasi terkait saham yang ditawarkan kepada customer.

## Tambah Saham
<img src="https://github.com/user-attachments/assets/dbc97d65-1a2c-4c44-ac11-c96c2971a164" width="100%" />
<img src="https://github.com/user-attachments/assets/56814153-b022-4a57-bb3c-1664681273c1" width="100%" />
Admin dapat menambahkan saham baru dengan mengisi informasi seperti kode saham, nama perusahaan, harga saham, dan jumlah lembar yang tersedia. Setelah data dimasukkan, sistem akan langsung menampilkan daftar saham dengan informasi baru yang ditambahkan.

## Ubah Harga Saham
<img src="https://github.com/user-attachments/assets/dbb35cfb-ca3a-4438-8747-fbd48aaaedb1" width="100%" />
<img src="https://github.com/user-attachments/assets/f9427f95-b3dd-47c5-8b02-cfa2cbb68c41" width="100%" />
Admin bisa memilih saham yang ingin diubah harganya, kemudian memasukkan harga baru. Setelah disimpan, perubahan akan langsung terlihat dalam daftar saham. Ini memungkinkan admin untuk menyesuaikan harga sesuai kondisi pasar terkini.

## Daftar Saham
*Sebelum diubah:*
<img src="https://github.com/user-attachments/assets/1251de54-7314-4708-81e1-598ce327814f" width="100%" />

*Setelah diubah:*
<img src="https://github.com/user-attachments/assets/d922530b-36d8-4fc2-a818-3fe5b5276943" width="100%" />
Gambar ini menunjukkan perbandingan daftar saham sebelum dan sesudah harga diubah. Ini menampilkan bagaimana sistem memperbarui data secara real-time setelah admin melakukan perubahan.

## Menu Surat Berharga Negara (SBN)
<img src="https://github.com/user-attachments/assets/ba10a878-46c3-4c71-be6f-bd3a7af03265" width="100%" />
Mirip dengan menu saham, admin bisa memilih untuk menambah SBN baru, melihat daftar SBN yang tersedia, atau kembali ke menu admin. Menu ini dirancang untuk mengatur produk investasi jenis surat berharga negara.

## Tambah Surat Berharga Negara (SBN)
<img src="https://github.com/user-attachments/assets/50248cb7-6f5c-4389-af06-c3878238667f" width="100%" />
<img src="https://github.com/user-attachments/assets/a6a5c190-652a-40e2-8c35-773763828b0a" width="100%" />
Admin akan diminta mengisi data SBN seperti nama, tingkat bunga, jangka waktu, tanggal jatuh tempo, dan kuota. Setelah disubmit, data tersebut langsung ditampilkan dalam tabel daftar SBN. Ini memberi fleksibilitas bagi admin dalam menyediakan produk investasi SBN.

## Lihat Daftar Surat Berharga Negara (SBN)
<img src="https://github.com/user-attachments/assets/56920aa6-49f5-49b1-afca-a6902f26f715" width="100%" />
Menampilkan semua SBN yang telah dimasukkan oleh admin, termasuk informasi penting seperti bunga, jangka waktu, dan kuota. Menu ini penting untuk mengevaluasi dan memverifikasi produk yang tersedia.

## Login Customer
<img src="https://github.com/user-attachments/assets/883717cf-ccc1-4820-94e7-f30b4adc8176" width="100%" />
<img src="https://github.com/user-attachments/assets/daac81c3-197a-4e6c-8ae2-225d83f978ad" width="100%" />
Pengguna yang memilih login sebagai customer akan diminta memasukkan username dan password mereka. Jika berhasil, sistem mengkonfirmasi login dan mengizinkan customer mengakses fitur-fitur seperti pembelian, penjualan, dan simulasi investasi.

## Lihat Portofolio
*Sebelum menambah:*
<img src="https://github.com/user-attachments/assets/9c52341c-88bf-444f-8041-384d54494da8" width="100%" />

*Setelah menambah:*  
<img src="https://github.com/user-attachments/assets/16445b40-4f3c-4a8f-b57c-e60586180f7f" width="100%" />
Sebelum customer membeli saham atau SBN, sistem akan menampilkan pesan bahwa belum ada investasi. Setelah pembelian dilakukan, sistem menampilkan daftar saham dan/atau SBN yang dimiliki beserta jumlah dan nilainya.

## Beli Saham
<img src="https://github.com/user-attachments/assets/a595057a-b909-4d34-b309-e4c17afc08be" width="100%" />
<img src="https://github.com/user-attachments/assets/f5ce6fc4-da45-42a5-9d92-5725485c5eb1" width="100%" />
Customer dapat memilih saham dari daftar dan menentukan jumlah lembar yang ingin dibeli. Sistem kemudian mengonfirmasi pembelian dengan menampilkan pesan bahwa transaksi berhasil.

## Jual Saham
<img src="https://github.com/user-attachments/assets/8abc3276-670a-461d-9cb6-d49f39290ded" width="100%" />
Pada fitur ini, customer memilih saham yang ingin dijual dan jumlahnya. Setelah dikonfirmasi, sistem akan menampilkan pesan bahwa saham berhasil dijual.

## Beli Surat Berharga Negara (SBN)
<img src="https://github.com/user-attachments/assets/77f92dd6-dd0d-4257-a852-0315ec3dc128" width="100%" />
Customer dapat membeli SBN dengan memilih dari daftar dan menentukan jumlah yang diinginkan. Sistem mengonfirmasi transaksi dan memperbarui portofolio customer secara otomatis.

## Simulasi Kupon SBN
<img src="https://github.com/user-attachments/assets/21a33d61-736b-4b7c-a83d-0210a7478c5e" width="100%" />
Fitur ini memungkinkan customer menghitung estimasi kupon bulanan dan tahunan berdasarkan bunga dan nominal investasi yang dimasukkan. Ini berguna untuk perencanaan investasi yang lebih matang.

## Tampilan Keluar Program
<img src="https://github.com/user-attachments/assets/059a0437-db59-4ebd-99b9-5f4d23ba8475" width="100%" />
Pesan ini berfungsi sebagai ucapan terima kasih dan penanda akhir sesi, sehingga memberikan pengalaman penggunaan yang lebih ramah dan profesional. Hal ini penting untuk membangun kesan positif dan komunikasi yang baik antara aplikasi dan penggunanya.
