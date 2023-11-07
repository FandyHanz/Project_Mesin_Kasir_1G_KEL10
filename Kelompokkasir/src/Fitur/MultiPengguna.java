package Fitur;
import java.util.Scanner;

public class MultiPengguna {

    public static void main(String[] args) {
        //Cleaning Code, Scanner dikurangi dari 3 ke 1.
        Scanner input = new Scanner(System.in);
        String ps, usr, adminpw, admin, akun;
        int counter = 4;

        //Variabel diganti ke Array
        String id[] = {"Admin", "Fadlih", "Afrizal"};
        String pass[] = {"bestAdmin", "Donat", "Udahkuduga"};

        //Akun admin akan ada di indeks 0
        admin = id[0];
        adminpw = pass[0];

        //Sistem Login
        System.out.println("---{[ Login Sistem Kasir ]}---");
        System.out.print("Siapakah anda? (Staff/Pelanggan) : ");
        akun = input.nextLine();
        if (akun.equalsIgnoreCase("Staff")) {
            do {

            //Dipindah kedalam agar bisa ada kesempatan login
            System.out.print("Masukkan ID Pengguna: ");
            usr = input.nextLine();
            System.out.print("Masukkan Password: ");
            ps = input.nextLine();

            if ((usr.equals(id[0]) && ps.equals(pass[0])) || (usr.equals(id[1]) && ps.equals(pass[1])) || (usr.equals(id[2]) && ps.equals(pass[2]))) {
                if (usr.equals(admin) && ps.equals(adminpw)) {
                    System.out.println("Login sebagai Admin berhasil!");
                    System.out.println("Selamat datang kembali, administrator");
                    System.out.println("Apa yang ingin anda lakukan hari ini?");
                    System.out.println("[1] Setup diskon, [2] Restock");
                    //Lanjutkan Tampilan Admin mulai dari sini...
                } else {
                    System.out.println("Login sebagai kasir berhasil!");
                    System.out.println("Selamat datang kembali " + usr);
                    System.out.println("Apa yang ingin anda lakukan hari ini?");
                    System.out.println("[1] Input diskon, [2] Layani Pelanggan");
                    //Lanjutkan Tampilan kasir mulai dari sini...
                }
            } else {
                //Counter dipindah kesini agar counter menambah hanya saat login salah
                counter--;
                System.out.println("[DENIED] USERNAME DAN PASSWORD SALAH!!!");
                System.out.println("Login gagal! Mohon cek kembali username dan password anda!");
                if (counter > 0){
                    System.out.println("Sisa kesempatan login : " +  counter);
                } else {
                    System.out.println("Kesempatan Login Habis! Sistem akan Di-Lockdown!");
                }
            }
        } while (akun.equalsIgnoreCase("staff") && counter > 0);
        } else if (akun.equalsIgnoreCase("pelanggan")) {
            System.out.println("Coming soon...");
        } 
        input.close();
    }
}
