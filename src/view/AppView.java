//package src.view;
//
//import src.view.TableView;
//
//public class AppView {
//
//    public static void displayMainMenu() {
//        TableView table = new TableView();
//        table.setHeaders("Program Investasi Sederhana");
//
//        table.addRow("1. Login");
//        table.addRow("2. Keluar");
//
//        table.render();
//    }
//
//    public static void displayLoginForm() {
//        TableView table = new TableView();
//        table.setHeaders("Form Login");
//
//        table.render();
//    }
//
//    public static void displayLoginFailed() {
//        TableView table = new TableView();
//        table.setHeaders("Informasi");
//        table.addRow("Login gagal! Silakan coba lagi.");
//
//        table.render();
//    }
//
//    public static void displayExitMessage() {
//        TableView table = new TableView();
//        table.setHeaders("Informasi");
//        table.addRow("Terima kasih telah menggunakan aplikasi.");
//
//        table.render();
//    }
//
//    public static void displayInvalidChoice() {
//        TableView table = new TableView();
//        table.setHeaders("Informasi");
//        table.addRow("Pilihan tidak valid.");
//
//        table.render();
//    }
//}