package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import src.util.ScreenUtil;
import src.view.TableView;

import java.util.Scanner;

public class AuthController {
    private final Scanner scanner = new Scanner(System.in);

    public BaseUser login() {
        ScreenUtil.clearScreen();
        TableView.displayLogin();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Dummy authentication logic
        if (username.equals("admin") && password.equals("111")) {
            TableView.displayLoginSuccess( username);
            pause();
            return new Admin(username, password);  // Mengembalikan objek Admin
        } else if (username.equals("customer") && password.equals("222")) {
            TableView.displayLoginSuccess( username);
            pause();
            return new Customer(username, password);  // Mengembalikan objek Customer
        } else {
            TableView.displayLoginFailed();
            pause();
            return null;  // Login gagal
        }
    }

    private void pause() {
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}
