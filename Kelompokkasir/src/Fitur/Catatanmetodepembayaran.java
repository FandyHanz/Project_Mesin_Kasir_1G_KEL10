package Fitur;

import java.util.Scanner;

class Catatanmetodepembayaran {

    public static void main(String[] args) {
        //4 Scanner dikurangi menjadi 2
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        String makanan, minuman, perubahan;
        int hargaMakanan, hargaMinuman, jumlahMak, jumlahMin, totalbarang, hargatotal, Method;
        int counter = 0;

        //Program Kasir
        System.out.print("Masukan nama Makanan: ");
        makanan = inputStr.nextLine();
        System.out.print("Masukan jumlah makanan: ");
        jumlahMak = inputInt.nextInt();
        System.out.print("Masukan Harga: ");
        hargaMakanan = inputInt.nextInt();
        System.out.print("Masukan nama Minuman: ");
        minuman = inputStr.nextLine();
        System.out.print("Masukan Jumlah Minuman: ");
        jumlahMin = inputInt.nextInt();
        System.out.print("Masukan Harga: ");
        hargaMinuman = inputInt.nextInt();
        System.out.println("Apakah anda ingin melakukan perubahan pesanan (y/n)?");
        System.out.print(">>");
        perubahan = inputStr.nextLine();
        do {
            if (perubahan.equalsIgnoreCase("y")) {
                System.out.print("Masukan nama Makanan: ");
                makanan = inputStr.nextLine();
                System.out.print("Masukan jumlah makanan: ");
                jumlahMak = inputInt.nextInt();
                System.out.print("Masukan Harga: ");
                hargaMakanan = inputInt.nextInt();
                System.out.print("Masukan nama Minuman: ");
                minuman = inputStr.nextLine();
                System.out.print("Masukan Jumlah Minuman: ");
                jumlahMin = inputInt.nextInt();
                System.out.print("Masukan Harga: ");
                hargaMinuman = inputInt.nextInt();
            } else {
                continue;
            }
            counter += 1;
            counter++;
        } while (perubahan.equalsIgnoreCase("y") && counter++ <= 1);

        //Proses
        totalbarang = jumlahMak + jumlahMin;
        hargaMinuman *= jumlahMin;
        hargaMakanan *= jumlahMak;
        hargatotal = hargaMakanan + hargaMinuman;

        //Catatan Order dan Pembayaran
        System.out.println("Pesanan anda adalah " + makanan + " dan " + minuman);
        System.out.println("Dengan jumlah sebanyak " + totalbarang);
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
