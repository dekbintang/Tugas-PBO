package src.view;

import src.view.TableView;

public class AppView {

    public static void displayMainMenu() {
        TableView table = new TableView();
        table.setHeaders("No", "Menu");

        table.addRow("1", "Login");
        table.addRow("2", "Keluar");

        System.out.println("=== Program Investasi Sederhana ===");
        table.render();
    }

    public static void displayLoginFailed() {
        System.out.println("Login gagal!");
    }

    public static void displayExitMessage() {
        System.out.println("Terima kasih telah menggunakan aplikasi.");
    }

    public static void displayInvalidChoice() {
        System.out.println("Pilihan tidak valid.");
    }
}