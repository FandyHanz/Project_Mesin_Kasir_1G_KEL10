package Fitur;

import java.util.Scanner;

public class inputanUsermenus {
    static Scanner input = new Scanner(System.in);
    static int row, column;
    static String[][] menuRes = {
            { "Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak" },
            { "Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam" } };
    public static int[][] price = {
            { 12000, 13500, 15000, 11000, 15000 },
            { 3500, 3500, 7500, 7500, 5000 } };

    static String[][] pelanggan = new String[row][column];

    public static void main(String[] args) {
        System.out.println("pesan untuk berapa orang: ");
        row = input.nextInt();
        System.out.println("Berapa porsi masing masing: ");
        column = input.nextInt();

        for (int i = 0; i <= menuRes.length; i++) {
            if (i == 0) {
                System.out.println("=========<{[ FOOD ]}>=========");
            } else if (i == 1) {
                System.out.println("========<{[ DRINKS ]}>========");
            }
            for (int j2 = 0; j2 < menuRes[i].length; j2++) {
                System.out.println("[ ID:" + j2 + " ] " + menuRes[i][j2]);
                System.out.println("Harga : " + price[i][j2]);
            }
        }
    }
}
