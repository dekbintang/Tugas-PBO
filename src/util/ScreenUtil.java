package util;

public class ScreenUtil {
    public static void clearScreen() {
        // ANSI escape code untuk clear screen dan mengatur kursor ke kiri atas
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}