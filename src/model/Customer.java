package src.model;

import java.util.Scanner;

public  class Customer extends User {

    private ControllerInvestasi controller;

    public Customer(String username, String password, ControllerInvestasi controller) {
        super(username, password);
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Customer:");
            System.out.println("1. Pembelian Saham");
            System.out.println("2. Penjualan Saham");
            System.out.println("3. Pembelian SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Lihat Portofolio");
            System.out.println("6. Keluar");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.beliSaham();
                    break;
                case 2:
                    controller.jualSaham();
                    break;
                case 3:
                    controller.beliSBN();
                    break;
                case 4:
                    controller.simulasiSBN();
                    break;
                case 5:
                    controller.lihatPortofolio();
                    break;
                case 6:
                    System.out.println("Keluar dari menu Customer.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
