package src.controller;

import java.util.Scanner;
import util.ScreenUtil;


public class MenuManager {
    private Scanner scanner = new Scanner(System.in);
    private AuthController authController = new AuthController();
    private AdminController adminController = new AdminController();
    private CustomerController customerController = new CustomerController();

    public void showMainMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Awal ===");
            System.out.println("1. Login");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1") && authController.login()) {
                if (authController.isAdmin()) {
                    showAdminMenu();
                } else {
                    showCustomerMenu();
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void showAdminMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": showAdminSahamMenu(); break;
                case "2": showAdminSBNMenu(); break;
                case "3": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void showAdminSahamMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Admin > Saham ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": adminController.tambahSaham(); break;
                case "2": adminController.ubahHargaSaham(); break;
                case "3": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public void tampilkanMenuAwal() {
        showMainMenu();
    }

    private void showAdminSBNMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Admin > SBN ===");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": adminController.tambahSBN(); break;
                case "2": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void showCustomerMenu() {
        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Menu Customer ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": customerController.beliSaham(); break;
                case "2": customerController.jualSaham(); break;
                case "3": customerController.beliSBN(); break;
                case "4": customerController.simulasiSBN(); break;
                case "5": customerController.tampilkanPortofolio(); break;
                case "6": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
