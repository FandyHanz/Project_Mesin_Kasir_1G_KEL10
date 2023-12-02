import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public static int i = 0,DayOfMonth = 0;

    public static String langENGLISH() {
        Scanner inputL = new Scanner(System.in);
        String temp = null;
        String langSelect;
        System.out.println("==================================");
        System.out.println("English Language Selected");
        System.out.println("==================================");
        System.out.print("Are you the cashier? (y/n): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("y")) {
            System.out.println("Hello this page is english");
        } else {
            EnPelanggan(langSelect);
        }
        inputL.close();
        return temp;
    }

    public static String langINDO() {
        Scanner inputL = new Scanner(System.in);
        String langSelect;
        String temp = null;
        System.out.println("==================================");
        System.out.println("Bahasa Indonesia terpilih");
        System.out.println("==================================");
        System.out.print("Apakah anda kasirnya? (y/t): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("y")) {
            kasirID();
        } else {
            pelanggan();
        }
        inputL.close();
        return temp;
    }

    public static void kasirID() {

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
                                    SetupDiskon();
                                    break;
                                case "2":
                                    Restock();
                                    break;
                                case "3":
                                    pembukuanID();
                                    System.out.println("log out (y/n): ");
                                    decision = input.nextLine();
                                    if (decision.equalsIgnoreCase("y")) {
                                        isContinue = false;
                                        break;
                                    }
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
                            pelanggan();
                        }
                    }
                } while (akun.equalsIgnoreCase("staff") && counter > 0 && isContinue);
            } else if (akun.equalsIgnoreCase("pelanggan")) {
                pelanggan();
            }
        }
        input.close();
    }

    public static void SetupDiskon() {
        LocalDate today = LocalDate.now();
        DayOfMonth= today.getDayOfMonth();
        Scanner input = new Scanner(System.in);

            System.out.println("Hari ini tanggal ganjil! Masukkan diskon spesial:");

            System.out.print("Masukkan diskon untuk hari ini (misal: 10 untuk 10%): ");
            int diskon = input.nextInt();
            System.out.println("===========================================");
            System.out.println("|           Promo Hari Ini                |");
            System.out.println("===========================================");
            System.out.println("|             Diskon Spesial             |");
            System.out.println("===========================================");
            System.out.println("|    Diskon " + diskon + "% untuk hari ini!        |");
            System.out.println("===========================================");

        
        
        }


    public static void Restock() {
        Scanner input = new Scanner(System.in);
        String decision;
        System.out.println("=========================================================================");
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[0].length; j++) {
                if (stock[i][j] < 99) {
                    stock[i][j] = 99;
                    if (stock[i][j] == 99) {
                        System.out.print("| All is set up |");
                    }

                } else if (stock[i][j] == 99) {
                    System.out.print("| doesnt need restock |");
                }
            }
            System.out.println();
        }
        System.out.println("===========================================================================");
        System.out.println("Logout (y/n): ");
        decision = input.nextLine();
        if (decision.equalsIgnoreCase("y")) {
            langINDO();
        }
    }

    public static void pembukuanID() {

        System.out.println("==================================");
        System.out.println("Update Sisa Stock Makanan: ");
        System.out.println(makanan = menuRes[0][pilihMak] + " x" + stock[0][pilihMak]);
        System.out.println("Update Sisa Stock Minuman: ");
        System.out.println(minuman = menuRes[1][pilihMin] + " x" + stock[1][pilihMin]);
        System.out.println("==================================");
        System.out.println("Laporan penjualan pada " + hariIni);
        System.out.println("Pemasukan Hari ini: " + totalToday);
        System.out.println("dengan jumlah pelanggan: " + totalcustomer);
    }

    public static void pelanggan() {

        // Semua berada di satu LOOP yang besar...
        for (int i = 1; i < 10000; i++) {
            boolean isbreak = true;
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

                } else if (pilihMak > menuRes[0].length && pilihMin > menuRes[1].length) {
                    System.out.println("[WARNING] ID MAKANAN TIDAK VALID!");
                    System.out.println("Mohon input kembali dengan input yang benar!");
                    isbreak = false;
                    break;
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
        System.out.print("Log out (y/n): ");
        String decision = inputStr.nextLine();
        if (decision.equalsIgnoreCase("y")) {
            langINDO();
        }

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
        System.out.println("\t \t \t \t" + tanggalHariIni);
        System.out.println();
        if (DayOfMonth % 2 == 1) {
            SetupDiskon();
        }
        System.out.print("Silahkan memilih bahasa | Please select a language (EN/ID): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("en")) {
            langENGLISH();
            clearScreen();
        } else if (langSelect.equalsIgnoreCase("id")) {
            langINDO();
            clearScreen();
        }
        inputL.close();
    }

    public static void EnPelanggan(String langSelect) {
        for (int i = 1; i < 10000; i++) {
            do {
                // Food & Drink Menu Display
                System.out.println("=========<{[ FOOD ]}>=========");
                System.out.println("Food Menu       | Price      ");
                System.out.println("[0] Fried Chicken | Rp. 12000  ");
                System.out.println("[1] Grilled Chicken | Rp. 13500  ");
                System.out.println("[2] Crunchy Fried Chicken | Rp. 15000  ");
                System.out.println("[3] Fried Rice  | Rp. 11000  ");
                System.out.println("[4] Coconut Rice   | Rp. 15000  ");
                System.out.println("========<{[ DRINKS ]}>========");
                System.out.println("Drink Menu     | Price      ");
                System.out.println("[0] Hot Tea   | Rp. 3500   ");
                System.out.println("[1] Sweet Iced Tea | Rp. 3500   ");
                System.out.println("[2] Joshua       | Rp. 7500   ");
                System.out.println("[3] Joyful Soda | Rp. 7500   ");
                System.out.println("[4] Black Coffee   | Rp. 5000   ");

                System.out.print("Enter the Food ID ordered (0~4): ");
                pilihMak = inputInt.nextInt();
                System.out.print("Enter the quantity of the food ordered: ");
                jumlahMak = inputInt.nextInt();
                System.out.print("Enter the Drink ID ordered (0~4): ");
                pilihMin = inputInt.nextInt();
                System.out.print("Enter the quantity of the drink ordered: ");
                jumlahMin = inputInt.nextInt();
                System.out.println("Does the customer confirm the order (y/n)?");
                System.out.print(">>");
                perubahan = inputStr.nextLine();

                if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length) {
                    makanan = menuRes[0][pilihMak];
                    hargaMakanan = price[0][pilihMak];
                    minuman = menuRes[1][pilihMin];
                    hargaMinuman = price[1][pilihMin];
                } else {
                    System.out.println("[WARNING] INVALID FOOD ID!");
                    System.out.println("Please re-enter with correct input!");
                    continue;
                }

                if (perubahan.equalsIgnoreCase("y")) {
                    pesananConfirm = true;
                } else {
                    continue;
                }

            } while (pesananConfirm == false);

            // Processing
            totalbarang = jumlahMak + jumlahMin;
            hargaMinuman *= jumlahMin;
            hargaMakanan *= jumlahMak;
            hargatotal = hargaMakanan + hargaMinuman;
            // Today's Total + Total Price of Previous Orders
            totalToday += hargatotal;
            // Reducing food & drink stock
            stock[0][pilihMak] -= jumlahMak;
            stock[1][pilihMin] -= jumlahMin;
            // Accounting for Order and Payment
            pembukuanID();
            System.out.println("Customer order number " + i + " is " + makanan + " and " + minuman);
            System.out.println("With a total quantity of " + totalbarang);
            System.out.println("That is " + makanan + " quantity " + jumlahMak);
            System.out.println("And " + minuman + " quantity " + jumlahMin);
            System.out.println("Total order amount by the customer is " + hargatotal);
            System.out.println("What method does the customer use to pay?");
            System.out.println("[1] Cash | [2] Bank");
            System.out.print(">>");
            Method = inputInt.nextInt();
            switch (Method) {
                case 1:
                    System.out.println("Customer pays by cash, opening the cashier tray...");
                    break;
                case 2:
                    System.out.println("Customer pays by bank. Instruct the customer on the payment method");
                    break;
            }
            System.out.println("Is there any customer who wants to buy more?");
            System.out.println("Input 'N' if there are no more customers buying.");
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
        System.out.println("The restaurant is now closed");
        System.out.println("==================================");
        System.out.println("Sales report on " + hariIni);
        System.out.println("Today's income: " + totalToday);
        System.out.println("with a total number of customers: " + totalcustomer);

        inputStr.close();
        inputInt.close();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
