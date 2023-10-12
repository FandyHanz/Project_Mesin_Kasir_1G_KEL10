package Fitur;
import java.util.Scanner;
public class MultiPengguna {
    public static void main(String[] args) {
        Scanner user1 = new Scanner (System.in) ;
        Scanner password = new Scanner(System.in);
        String ps,usr,Pass1,Pass2,id1,id2;
        id1="Fadlih";
        id2="Afrizal";
        Pass1="Donat";
        Pass2="Udahkuduga";
        System.out.println("Masukkan ID Pengguna: ");
        usr=user1.nextLine();
        System.out.println("Masukkan Password");
        ps=password.nextLine();
        if (usr.equals(id1)) {
            System.out.println("halo "+id1);
        }
        else if (usr.equals(id2)){
            System.out.println("halo "+id2);
        }
        if (password.equals(Pass1)){
            System.out.println("Login berhasil");
        }
        else if (password.equals(Pass2)){
            System.out.println("Login berhasil");
            password.close();
            user1.close();
        }
    }
}
