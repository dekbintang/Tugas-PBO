package src.user;

import src.model.Portfolio;
import src.controller.CustomerController;

public class Customer extends BaseUser {
    private Portfolio portfolio;

    public Customer(String username, String password) {
        super(username, password);
        this.portfolio = new Portfolio();  // Portfolio default kosong
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    @Override
    public void displayMenu() {
        CustomerController.menu(this);
    }
}

