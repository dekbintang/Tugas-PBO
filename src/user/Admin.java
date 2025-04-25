package src.user;

import src.controller.AdminController;

public class Admin extends BaseUser {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayMenu() {
        AdminController.menu();
    }
}

