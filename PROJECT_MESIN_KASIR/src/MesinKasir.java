import java.util.Scanner;
public class MesinKasir {
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        Scanner user1 = new Scanner(System.in);

        String makanan,minuman,revisi;
        int hargaMakan,hargaMinum,total;     
        double diskon = 0.05;
        System.out.println("=========================");
        System.out.println("List makanan dan minuman:");
        System.out.println("1. Nasi goreng      45.000");
        System.out.println("2. Bakmie goreng    35.000");
        System.out.println("3. Soto             20.000");
        System.out.println("Minuman:                   ");
        System.out.println("1. Soda Gembira     10.000");
        System.out.println("=========================");
        System.out.println("\n");
        System.out.println("Mau pesan apa makanan:  ");
        makanan = user1.nextLine();
        System.out.println("harga: ");
        hargaMakan = user.nextInt();
        System.out.println("Masukan Minuman: ");
        minuman = user1.nextLine();
        System.out.println("harga: ");
        hargaMinum = user.nextInt();
        System.out.println("Apakah ada catatan opsional/revisi: ");
        revisi = user1.nextLine();
        total = hargaMakan+hargaMinum;
        System.out.println("Total makanan anda adalah: "+makanan+" dan "+ minuman + " dengan harga Rp." + total);
        System.out.println("Dengan catatan opsional: " + revisi);
        user.close();
        }
    }