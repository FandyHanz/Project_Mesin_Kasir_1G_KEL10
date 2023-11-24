import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class App {

    // 4 Scanner dikurangi menjadi 2
       public static Scanner inputStr = new Scanner(System.in);
       public static Scanner inputInt = new Scanner(System.in);
        // Tanggal hari ini di import untuk laporan penjualan setelah restoran tutup
        public static LocalDate tanggalHariIni = LocalDate.now();
        public static DateTimeFormatter formatHariIni = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        public static String hariIni = tanggalHariIni.format(formatHariIni);
        // Menambah variabel untuk total penghasilan dan jumlah pelanggan hari ini:
       public static int totalToday = 0, totalcustomer = 0;

        public static String makanan = "x", minuman = "x", perubahan;
        public static int hargaMakanan = 0, hargaMinuman = 0, jumlahMak, jumlahMin, totalbarang = 0, hargatotal = 0, Method;
        public static int pilihMak, pilihMin;
        public static boolean pesananConfirm = false;

        // Diganti ke Array 2D!
        public static String[][] menuRes = {
                { "Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak" },
                { "Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam" }
        };
        public static int[][] price = {
                { 12000, 13500, 15000, 11000, 15000 },
                { 3500, 3500, 7500, 7500, 5000 }
        };
        public static int[][] stock = {
                { 99, 99, 99, 99, 99 },
                { 99, 99, 99, 99, 99 }
        };
        public static int i = 0;

    public static String langENGLISH(String langSelect) {
        Scanner inputL = new Scanner(System.in);
        String temp = null;
        System.out.println("==================================");
        System.out.println("English Language Selected");
        System.out.println("==================================");
        System.out.print("Are you the cashier? (y/n): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("y")) {
            System.out.println("Hello this page is english");
        } else {

        }
        inputL.close();
        return temp;
    }

    public static String langINDO(String langSelect) {
        Scanner inputL = new Scanner(System.in);
        String temp = null;
        System.out.println("==================================");
        System.out.println("Bahasa Indonesia terpilih");
        System.out.println("==================================");
        System.out.print("Apakah anda kasirnya? (y/t): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("y")) {
            kasirID(langSelect);
        } else {
            pelanggan(langSelect);
        }
        inputL.close();
        return temp;
    }

    public static void kasirID(String langSelect) {

        Scanner input = new Scanner(System.in);
        String ps, usr, adminpw, admin, akun, decision;
        int counter = 4;
        boolean dont = true;

        // Array 2D!!!
        String idA[][] = {
                { "Admin", "Fadlih", "Afrizal" },
                { "bestAdmin", "Donat", "Udahkuduga" }
        };

        // Akun admin akan ada di indeks 0
        admin = idA[0][0];
        adminpw = idA[1][0];

        // Sistem Login
        while (dont) {
            System.out.println("---{[ Login Sistem Kasir ]}---");
            System.out.print("Siapakah anda? (Staff/Pelanggan) : ");
            akun = input.nextLine();
            if (akun.equalsIgnoreCase("Staff")) {
                boolean isContinue = true;
                do {
                    // Dipindah kedalam agar bisa ada kesempatan login
                    System.out.print("Masukkan ID Pengguna: ");
                    usr = input.nextLine();
                    System.out.print("Masukkan Password: ");
                    ps = input.nextLine();

                    if ((usr.equals(idA[0][0]) && ps.equals(idA[1][0]))
                            || (usr.equals(idA[0][1]) && ps.equals(idA[1][1]))
                            || (usr.equals(idA[0][2]) && ps.equals(idA[1][2]))) {
                        if (usr.equals(admin) && ps.equals(adminpw)) {
                            System.out.println("Login sebagai Admin berhasil!");
                            System.out.println("Selamat datang kembali, administrator");
                            System.out.println("Apa yang ingin anda lakukan hari ini?");
                            System.out.println("[1] Setup diskon, [2] Restock [3] pembukuan [4] log out ");
                            decision = input.nextLine();
                            switch (decision) {
                                case "1":

                                    break;
                                case "2":

                                    break;
                                case "3":
                                    pembukuanID(i, totalcustomer, inputStr, stock, pilihMak, jumlahMak, pilihMin, jumlahMin, makanan, minuman, menuRes);
                                    
                                    break;
                                case "4":
                                    if (decision.equalsIgnoreCase("4") && akun != null) {
                                        isContinue = false;
                                        break;
                                    }
                                    break;
                            }
                            // Lanjutkan Tampilan Admin mulai dari sini...
                        } else {
                            System.out.println("Login sebagai kasir berhasil!");
                            System.out.println("Selamat datang kembali " + usr);
                            System.out.println("Apa yang ingin anda lakukan hari ini?");
                            System.out.println("[1] Input diskon, [2] Layani Pelanggan");
                            // Lanjutkan Tampilan kasir mulai dari sini...
                        }
                    } else {
                        // Counter dipindah kesini agar counter menambah hanya saat login salah
                        counter--;
                        System.out.println("[DENIED] USERNAME DAN PASSWORD SALAH!!!");
                        System.out.println("Login gagal! Mohon cek kembali username dan password anda!");
                        if (counter > 0) {
                            System.out.println("Sisa kesempatan login : " + counter);
                        } else {
                            System.out.println("Kesempatan Login Habis! Sistem akan Di-Lockdown!");
                        }
                    }
                } while (akun.equalsIgnoreCase("staff") && counter > 0 && isContinue);
            } else if (akun.equalsIgnoreCase("pelanggan")) {
                pelanggan(langSelect);
            }
        }
        input.close();
    }
    
    public static void SetupDiskon(){

    }

    public static void Restock(){

    }

    public static void pembukuanID(int i, int totalcustomer, Scanner inputStr, int[][] stock, int pilihMak,
            int jumlahMak, int pilihMin, int jumlahMin, String makanan, String minuman, String[][] menuRes) {

        stock[0][pilihMak] -= jumlahMak;
        stock[1][pilihMin] -= jumlahMin;

        System.out.println("==================================");
        System.out.println("Update Sisa Stock Makanan: ");
        System.out.println(makanan = menuRes[0][pilihMak] + " x" + stock[0][pilihMak]);
        System.out.println("Update Sisa Stock Minuman: ");
        System.out.println(minuman = menuRes[1][pilihMin] + " x" + stock[1][pilihMin]);
        System.out.println("==================================");
    }

    public static void pelanggan(String langSelect) {
        // 4 Scanner dikurangi menjadi 2
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        // Tanggal hari ini di import untuk laporan penjualan setelah restoran tutup
        LocalDate tanggalHariIni = LocalDate.now();
        DateTimeFormatter formatHariIni = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String hariIni = tanggalHariIni.format(formatHariIni);
        // Menambah variabel untuk total penghasilan dan jumlah pelanggan hari ini:
        int totalToday = 0, totalcustomer = 0;

        String makanan = "x", minuman = "x", perubahan;
        int hargaMakanan = 0, hargaMinuman = 0, jumlahMak, jumlahMin, totalbarang = 0, hargatotal = 0, Method;
        int pilihMak, pilihMin;
        boolean pesananConfirm = false;

        // Diganti ke Array 2D!
        String[][] menuRes = {
                { "Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak" },
                { "Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam" }
        };
        int[][] price = {
                { 12000, 13500, 15000, 11000, 15000 },
                { 3500, 3500, 7500, 7500, 5000 }
        };
        int[][] stock = {
                { 99, 99, 99, 99, 99 },
                { 99, 99, 99, 99, 99 }
        };

        // Semua berada di satu LOOP yang besar...
        for (int i = 1; i < 10000; i++) {
            do {
                // Tampilan Menu Makanan & Minuman
                System.out.println("=========<{[ FOOD ]}>=========");
                System.out.println("Menu makananan   | Harga      ");
                System.out.println("[0] Ayam Goreng  | Rp. 12000  ");
                System.out.println("[1] Ayam Bakar   | Rp. 13500  ");
                System.out.println("[2] Ayam Kremes  | Rp. 15000  ");
                System.out.println("[3] Nasi Goreng  | Rp. 11000  ");
                System.out.println("[4] Nasi Lemak   | Rp. 15000  ");
                System.out.println("========<{[ DRINKS ]}>========");
                System.out.println("Menu Minuman     | Harga      ");
                System.out.println("[0] Teh Hangat   | Rp. 3500   ");
                System.out.println("[1] Es Teh Manis | Rp. 3500   ");
                System.out.println("[2] Joshua       | Rp. 7500   ");
                System.out.println("[3] Soda Gembira | Rp. 7500   ");
                System.out.println("[4] Kopi Hitam   | Rp. 5000   ");

                System.out.print("Masukan ID Makanan yang dipesan (0~4): ");
                pilihMak = inputInt.nextInt();
                System.out.print("Masukan jumlah makanan yang dipesan: ");
                jumlahMak = inputInt.nextInt();
                System.out.print("Masukan ID Minuman yang dipesan (0~4): ");
                pilihMin = inputInt.nextInt();
                System.out.print("Masukan Jumlah Minuman yang dipesan: ");
                jumlahMin = inputInt.nextInt();
                System.out.println("Apakah pelanggan mengkonfirmasi pesanan (y/n)?");
                System.out.print(">>");
                perubahan = inputStr.nextLine();

                if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length) {
                    makanan = menuRes[0][pilihMak];
                    hargaMakanan = price[0][pilihMak];
                    minuman = menuRes[1][pilihMin];
                    hargaMinuman = price[1][pilihMin];
                } else {
                    System.out.println("[WARNING] ID MAKANAN TIDAK VALID!");
                    System.out.println("Mohon input kembali dengan input yang benar!");
                    continue;
                }

                if (perubahan.equalsIgnoreCase("y")) {
                    pesananConfirm = true;
                } else {
                    continue;
                }

            } while (pesananConfirm == false);

            // Proses
            totalbarang = jumlahMak + jumlahMin;
            hargaMinuman *= jumlahMin;
            hargaMakanan *= jumlahMak;
            hargatotal = hargaMakanan + hargaMinuman;
            // Total hari ini + Harga Total Pesanan Sebelumnya
            totalToday += hargatotal;
            // Mengurangi makanan & minuman
            stock[0][pilihMak] -= jumlahMak;
            stock[1][pilihMin] -= jumlahMin;
            pembukuanID(i, totalcustomer, inputStr, stock, pilihMak, jumlahMak, pilihMin, jumlahMin, makanan, minuman, menuRes);
            // Catatan Order dan Pembayaran
            System.out.println("Pesanan pelanggan ke-" + i + " adalah " + makanan + " dan " + minuman);
            System.out.println("Dengan jumlah barang sebanyak " + totalbarang);
            System.out.println("Yaitu " + makanan + " sebanyak " + jumlahMak);
            System.out.println("Dan " + minuman + " sebanyak " + jumlahMin);
            System.out.println("Jumlah pesanan pelanggan adalah " + hargatotal);
            System.out.println("Dengan Metode apakah pelanggan membayar?");
            System.out.println("[1] Cash | [2] Bank");
            System.out.print(">>");
            Method = inputInt.nextInt();
            switch (Method) {
                case 1:
                    System.out.println("Pelanggan membayar secara cash, membuka tray kasir...");
                    break;
                case 2:
                    System.out.println("Pelanggan membayar dengan bank. Instruksikan pelanggan untuk cara pembayaran");
                    break;
            }
            System.out.println("Apakah ada pelanggan yang ingin membeli lagi?");
            System.out.println("Input 'N' jika tidak ada pelanggan yang ingin membeli lagi.");
            System.out.print(">>");
            String moreCost = inputStr.nextLine();
            if (moreCost.equalsIgnoreCase("n")) {
                totalcustomer = i;
                break;
            } else {
                continue;
            }
        }

        System.out.println("==================================");
        System.out.println("Restoran sekarang tutup");
        System.out.println("==================================");
        System.out.println("Laporan penjualan pada " + hariIni);
        System.out.println("Pemasukan Hari ini: " + totalToday);
        System.out.println("dengan jumlah pelanggan: " + totalcustomer);

        inputStr.close();
        inputInt.close();
    }

    public static void main(String[] args) {

        Scanner inputL = new Scanner(System.in);
        String langSelect;

        System.out.println(" \t \t ===================================== \t \t");
        System.out.println("\t \t \t Resto Datuk Melayu \t \t \t ");
        System.out.println("\t \t Resto bintang lima, harga kaki lima \t \t");
        System.out.println(" \t \t ===================================== \t \t");
        System.out.println();
        System.out.print("Silahkan memilih bahasa | Please select a language (EN/ID): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("en")) {
            langENGLISH(langSelect);
            clearScreen();
        } else if (langSelect.equalsIgnoreCase("id")) {
            langINDO(langSelect);
            clearScreen();
        }
        inputL.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
