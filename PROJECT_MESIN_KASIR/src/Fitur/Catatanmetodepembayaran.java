package Fitur;

import java.util.Scanner;

class Catatanmetodepembayaran {

    public static void main(String[] args) {
        //4 Scanner dikurangi menjadi 2
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        String makanan= "x", minuman="x", perubahan;
        int hargaMakanan=0, hargaMinuman=0, jumlahMak, jumlahMin, totalbarang, hargatotal, Method;
        int pilihMak, pilihMin;
        boolean pesananConfirm = false;

        //Deklarasi Array
        String[] food = {"Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak"};
        int[] fPrice = {12000, 13500, 15000, 11000, 15000};
        String[] drinks = {"Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam"};
        int[] dPrice = {3500, 3500, 7500, 7500, 5000};

        //Meminta input pengguna
        do {

            //Tampilan Menu Makanan & Minuman
            System.out.println("=========<{[ FOOD ]}>=========");
            System.out.println("Menu makananan   | Harga      ");
            System.out.println("[0] Ayam Goreng  | Rp. 12000  ");
            System.out.println("[1] Ayam Bakar   | Rp. 13500  ");
            System.out.println("[2] Ayam Kremes  | Rp. 15000  ");
            System.out.println("[3] Nasi Goreng  | Rp. 11000  ");
            System.out.println("[4] Nasi Lemak   | Rp. 15000  ");
            System.out.println("========<{[ DRINKS ]}>========");
            System.out.println("Menu Minuman     | Harga      ");
            System.out.println("[0] Teh Hangat   | Rp. 3500   ");
            System.out.println("[1] Es Teh Manis | Rp. 3500   ");
            System.out.println("[2] Joshua       | Rp. 7500   ");
            System.out.println("[3] Soda Gembira | Rp. 7500   ");
            System.out.println("[4] Kopi Hitam   | Rp. 5000   ");

            System.out.print("Masukan ID Makanan (0~4): ");
            pilihMak = inputInt.nextInt();
            System.out.print("Masukan jumlah makanan: ");
            jumlahMak = inputInt.nextInt();
            System.out.print("Masukan ID Minuman (0~4): ");
            pilihMin = inputInt.nextInt();
            System.out.print("Masukan Jumlah Minuman: ");
            jumlahMin = inputInt.nextInt();
            System.out.println("Apakah anda ingin mengkonfirmasi pesanan (y/n)?");
            System.out.print(">>");
            perubahan = inputStr.nextLine();

            if (pilihMak < food.length && pilihMin < drinks.length){
            makanan = food[pilihMak];
            hargaMakanan = fPrice[pilihMak];
            minuman = drinks[pilihMin];
            hargaMinuman = dPrice[pilihMin];
            } else {
                System.out.println("[WARNING] ID MAKANAN TIDAK VALID!");
                System.out.println("Mohon input kembali dengan input yang benar!");
                continue;
            }
            
            if(perubahan.equalsIgnoreCase("y")){
                pesananConfirm = true;
            } else {
                continue;
            }

        } while (pesananConfirm == false);

        //Proses
        totalbarang = jumlahMak + jumlahMin;
        hargaMinuman *= jumlahMin;
        hargaMakanan *= jumlahMak;
        hargatotal = hargaMakanan + hargaMinuman;

        //Catatan Order dan Pembayaran
        System.out.println("Pesanan anda adalah " + makanan + " dan " + minuman);
        System.out.println("Dengan jumlah barang sebanyak " + totalbarang);
        System.out.println("Yaitu " + makanan + " sebanyak " + jumlahMak);
        System.out.println("Dan " + minuman + " sebanyak " + jumlahMin);
        System.out.println("Jumlah pesanan anda adalah " + hargatotal);
        System.out.println("Dengan Metode apakah anda membayar?");
        System.out.println("[1] Cash | [2] Bank");
        System.out.print(">>");
        Method = inputInt.nextInt();
        switch (Method) {
            case 1:
                System.out.println("Terimakasih. Semoga hari anda menyenangkan!");
                break;
            case 2:
                System.out.println("Terimakasih. Silahkan menuju atm terdekat");
                break;
        }
        inputStr.close();
        inputInt.close();
    }
}
