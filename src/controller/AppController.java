package src.controller;

import src.user.BaseUser;
import src.user.Admin;
import src.user.Customer;
import src.util.InputUtil;
import src.util.ScreenUtil;
import src.view.AppView;

public class AppController {
    public static void run() {
        AuthController auth = new AuthController();

        while (true) {
            ScreenUtil.clearScreen();
            AppView.displayMainMenu();
            int pilih = InputUtil.inputInt("Pilih: ");

            switch (pilih) {
                case 1:
                    BaseUser user = auth.login();
                    if (user == null) {
                        AppView.displayLoginFailed();
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
                    AppView.displayExitMessage();
                    return;
                default:
                    AppView.displayInvalidChoice();
                    InputUtil.waitEnter();
            }
        }
    }
}
