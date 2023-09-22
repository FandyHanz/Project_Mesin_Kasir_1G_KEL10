import java.util.Scanner;
public class MesinKasir {
    public static void main(String[] args){
        int[] harga = {12000,11000,10000,5000};
        Scanner user = new Scanner(System.in); 
        String masukanMakanan ,masukanMinuman;
        int makanan,minuman;
        double diskon = 0.05;
        System.out.println("========================= \n");
        System.out.println("List makanan dan minuman: \n");
        System.out.println(" . Nasi goreng \n");
        System.out.println("2. Bakmie goreng \n");
        System.out.println("3. Soto         \n");
        System.out.println("Minuman:        \n");
        System.out.println("1. Soda Gembira \n");
        System.out.println("========================= \n");
        System.out.println("\n");
        System.out.println("Mau pesan apa: ");
        masukanMakanan =user.nextLine();
        if(masukanMakanan.equals("nasi goreng")){

        }
    }
}