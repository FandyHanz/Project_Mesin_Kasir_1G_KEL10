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
            {"Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak"},
            {"Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam"}
        };
        int[][] price = {
            {12000, 13500, 15000, 11000, 15000},
            {3500, 3500, 7500, 7500, 5000}
        };
        int[][] stock ={
            {99, 99, 99, 99, 99},
            {99, 99, 99, 99, 99}
        };

        //Semua berada di satu LOOP yang besar...
        for (int i = 1 ; i < 10000 ; i++) {
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
            makanan = menuRes[0][pilihMak];
            hargaMakanan = price[0][pilihMak];
            minuman = menuRes[1][pilihMin];
            hargaMinuman = price[1][pilihMin];
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