package controller;

import src.model.Customer;
import src.model.InvestmentStock;
import src.model.GovernmentBondProduct;
import src.service.InvestmentStockService;
import src.service.GovernmentBondService;

public class ControllerInvestasi {

    private InvestmentStockService stockService;
    private GovernmentBondService bondService;

    public ControllerInvestasi() {
        this.stockService = new InvestmentStockService();
        this.bondService = new GovernmentBondService();
    }

    // Metode untuk menampilkan produk saham yang tersedia
    public void tampilkanStocks() {
        stockService.displayStocks(InMemoryDatabase.stocks);
    }

    // Metode untuk menampilkan produk obligasi yang tersedia
    public void tampilkanBonds() {
        bondService.displayBonds(InMemoryDatabase.bonds);
    }

    // Metode untuk membeli saham
    public void beliStock(CustomerUser customer, String stockName) {
        for (InvestmentStock stock : InMemoryDatabase.stocks) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                // Pembelian saham
                customer.getPortfolio().getStocks().add(stock);
                System.out.println("Berhasil membeli saham " + stock.getName());
                return;
            }
        }
        System.out.println("Saham dengan nama " + stockName + " tidak ditemukan.");
    }

    // Metode untuk menjual saham
    public void jualStock(CustomerUser customer, String stockName) {
        for (InvestmentStock stock : customer.getPortfolio().getStocks()) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                // Penjualan saham
                customer.getPortfolio().getStocks().remove(stock);
                System.out.println("Berhasil menjual saham " + stock.getName());
                return;
            }
        }
        System.out.println("Saham dengan nama " + stockName + " tidak ada di portofolio.");
    }

    // Metode untuk membeli obligasi
    public void beliBond(CustomerUser customer, String bondName) {
        for (GovernmentBondProduct bond : InMemoryDatabase.bonds) {
            if (bond.getName().equalsIgnoreCase(bondName)) {
                // Pembelian obligasi
                customer.getPortfolio().getBonds().add(bond);
                System.out.println("Berhasil membeli obligasi " + bond.getName());
                return;
            }
        }
        System.out.println("Obligasi dengan nama " + bondName + " tidak ditemukan.");
    }

    // Menampilkan portofolio investasi pelanggan
    public void tampilkanPortofolio(CustomerUser customer) {
        System.out.println("Portofolio Investasi " + customer.getUsername() + ":");
        System.out.println("Saham yang dimiliki:");
        if (customer.getPortfolio().getStocks().isEmpty()) {
            System.out.println("Tidak ada saham dalam portofolio.");
        } else {
            for (InvestmentStock stock : customer.getPortfolio().getStocks()) {
                System.out.println("- " + stock.getName() + ", Harga: " + stock.getPrice());
            }
        }

        System.out.println("Obligasi yang dimiliki:");
        if (customer.getPortfolio().getBonds().isEmpty()) {
            System.out.println("Tidak ada obligasi dalam portofolio.");
        } else {
            for (GovernmentBondProduct bond : customer.getPortfolio().getBonds()) {
                System.out.println("- " + bond.getName() + ", Bunga: " + bond.getInterestRate() + "%");
            }
        }
    }
}
