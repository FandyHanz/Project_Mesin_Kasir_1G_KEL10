package Fitur;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TampilanKasir {

    public static void main(String[] args) {
        //4 Scanner dikurangi menjadi 2
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        //Tanggal hari ini di import untuk laporan penjualan setelah restoran tutup
        LocalDate tanggalHariIni = LocalDate.now();
        DateTimeFormatter formatHariIni = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String hariIni = tanggalHariIni.format(formatHariIni);
        //Menambah variabel untuk total penghasilan dan jumlah pelanggan hari ini:
        int totalToday = 0, totalcustomer = 0;

        String makanan= "x", minuman="x", perubahan;
        int hargaMakanan=0, hargaMinuman=0, jumlahMak, jumlahMin, totalbarang, hargatotal, Method;
        int pilihMak, pilihMin;
        boolean pesananConfirm = false;

        //Diganti ke Array 2D!
        String[][] menuRes = {
            //menuRes[0], untuk makanan
            {"Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak"},
            //menuRes[1], untuk minuman
            {"Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam"}
        };
        String[] namaList = {"Makanan", "Minuman"};
        int[][] price = {
            {12000, 13500, 15000, 11000, 15000},
            {3500, 3500, 7500, 7500, 5000}
        };
        int[][] stock ={
            //Placeholder di 9999.
            {9999, 9999, 9999, 9999, 9999},
            {9999, 9999, 9999, 9999, 9999}
        };

        //Semua berada di satu LOOP yang besar...
        for (int i = 1 ; i < 10000 ; i++) {
        do {
            //Tampilan Menu Makanan & Minuman
            for (int j = 0; j < namaList.length; j++) {
                if (j == 0) {
                    System.out.println("=========<{[ FOOD ]}>=========");
                } else if (j == 1) {
                    System.out.println("========<{[ DRINKS ]}>========");
                }
                for (int j2 = 0; j2 < menuRes[j].length; j2++) {
                    System.out.println("[ ID:" + j2 + " ] " + menuRes[j][j2]);
                    System.out.println("Harga : " + price[j][j2]);
                }
            }

            System.out.print("Masukan ID Makanan yang dipesan (0~4): ");
            pilihMak = inputInt.nextInt();
            System.out.print("Masukan jumlah makanan yang dipesan: ");
            jumlahMak = inputInt.nextInt();
            System.out.print("Masukan ID Minuman yang dipesan (0~4): ");
            pilihMin = inputInt.nextInt();
            System.out.print("Masukan Jumlah Minuman yang dipesan: ");
            jumlahMin = inputInt.nextInt();
            System.out.println("Apakah pelanggan mengkonfirmasi pesanan (y/n)?");
            System.out.print(">>");
            perubahan = inputStr.nextLine();

            if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length){
                //Pengecekan kalau stok kurang atau habis.
                if (jumlahMak > stock[0][pilihMak] || jumlahMin > stock[1][pilihMin]){
                    //FAILSAFE UNTUK PENCEGAHAN STOCK MINUS. MASIH ADA BUG. PLS FIX.
                    System.out.println("Pesanan pelanggan melebihi kapasitas stock yang ada!");
                    System.out.println("Makanan yang dipesan: " + menuRes[0][pilihMak] + " sejumlah " + jumlahMak);
                    System.out.println("Stock yang tersedia: " + stock[0][pilihMak]);
                    int makOverload = jumlahMak - stock[0][pilihMak];
                    System.out.println("Diperlukan " + makOverload + " " + menuRes[0][pilihMak] + " lagi untuk memenuhi pesanan tersebut!");

                    System.out.println("Minuman yang dipesan: " + menuRes[1][pilihMin]);
                    System.out.println("Makanan yang dipesan: " + menuRes[1][pilihMin] + " sejumlah " + jumlahMin);
                    System.out.println("Stock yang tersedia: " + stock[1][pilihMak]);
                    int minOverload = jumlahMak - stock[1][pilihMin];
                    System.out.println("Diperlukan " + minOverload + " " + menuRes[1][pilihMin] + " lagi untuk memenuhi pesanan tersebut!");
                    continue;
                } else {
                    makanan = menuRes[0][pilihMak];
                    hargaMakanan = price[0][pilihMak];
                    minuman = menuRes[1][pilihMin];
                    hargaMinuman = price[1][pilihMin];
                }
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
        //Total hari ini + Harga Total Pesanan Sebelumnya
        totalToday += hargatotal;
        //Mengurangi makanan & minuman
        stock[0][pilihMak] -= jumlahMak;
        stock[1][pilihMin] -= jumlahMin;

        //Catatan Order dan Pembayaran
        System.out.println("Pesanan pelanggan ke-" + i + " adalah " + makanan + " dan " + minuman);
        System.out.println("Dengan jumlah barang sebanyak " + totalbarang);
        System.out.println("Yaitu " + makanan + " sebanyak " + jumlahMak);
        System.out.println("Dan " + minuman + " sebanyak " + jumlahMin);
        System.out.println("Jumlah pesanan pelanggan adalah " + hargatotal);
        System.out.println("Dengan Metode apakah pelanggan membayar?");
        System.out.println("[1] Cash | [2] Bank");
        System.out.print(">>");
        Method = inputInt.nextInt();
        switch (Method) {
            case 1:
                System.out.println("Pelanggan membayar secara cash, membuka tray kasir...");
                break;
            case 2:
                System.out.println("Pelanggan membayar dengan bank. Instruksikan pelanggan untuk cara pembayaran");
                break;
        }
        System.out.println("==================================");
        System.out.println("Update Sisa Stock Makanan: ");
        System.out.println(makanan = menuRes[0][pilihMak] + " x" + stock[0][pilihMak]);
        System.out.println("Update Sisa Stock Minuman: ");
        System.out.println(minuman = menuRes[1][pilihMin] + " x" + stock[1][pilihMin]);
        System.out.println("==================================");

        System.out.println("Apakah ada pelanggan yang ingin membeli lagi?");
        System.out.println("Input 'N' jika tidak ada pelanggan yang ingin membeli lagi.");
        System.out.print(">>");
        String moreCost = inputStr.nextLine();
            if (moreCost.equalsIgnoreCase("n")){
                totalcustomer = i;
                break;
            } else {
                continue;
            }
        }
        System.out.println("==================================");
        System.out.println("Restoran sekarang tutup");
        System.out.println("==================================");
        System.out.println("Laporan penjualan pada " + hariIni);
        System.out.println("Pemasukan Hari ini: " + totalToday);
        System.out.println("dengan jumlah pelanggan: " + totalcustomer);

        inputStr.close();
        inputInt.close();
    }
}