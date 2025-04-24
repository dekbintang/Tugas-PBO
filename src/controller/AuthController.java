package src.controller;

import java.util.Scanner;

public class AuthController {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isAdmin = false;

    public boolean login() {
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Dummy authentication logic
        if (username.equals("admin") && password.equals("admin123")) {
            isAdmin = true;
            System.out.println("Login sebagai Admin berhasil.");
            pause();
            return true;
        } else if (username.equals("customer") && password.equals("cust123")) {
            isAdmin = false;
            System.out.println("Login sebagai Customer berhasil.");
            pause();
            return true;
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            pause();
            return false;
        }
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    private void pause() {
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}
