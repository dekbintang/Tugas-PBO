package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import java.util.Scanner;

public class AuthController {
    private final Scanner scanner = new Scanner(System.in);

    public BaseUser login() {
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Dummy authentication logic
        if (username.equals("admin") && password.equals("111")) {
            System.out.println("Login sebagai Admin berhasil.");
            pause();
            return new Admin(username, password);  // Mengembalikan objek Admin
        } else if (username.equals("customer") && password.equals("222")) {
            System.out.println("Login sebagai Customer berhasil.");
            pause();
            return new Customer(username, password);  // Mengembalikan objek Customer
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            pause();
            return null;  // Login gagal
        }
    }

    private void pause() {
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}
