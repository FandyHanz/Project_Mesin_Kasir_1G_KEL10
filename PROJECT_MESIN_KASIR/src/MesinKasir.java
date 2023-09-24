import java.util.Scanner;
public class MesinKasir {
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        Scanner user1 = new Scanner(System.in);

        String makanan,minuman,revisi;
        int hargaMakan,hargaMinum, total, bayar;   
        double diskon = 0.05, hargaDis, hargaFin, kembalian;  
        System.out.println("=========================");
        System.out.println("List makanan dan minuman:");
        System.out.println("1. Nasi goreng      45.000");
        System.out.println("2. Bakmie goreng    35.000");
        System.out.println("3. Soto             20.000");
        System.out.println("Minuman:                   ");
        System.out.println("1. Soda Gembira     10.000");
        System.out.println("=========================");
        System.out.println("Mau pesan makanan apa : ");
        makanan = user1.nextLine();
        System.out.println("Harga: ");
        hargaMakan = user.nextInt();
        System.out.println("Masukan Minuman: ");
        minuman = user1.nextLine();
        System.out.println("Harga: ");
        hargaMinum = user.nextInt();
        System.out.println("Apakah ada catatan opsional/revisi: ");
        revisi = user1.nextLine();
        total = hargaMakan+hargaMinum;
        hargaDis = total * diskon;
        hargaFin = total - hargaDis;
        System.out.println("Total makanan anda adalah: "+makanan+" dan "+ minuman + " dengan harga Rp." + total);
        System.out.println("Dengan catatan opsional: " + revisi);
        System.out.println("Dengan potongan harga sejumlah " + hargaDis);
        System.out.println("Maka yang harus dibayar adalah sebesar " + hargaFin);
        System.out.println("Masukkan Nominal Pembayaran");
        bayar = user.nextInt();
        kembalian = bayar - hargaFin;
        System.out.println("Kembalian anda adalah: " + kembalian );

        user.close();
        user1.close();
        }
    }