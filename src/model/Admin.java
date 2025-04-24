package src.model;

import java.util.Scanner;

public class Admin extends User {

    private ControllerInvestasi controller;

    public Admin(String username, String password, ControllerInvestasi controller) {
        super(username, password);
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Tambah Produk SBN");
            System.out.println("4. Keluar");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.tambahSaham();
                    break;
                case 2:
                    controller.ubahHargaSaham();
                    break;
                case 3:
                    controller.tambahProdukSBN();
                    break;
                case 4:
                    System.out.println("Keluar dari menu Admin.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
