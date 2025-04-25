package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import src.util.InputUtil;
import src.util.ScreenUtil;

public class AppController {
    public static void run() {
        AuthController auth = new AuthController();

        while (true) {
            ScreenUtil.clearScreen();
            System.out.println("=== Program Investasi Sederhana ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            int pilih = InputUtil.inputInt("Pilih: ");

            switch (pilih) {
                case 1:
                    BaseUser user = auth.login();
                    if (user == null) {
                        System.out.println("Login gagal!");
                        InputUtil.waitEnter();
                        break;
                    }
                    if (user instanceof Admin) {
                        AdminController.menu();
                    } else if (user instanceof Customer) {
                        CustomerController.menu((Customer) user);
                    }
                    break;
                case 2:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    InputUtil.waitEnter();
            }
        }
    }
}
