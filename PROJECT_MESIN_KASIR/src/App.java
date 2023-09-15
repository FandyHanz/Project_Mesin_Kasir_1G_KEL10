import java.util.Scanner;
public class App {
    public static void main(String[] args){
        int jumlahBarang, harga, totalHarga;
        int hargaMenu [] []={25_000,30_000,35_000},{5000};
        double diskonDadakan = 0.5, hargaFinal;
        Scanner user = new Scanner(System.in);
        System.out.println("|===================================|");
	    System.out.println("|Selamat Datang di Resto Bunga Harum|");
	    System.out.println("|===================================|");
	    System.out.println("|berikut ini adalah list menu kami: |");
        System.out.println("|Nasi Goreng		: 12,500          |");
	    System.out.println("|Ikan Goreng		: 10,000          |");
        System.out.println("|Ayam Goreng Utuh 	: 45,000      |");
        System.out.println("|				                      |");
	    System.out.println("|Minuman: 			              |");
        System.out.println("|Teh Tawar 		    : 5,000       |");
        System.out.println("|===================================|");
        System.out.println("Selamat datang silahkan masukan makanan yang anda mau");
        
    }
}

