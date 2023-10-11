package Fitur;

public class Mendeteksidiskon {
    static void detectPromo(int harga){
        if (harga >= 75000){
            System.out.println("Selamat, anda mendapatkan diskon sebesar 5%!");
        } else {
            System.out.println("Sayang sekali, anda tidak mendapatkan diskon.");
        }
    }
}
