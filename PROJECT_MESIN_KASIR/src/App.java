import java.util.Scanner;
class harga{
    int pilihanMakan,pilihanMinum;
     int hargaTot;
    public harga(double pilihanMakan2, double pilihanMinum2) {
    }
    public void addNumbers(double piMak,double piMin){
        this.pilihanMakan=(int)piMak;
        this.pilihanMinum=(int)piMin;
    }
    public int solve() {
        int hargaTot=this.pilihanMakan+this.pilihanMinum;
        return hargaTot;
        
    }
}
    public class App {
    public static void main(String[] args){
        double pilihanMakan,pilihanMinum;
        double[] harga={12500,10000,45000,5000};

        Scanner input = new Scanner(System.in);

        harga obj=new harga(pilihanMakan,pilihanMinum);
        int jumlahBarang,totalHarga;
        double diskonDadakan = 0.5;
        System.out.println("|===================================|");
	    System.out.println("|Selamat Datang di Resto Bunga Harum|");
	    System.out.println("|===================================|");
	    System.out.println("|berikut ini adalah list menu kami: |");
        System.out.println("|Nasi Goreng		: 12,500           |");
	    System.out.println("|Ikan Goreng		: 10,000           |");
        System.out.println("|Ayam Goreng Utuh 	: 45,000       |");
        System.out.println("|				                   |");
	    System.out.println("|Minuman: 			               |");
        System.out.println("|Teh Tawar 		    : 5,000        |");
        System.out.println("|===================================|");
        System.out.println("Selamat datang silahkan masukan makanan yang anda mau");
        String barang = input.nextLine();

        if(barang.equals("nasi goreng")){
            System.out.println(harga[0]);
            pilihanMakan = 0;
        }
        else if(barang.equals("ikan goreng")){
            System.out.println(harga[1]);
            pilihanMakan = 1;
        }
        else if(barang.equals("ayam goreng utuh")){
            System.out.println(harga[2]);
            pilihanMakan = 2;
        }
        else{
            System.out.println("Maaf, kami tidak menjual barang itu");
        }
        System.out.println("silahkan masukan minuman yang anda mau");
        String minuman = input.nextLine();
        if (minuman.equals("teh tawar")){
        System.out.println(harga[3]);
        pilihanMinum = 3;
        }
        System.out.println("total"+ obj.solve());
        input.close();
    }
}
