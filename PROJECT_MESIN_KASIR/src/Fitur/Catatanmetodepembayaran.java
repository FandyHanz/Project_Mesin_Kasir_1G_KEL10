package Fitur;
import java.util.Scanner;
class Catatanmetodepembayaran {
    public static void main(String[] args){
    Scanner input12=new Scanner(System.in);
    Scanner input12Bar=new Scanner(System.in);
    Scanner input12Harga=new Scanner(System.in);
    Scanner input12Method=new Scanner(System.in);
    String makanan,minuman,Method,perubahan;
    int hargaMakanan,hargaMinuman,jumlahMak,jumlahMin,totalbarang,hargatotal,counter;
    counter=0;
    System.out.println("Masukan nama Makanan: ");
    makanan=input12.nextLine();
    System.out.println("Masukan jumlah makanan: ");
    jumlahMak=input12Bar.nextInt();
    System.out.println("Masukan Harga: ");
    hargaMakanan=input12Harga.nextInt();
    System.out.println("Masukan nama Minuman: ");
    minuman=input12.nextLine();
    System.out.println("Masukan Jumlah Minuman: ");
    jumlahMin=input12Bar.nextInt();
    System.out.println("Masukan Harga: ");
    hargaMinuman=input12Harga.nextInt();
    System.out.println("apakah, dan anda ingin melakukan perubahan pesanan (y/n) :");
    perubahan=input12.nextLine();
    do{
        if(perubahan.equalsIgnoreCase("y")){
        System.out.println("Masukan nama Makanan: ");
    makanan=input12.nextLine();
    System.out.println("Masukan jumlah makanan: ");
    jumlahMak=input12Bar.nextInt();
    System.out.println("Masukan Harga: ");
    hargaMakanan=input12Harga.nextInt();
    System.out.println("Masukan nama Minuman: ");
    minuman=input12.nextLine();
    System.out.println("Masukan Jumlah Minuman: ");
    jumlahMin=input12Bar.nextInt();
    System.out.println("Masukan Harga: ");
    hargaMinuman=input12Harga.nextInt();
        }else{
            continue;
        }
    counter+=1;
    counter++;
    }while(perubahan.equalsIgnoreCase("y")&&counter++<=1);
    totalbarang=jumlahMak+jumlahMin;
    hargatotal=hargaMakanan+hargaMinuman;
    System.out.println("Pesanan anda adalah "+makanan+" dan "+minuman);
    System.out.println("Dengan quantity sebanyak "+totalbarang);
    System.out.println("Jumlah pesana anda adalah "+hargatotal);
    System.out.println("Dengan Metode apakah anda membayar(cash/bank): ");
    Method=input12Method.nextLine();
    switch (Method){
    case("cash"):
        System.out.println("Terimakasih,semoga hari anda menyenangkan ");
        break;
    case("bank"):
        System.out.println("Terimaksih Silahkan menuju atm terdekat");
        break;    
      }
    input12.close();
    input12Bar.close();
    input12Harga.close();
    input12Method.close();
    }
  }