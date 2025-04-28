package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.view.TableView;

public class AppController {
    public static void run() {
        AuthController auth = new AuthController();

        while (true) {
            ScreenUtil.clearScreen();
            TableView.displayMainMenu();
            int pilih = InputUtil.inputInt("Pilih: ");

            switch (pilih) {
                case 1:
                    BaseUser user = auth.login();
                    if (user == null) {
                        TableView.displayLoginFailed();
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
                    TableView.displayExitMessage();
                    return;
                default:
                    TableView.displayInvalidChoice();
                    InputUtil.waitEnter();
            }
        }
    }
}