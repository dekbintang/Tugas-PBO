package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import src.util.ScreenUtil;
import src.view.TableView;

import java.util.Scanner;

public class AuthController {
    private final Scanner scanner = new Scanner(System.in);

    // Simpan user supaya tidak reset
    private final Admin admin = new Admin("admin", "111");
    private final Customer customer = new Customer("customer", "222");

    public BaseUser login() {
        ScreenUtil.clearScreen();
        TableView.displayLogin();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Pencocokan username dan password
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            TableView.displayLoginSuccess(username);
            pause();
            return admin; // <-- Return admin YANG SAMA
        } else if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
            TableView.displayLoginSuccess(username);
            pause();
            return customer; // <-- Return customer YANG SAMA
        } else {
            TableView.displayLoginFailed();
            pause();
            return null;
        }
    }

    private void pause() {
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}
