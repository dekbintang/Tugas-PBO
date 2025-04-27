package src.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Input harus berupa angka. Coba lagi: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        return value;
    }

    public static double inputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Input harus berupa angka desimal. Coba lagi: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer
        return value;
    }

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void waitEnter() {
        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}