import java.util.Scanner;
public class App {
    public static void main(String[] args){
        double harga []={12500,10000,45000,5000};
        Scanner input = new Scanner(System.in);

        String barang,minuman,ayam_goreng,ikan_goreng,nasi_goreng,teh_tawar;
        int jumlahBarang,totalHarga;
        double diskonDadakan = 0.5,hargaFinal;
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
        barang = input.nextLine();
        System.out.println("silahkan masukan minuman yang anda mau");
        minuman = input.nextLine();
        if (minuman=="teh_tawar"){
            System.out.println(harga[3]);
        }
        input.close();
    }
}

