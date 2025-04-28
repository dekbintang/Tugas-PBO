//package src.view;
//
//import src.model.Saham;
//import src.model.SuratBerhargaNegara;
//import java.util.List;
//
//public class AdminView {
//
//    public static void displaySahamTable(List<Saham> daftarSaham) {
//        TableView table = new TableView();
//        table.setHeaders("No", "Kode", "Nama Perusahaan", "Harga (Rp)");
//
//        int index = 1;
//        for (Saham saham : daftarSaham) {
//            table.addRow(
//                    String.valueOf(index++),
//                    saham.getCode(),
//                    saham.getCompanyName(),
//                    String.format("%.2f", saham.getPrice())
//            );
//        }
//
//        table.render();
//    }
//
//    public static void displaySBNTable(List<SuratBerhargaNegara> daftarSBN) {
//        TableView table = new TableView();
//        table.setHeaders("No", "Nama", "Bunga (%)", "Jangka Waktu", "Jatuh Tempo", "Kuota (Rp)");
//
//        int index = 1;
//        for (SuratBerhargaNegara sbn : daftarSBN) {
//            table.addRow(
//                    String.valueOf(index++),
//                    sbn.getName(),
//                    String.format("%.2f", sbn.getInterestRate()),
//                    sbn.getDurationMonths() + " bulan",
//                    sbn.getMaturityDate(),
//                    String.format("%.2f", sbn.getQuota())
//            );
//        }
//
//        table.render();
//    }
//
//    // Method tambahan untuk menampilkan menu-menu dalam bentuk tabel
//
//    public static void displayAdminMainMenu() {
//        TableView table = new TableView();
//        table.setHeaders("Selamat Datang Admin");
//
//        table.addRow("1. Saham");
//        table.addRow("2. Surat Berharga Negara (SBN)");
//        table.addRow("3. Logout");
//
//        table.render();
//    }
//
//    public static void displaySahamMenu() {
//        TableView table = new TableView();
//        table.setHeaders("Saham");
//
//        table.addRow("1. Tambah Saham");
//        table.addRow("2. Ubah Harga Saham");
//        table.addRow("3. Tampilkan Daftar Saham");
//        table.addRow("4. Kembali");
//
//        table.render();
//    }
//
//    public static void displaySBNMenu() {
//        TableView table = new TableView();
//        table.setHeaders("Surat Berharga Negara");
//
//        table.addRow("1. Tambah SBN");
//        table.addRow("2. Tampilkan Daftar SBN");
//        table.addRow("3. Kembali");
//
//        table.render();
//    }
//
//    public static void displayHeader(String title) {
//        TableView table = new TableView();
//        table.setHeaders(title);
//        table.render();
//    }
//
//    public static void displayMessage(String message) {
//        TableView table = new TableView();
//        table.setHeaders("Informasi");
//        table.addRow(message);
//
//        table.render();
//    }
//}