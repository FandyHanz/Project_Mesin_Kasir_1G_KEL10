package Fitur;

import java.util.Scanner;

public class MultiPengguna {

    public static void main(String[] args) {
        Scanner user1 = new Scanner(System.in);
        Scanner password = new Scanner(System.in);
        Scanner akun = new Scanner(System.in);
        String ps, usr, Pass1, Pass2, adminpw, id1, id2, admin, akun1;
        int counter;
        counter = 0;
        akun1 = "Pemilik";
        akun1 = "pelanggan";
        id1 = "Fadlih";
        id2 = "Afrizal";
        admin = "Admin";
        Pass1 = "Donat";
        Pass2 = "Udahkuduga";
        adminpw = "bestAdmin";
        usr = id1;
        usr = id2;
        usr = admin;
        ps = Pass1;
        ps = Pass2;
        ps = adminpw;
        System.out.println("anda siapa: ");
        akun1 = akun.nextLine();
        if (akun1.equalsIgnoreCase("pemilik")) {
            System.out.print("Masukkan ID Pengguna: ");
            usr = user1.nextLine();
            System.out.print("Masukkan Password: ");
            ps = password.nextLine();
            do {
            if ((usr.equals(id1) && ps.equals(Pass1)) || (usr.equals(id2) && ps.equals(Pass2)) || (usr.equals(admin) && ps.equals(adminpw))) {
                if (usr.equals(admin) && ps.equals(adminpw)) {
                    System.out.println("Login sebagai Admin berhasil!");
                    System.out.println("Selamat datang kembali, administrator");
                    System.out.println("Apa yang ingin anda lakukan hari ini?");
                    System.out.println("[1] Setup diskon, [2] Restock");
                    //Lanjutkan Tampilan Admin
                } else {
                    System.out.println("Login sebagai kasir berhasil!");
                    System.out.println("Selamat datang kembali " + usr);
                    System.out.println("Apa yang ingin anda lakukan hari ini?");
                    System.out.println("[1] Input diskon, [2] Layani Pelanggan");
                    //Lanjutkan Tampilan kasir
                }
            } else {
                System.out.println("DENIED! USERNAME DAN PASSWORD SALAH");
                System.out.println("Login gagal! Mohon cek kembali username dan password");
            }
            counter += 1;
            counter++;
        } while (akun1.equalsIgnoreCase("pemilik") && counter++ <= 1);
        } else if (akun1.equalsIgnoreCase("pelanggan")) {
            System.out.println("coming soon");
        }
        

        user1.close();
        password.close();
        akun.close();
    }
}