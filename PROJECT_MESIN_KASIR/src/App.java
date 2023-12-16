import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

class App {

        // 4 Scanner dikurangi menjadi 2
        public static Scanner inputStr = new Scanner(System.in);
        public static Scanner inputInt = new Scanner(System.in);
        // Tanggal hari ini di import untuk laporan penjualan setelah restoran tutup
        public static MonthDay month = MonthDay.now();
        public static LocalDate tanggalHariIni = LocalDate.now();
        public static DateTimeFormatter formatHariIni = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        public static String hariIni = tanggalHariIni.format(formatHariIni);
        public static int hari = tanggalHariIni.getDayOfMonth();
        // Menambah variabel untuk total penghasilan dan jumlah pelanggan hari ini:
        public static int totalToday = 0, totalcustomer = 0, dayList;

        public static String makanan = "x", minuman = "x", perubahan;
        public static int hargaMakanan = 0, hargaMinuman = 0, jumlahMak, jumlahMin, totalbarang = 0, hargatotal = 0,
                        Method, diskonIn = 0, inputan;
        public static int pilihMak, pilihMin;
        static double diskon = 0;
        public static boolean pesananConfirm = false;
        public static String Idcode;

        // Diganti ke Array 2D!
        public static String[][] menuRes = {
                        { "Ayam Goreng", "Ayam Bakar", "Ayam Kremes", "Nasi Goreng", "Nasi Lemak" },
                        { "Teh Hangat", "Es Teh Manis", "Joshua", "Soda Gembira", "Kopi Hitam" }
        };
        public static int[][] price = {
                        { 12000, 13500, 15000, 11000, 15000 },
                        { 3500, 3500, 7500, 7500, 5000 }
        };
        public static String[] namaList = { "Makanan", "Minuman" };
        public static int[][] stock = {
                        // Placeholder di 9999.
                        { 9999, 9999, 9999, 9999, 9999 },
                        { 9999, 9999, 9999, 9999, 9999 }
        };
        public static String idA[][] = {
                        { "Admin", "Fadlih", "Afrizal" },
                        { "bestAdmin", "Donat", "Udahkuduga" }
        };

        public static int[] discList = new int[2];

        public static int i = 0;
        public static int tampilan = 0, change = 0, payment = 0, payment1 = 0;

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
                        kasirID();
                } else {
                        EnPelanggan();
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
                                        System.out.println("=============================================");

                                        if ((usr.equals(idA[0][0]) && ps.equals(idA[1][0]))
                                                        || (usr.equals(idA[0][1]) && ps.equals(idA[1][1]))
                                                        || (usr.equals(idA[0][2]) && ps.equals(idA[1][2]))) {
                                                if (usr.equals(idA[0][0]) && ps.equals(idA[1][0])) {
                                                        System.out.println("Login sebagai Admin berhasil!");
                                                        System.out.println("Selamat datang kembali, administrator");
                                                        System.out.println("Apa yang ingin anda lakukan hari ini?");
                                                        System.out.println(
                                                                        "=============================================");
                                                        System.out.println();
                                                        System.out.println(
                                                                        "[1] Setup diskon | [2] Restock   | [3] Pembukuan");
                                                        System.out.println(
                                                                        "[4] Logout       | [5] Cek Stock | [6] Tambah Menu");
                                                        System.out.println(
                                                                        "[7] Ganti password");
                                                        decision = input.nextLine();
                                                        switch (decision) {
                                                                case "1":
                                                                        inputDiskon();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                case "2":
                                                                        Restock();
                                                                        break;
                                                                case "3":
                                                                        pembukuanID();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                case "4":
                                                                        if (decision.equalsIgnoreCase("4")
                                                                                        && akun != null) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                case "5":
                                                                        Tampiljumbar();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                case "6":
                                                                        inputTambahan();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                case "7":
                                                                        changeAdminPassword();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
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
                                                        System.out.println(
                                                                        "=============================================");
                                                        System.out.println();
                                                        System.out.println(
                                                                        "[1] Input diskon | [2] Layani Pelanggan | [3] Log out | [4] ganti password");
                                                        decision = input.nextLine();
                                                        switch (decision) {
                                                                case ("1"):
                                                                        setDiskon();
                                                                        break;
                                                                case ("2"):
                                                                        layaniPelanggan();
                                                                        break;
                                                                case ("3"):
                                                                        if (decision.equalsIgnoreCase("3")
                                                                                        && akun != null) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                case ("4"):
                                                                        changePass();
                                                                        System.out.println(
                                                                                        "Apakah anda ingin Log out (y/n): ");
                                                                        decision = input.nextLine();
                                                                        if (decision.equalsIgnoreCase("y")) {
                                                                                isContinue = false;
                                                                                break;
                                                                        }
                                                                        break;
                                                                // Lanjutkan Tampilan kasir mulai dari sini...
                                                        }
                                                }
                                        } else {
                                                // Counter dipindah kesini agar counter menambah hanya saat login salah
                                                counter--;
                                                System.out.println("=============================================");
                                                System.out.println("[DENIED] USERNAME DAN PASSWORD SALAH!!!");
                                                System.out.println(
                                                                "Login gagal! Mohon cek kembali username dan password anda!");
                                                if (counter > 0) {
                                                        System.out.println("Sisa kesempatan login : " + counter);
                                                } else {
                                                        System.out.println(
                                                                        "Kesempatan Login Habis! Sistem akan Di-Lockdown!");
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

        public static void changePass() {
                int row = 0, column = 0;
                boolean iscont = true;
                System.out.print("Masukan password lama: ");
                String input = inputStr.nextLine();
                for (int i = 0; i < idA.length; i++) {
                        for (int j = 0; j < idA[0].length; j++) {
                                if (input.equals(idA[i][j])) {
                                        row = i;
                                        column = j;
                                        System.out.print("Masukan password baru: ");
                                        idA[row][column] = inputStr.nextLine();
                                }
                                iscont = false;
                                continue;
                        }
                }
        }

        public static void changeAdminPassword() {
                System.out.print("masukan password lama: ");
                String input = inputStr.nextLine();
                if (input.equals(idA[1][0])) {
                        System.out.print("masukan password baru: ");
                        idA[1][0] = inputStr.nextLine();
                }
        }

        public static void inputDiskon() {
                boolean iscont = true;
                for (int i = 0; i < discList.length; i++) {
                        System.out.print("mau masukan untuk minggu " + i + ": ");
                        discList[i] = inputInt.nextInt();
                }
        }

        public static void DisplayDiscount() {
                for (int i : discList) {
                        tampilan = i;
                }
        }

        public static void Restock() {
                Scanner input = new Scanner(System.in);
                String decision;
                System.out.println("Keterangan: ");
                System.out.println("+++ = butuh restock");
                System.out.println("*** = tidak memerlukan restock");
                System.out.println("=========================================================================");
                for (int i = 0; i < stock.length; i++) {
                        for (int j = 0; j < stock[0].length; j++) {
                                if (stock[i][j] < 500) {
                                        stock[i][j] = 9999;
                                        if (stock[i][j] == 9999) {
                                                System.out.print("| +++ |");
                                        }

                                } else if (stock[i][j] == 9999) {
                                        System.out.print("| *** |");
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
                System.out.println("Dengan jumlah pelanggan: " + totalcustomer);
        }

        public static void Tampiljumbar() {
                for (int i = 0; i < stock.length; i++) {
                        for (int j = 0; j < stock[0].length; j++) {
                                System.out.println(namaList[0]);
                                System.out.print(menuRes[0][j] + ": ");
                                System.out.print(stock[0][j] + "\n");
                                System.out.println(namaList[1]);
                                System.out.print(menuRes[1][j] + ": ");
                                System.out.print(stock[1][j] + "\n");
                        }
                }
        }

        public static void inputTambahan() {
                for (int i = 0; i < menuRes.length; i++) {
                        for (int j = 0; j < menuRes[0].length; j++) {
                                boolean iscont = true;
                                System.out.println("=============================================");
                                System.out.print("Berapa jumlah menu yang mau ditambahkan: ");
                                int jumlah = inputInt.nextInt();
                                System.out.print("Menu apa yang ingin ditambahkan? (makanan/minuman): ");
                                String decision = inputStr.nextLine();

                                if (decision.equalsIgnoreCase("makanan")) {
                                        for (int k = 0; k < jumlah; k++) {
                                                System.out.print("Masukkan menu makanan tambahan: ");
                                                menuRes[0][k] = inputStr.nextLine();
                                                System.out.print("Masukkan harga produk/menu: ");
                                                price[0][k] = inputInt.nextInt();
                                                System.out.print("Masukkan jumlah stok nya: ");
                                                stock[0][k] = inputInt.nextInt();
                                                System.out.println("=============================================");
                                        }
                                        iscont = false;
                                        System.out.println("Apakah anda ingin Log out (y/n): ");
                                        decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                langINDO();
                                                break;
                                        }

                                }
                                if (decision.equalsIgnoreCase("Minuman")) {
                                        for (int z = 0; z < jumlah; z++) {
                                                System.out.print("Masukkan menu minuman tambahan: ");
                                                menuRes[1][z] = inputStr.nextLine();
                                                System.out.print("Masukan harga produk/menu: ");
                                                price[1][z] = inputInt.nextInt();
                                                System.out.print("Masukkan jumlah stok nya: ");
                                                stock[0][z] = inputInt.nextInt();
                                                System.out.println("=============================================");
                                        }
                                        iscont = false;
                                        System.out.println("Apakah anda ingin Log out (y/n): ");
                                        decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                langINDO();
                                                break;
                                        }
                                }
                        }
                }
        }

        public static void layaniPelanggan() {
                boolean isbreak = true; // ???
                for (int i = 1; i < 10000; i++) {
                        do {
                                // Tampilan Menu Makanan & Minuman
                                for (int j = 0; j < namaList.length; j++) {
                                        if (j == 0) {
                                                System.out.println("=========<{[ FOOD ]}>=========");
                                        } else if (j == 1) {
                                                System.out.println("========<{[ DRINKS ]}>========");
                                        }
                                        for (int j2 = 0; j2 < menuRes[j].length; j2++) {
                                                System.out.println("[ ID:" + j2 + " ] " + menuRes[j][j2]);
                                                System.out.println("Harga : " + price[j][j2]);
                                        }
                                }

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
                                System.out.println("=============================================");

                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (jumlahMak > stock[j][k] && jumlahMin > stock[j][k]) {
                                                        System.out.println(
                                                                        "[WARNING] MAKANAN TIDAK MEMPUNYAI KAPASITAS SEBANYAK ITU");
                                                        System.out.println(
                                                                        "Masukan jumlah makanan lebih kecil! / bisa jadi habis");
                                                        System.out.print("kembali ke menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }
                                int max = 0;
                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (max == stock[j][k]) {
                                                        System.out.println("[WARNING] MAKANANN " + stock[j][k]
                                                                        + " INI SUDAH HABIS");
                                                        System.out.println("silahkan pilih id makanan lain !");
                                                        System.out.print("kembali ke menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }
                                if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length) {
                                        makanan = menuRes[0][pilihMak];
                                        hargaMakanan = price[0][pilihMak];
                                        minuman = menuRes[1][pilihMin];
                                        hargaMinuman = price[1][pilihMin];

                                } else {
                                        System.out.println("[WARNING] ID MAKANAN TIDAK VALID!");
                                        System.out.println("Mohon input kembali dengan input yang benar!");
                                        isbreak = false;
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
                        // Trigger diskon
                        if (hargatotal >= 25000) {
                                System.out.println("Pelanggan mendapatkan diskon sebesar " + diskon + "%!");
                                double discountedPrice = hargatotal * diskon;
                                hargatotal = (int) (hargatotal - discountedPrice);
                        }
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
                                        System.out.print("Masukan jumlah nominal yang akan dibayar: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change < 0) {
                                                System.out.println("Biaya tidak cukup! Masukkan nominal yang sesuai");
                                                continue;
                                        }
                                        System.out.print("Apakah anda ingin mencetak struk(y/n): ");
                                        String decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                StrukCash();
                                        }
                                        break;
                                case 2:
                                        System.out.println(
                                                        "Pelanggan membayar dengan bank. Instruksikan pelanggan untuk cara pembayaran");
                                        System.out.print("Masukan no rekening pada mesin (12 digit): ");
                                        Idcode = inputStr.nextLine();
                                        System.out.print("Masukan nominal pembayaran: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change > 0) {
                                                System.out.println("Biaya tidak cukup! Masukkan nominal yang sesuai");
                                                continue;
                                        }
                                        System.out.print("Apakah anda ingin cetak struk(y/n): ");
                                        String decision1 = inputStr.nextLine();
                                        if (decision1.equalsIgnoreCase("y")) {
                                                StrukBank();
                                        }
                                        break;
                        }

                        System.out.println("==================================");
                        System.out.println("Update Sisa Stock Makanan: ");
                        System.out.println(makanan = menuRes[0][pilihMak] + " x" + stock[0][pilihMak]);
                        System.out.println("Update Sisa Stock Minuman: ");
                        System.out.println(minuman = menuRes[1][pilihMin] + " x" + stock[1][pilihMin]);
                        System.out.println("==================================");

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
        }

        public static void setDiskon() {
                do {
                        System.out.println("=============================================");
                        System.out.println("Masukkan diskon untuk hari ini");
                        System.out.print(">>");
                        diskonIn = inputInt.nextInt();
                        if (diskonIn > 0 && diskonIn < 101) {
                                System.out.println("Diskon hari ini sudah di-set!");
                                diskon = ((double) diskonIn / 100);
                                System.out.println("Diskon hari ini sebesar " + diskonIn + "%");
                                System.out.println("Multiplier Diskon: " + diskon + "x");
                                break;
                        } else {
                                System.out.println("Besar diskon invalid!");
                        }
                } while (true);

        }

        public static void pelanggan() {
                // Semua berada di satu LOOP yang besar...
                boolean isbreak = true;
                for (int i = 1; i < 10000; i++) {
                        do {
                                // Tampilan Menu Makanan & Minuman
                                for (int j = 0; j < namaList.length; j++) {
                                        if (j == 0) {
                                                System.out.println("=========<{[ FOOD ]}>=========");
                                        } else if (j == 1) {
                                                System.out.println("========<{[ DRINKS ]}>========");
                                        }
                                        for (int j2 = 0; j2 < menuRes[j].length; j2++) {
                                                System.out.println("[ ID:" + j2 + " ] " + menuRes[j][j2]);
                                                System.out.println("Harga : " + price[j][j2]);
                                        }
                                }

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

                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (jumlahMak > stock[j][k] && jumlahMin > stock[j][k]) {
                                                        System.out.println(
                                                                        "[WARNING] MAKANAN TIDAK MEMPUNYAI KAPASITAS SEBANYAK ITU");
                                                        System.out.println(
                                                                        "Masukan jumlah makanan lebih kecil! / bisa jadi habis");
                                                        System.out.print("kembali ke menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }
                                int max = 0;
                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (max == stock[j][k]) {
                                                        System.out.println("[WARNING] MAKANANN " + stock[j][k]
                                                                        + " INI SUDAH HABIS");
                                                        System.out.println("silahkan pilih id makanan lain !");
                                                        System.out.print("kembali ke menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }
                                if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length) {
                                        makanan = menuRes[0][pilihMak];
                                        hargaMakanan = price[0][pilihMak];
                                        minuman = menuRes[1][pilihMin];
                                        hargaMinuman = price[1][pilihMin];

                                } else {
                                        System.out.println("[WARNING] ID MAKANAN TIDAK VALID!");
                                        System.out.println("Mohon input kembali dengan input yang benar!");
                                        isbreak = false;
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

                        stock[0][pilihMak] -= jumlahMak;
                        stock[1][pilihMin] -= jumlahMin;

                        System.out.println("=============================================");
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
                                        System.out.println("=============================================");
                                        System.out.println("Pelanggan membayar secara cash, membuka tray kasir...");
                                        System.out.print("Masukan jumlah nominal yang akan dibayar: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change < 0) {
                                                System.out.println("Biaya tidak cukup masukan uang yang sesuai");
                                                continue;
                                        }
                                        if (hargatotal > 50000 && hargatotal <= 75000) {
                                                int remp = discList[0];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        } else if (hargatotal >= 75000) {
                                                int remp = discList[1];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        }
                                        System.out.print("Apakah anda ingin mencetak struk(y/n): ");
                                        String decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                StrukCash();
                                        }
                                        break;
                                case 2:
                                        System.out.println(
                                                        "Anda membayar dengan bank, mohon ketik 12 digit nomer rekening anda.");
                                        System.out.print("Masukan no rekening pada mesin (12 digit): ");
                                        Idcode = inputStr.nextLine();
                                        System.out.print("MAsukan nominal pembayaran: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change < 0) {
                                                System.out.println("Biaya tidak cukup masukan uang yang sesuai");
                                                continue;
                                        }
                                        if (hargatotal > 50000 && hargatotal <= 75000) {
                                                int remp = discList[0];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        } else if (hargatotal >= 75000) {
                                                int remp = discList[1];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        }
                                        System.out.print("apakah anda ingin cetak struk(y/n): ");
                                        decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                StrukBank();
                                        }
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

                System.out.println("====================================");
                System.out.println("Restoran sekarang tutup");
                System.out.println("==================================");
                System.out.print("Log out (y/n): ");
                String decision = inputStr.nextLine();
                if (decision.equalsIgnoreCase("y")) {
                        main(namaList);
                }

                inputStr.close();
                inputInt.close();

        }

        public static void StrukCash() {
                System.out.println("==================================");
                System.out.println("|         STRUK PEMBELIAN        |");
                System.out.println("|        Resto Datuk Melayu      |");
                System.out.println("|Resto bintang lima, harga kaki lima|");
                System.out.println("----------------------------------");
                System.out.println("| Tanggal: " + tanggalHariIni);
                System.out.println("| Pelanggan ke-" + i);
                System.out.println("----------------------------------");
                System.out.println("| " + makanan);
                System.out.println("| " + hargaMakanan + "\t\t\t" + "x" + jumlahMak);
                System.out.println("| " + minuman);
                System.out.println("| " + hargaMinuman + "\t\t\t" + "x" + jumlahMin);
                System.out.println("----------------------------------");
                System.out.println("| Total Item: " + totalbarang);
                System.out.println("| Total: " + hargatotal);
                System.out.println("| Uang yang dibayarkan: " + payment);
                System.out.println("| Uang kembalian: " + change);
                System.out.println("|                                |");
                System.out.println("| Metode pembayaran: " + Method);
                System.out.println("==================================");
                System.out.println();
        }

        public static void EnStrukCash() {
                System.out.println("==================================");
                System.out.println("|         PURCHASE RECEIPT        |");
                System.out.println("|       Datuk Melayu Restaurant   |");
                System.out.println("|Five-star restaurant, five-star price|");
                System.out.println("----------------------------------");
                System.out.println("| Date: " + tanggalHariIni);
                System.out.println("| Customer No: " + i);
                System.out.println("----------------------------------");
                System.out.println("| " + makanan);
                System.out.println("| " + hargaMakanan + "\t\t\t" + "x" + jumlahMak);
                System.out.println("| " + minuman);
                System.out.println("| " + hargaMinuman + "\t\t\t" + "x" + jumlahMin);
                System.out.println("----------------------------------");
                System.out.println("| Total Items: " + totalbarang);
                System.out.println("| Total: " + hargatotal);
                System.out.println("| Amount Paid: " + payment);
                System.out.println("| Change: " + change);
                System.out.println("|                                |");
                System.out.println("| Payment Method: " + Method);
                System.out.println("==================================");
                System.out.println();
        }

        public static void StrukBank() {
                System.out.println("==================================");
                System.out.println("|         STRUK PEMBELIAN        |");
                System.out.println("|        Resto Datuk Melayu      |");
                System.out.println("|Resto bintang lima, harga kaki lima|");
                System.out.println("----------------------------------");
                System.out.println("| Tanggal: " + tanggalHariIni);
                System.out.println("| Pelanggan ke-" + i);
                System.out.println("----------------------------------");
                System.out.println("| " + makanan);
                System.out.println("| " + hargaMakanan + "\t\t\t" + "x" + jumlahMak);
                System.out.println("| " + minuman);
                System.out.println("| " + hargaMinuman + "\t\t\t" + "x" + jumlahMin);
                System.out.println("----------------------------------");
                System.out.println("| Total Item: " + totalbarang);
                System.out.println("| Total: " + hargatotal);
                System.out.println("| Uang yang dibayarkan: " + payment);
                System.out.println("| Rekening pelanggan: " + Idcode);
                System.out.println("|                                |");
                System.out.println("|  Metode Pembayaran ke-" + Method);
                System.out.println("| \t\t thank you \t\t |");
                System.out.println("==================================");
                System.out.println();
                if (pesananConfirm) {
                        System.out.println("==================================");
                        System.out.println("Pembayaran anda telah diterima");
                        System.out.println("==================================");
                        System.out.println();

                }

        }

        public static void EnStrukBank() {
                System.out.println("==================================");
                System.out.println("|          PURCHASE RECEIPT       |");
                System.out.println("|       Datuk Melayu Restaurant   |");
                System.out.println("|Five-star restaurant, five-star price|");
                System.out.println("----------------------------------");
                System.out.println("| Date: " + tanggalHariIni);
                System.out.println("| Customer number: " + i);
                System.out.println("----------------------------------");
                System.out.println("| " + makanan);
                System.out.println("| " + hargaMakanan + "\t\t\t" + "x" + jumlahMak);
                System.out.println("| " + minuman);
                System.out.println("| " + hargaMinuman + "\t\t\t" + "x" + jumlahMin);
                System.out.println("----------------------------------");
                System.out.println("| Total Items: " + totalbarang);
                System.out.println("| Total: " + hargatotal);
                System.out.println("| Amount paid: " + payment);
                System.out.println("| Customer's account: " + Idcode);
                System.out.println("|                                |");
                System.out.println("|  Payment Method: " + Method);
                System.out.println("| \t\t thank you \t\t |");
                System.out.println("==================================");
                System.out.println();
                if (pesananConfirm) {
                        System.out.println("==================================");
                        System.out.println("Your payment has been received");
                        System.out.println("==================================");
                        System.out.println();
                }
        }

        public static void EnPelanggan() {
                boolean isBreak = true;
                for (int i = 1; i < 10000; i++) {
                        do {
                                // Food & Drinks Menu Display
                                for (int j = 0; j < namaList.length; j++) {
                                        if (j == 0) {
                                                System.out.println("=========<{[ FOOD ]}>=========");
                                        } else if (j == 1) {
                                                System.out.println("========<{[ DRINKS ]}>========");
                                        }
                                        for (int j2 = 0; j2 < menuRes[j].length; j2++) {
                                                System.out.println("[ ID:" + j2 + " ] " + menuRes[j][j2]);
                                                System.out.println("Harga : " + price[j][j2]);
                                        }
                                }

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

                                // Checking food and drink availability
                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (jumlahMak > stock[j][k] && jumlahMin > stock[j][k]) {
                                                        System.out.println(
                                                                        "[WARNING] FOOD DOES NOT HAVE THAT MUCH CAPACITY");
                                                        System.out.println(
                                                                        "Enter a smaller quantity of food! / sold out");
                                                        System.out.print("Back to the menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }

                                int max = 0;
                                for (int j = 0; j < stock.length; j++) {
                                        for (int k = 0; k < stock[0].length; k++) {
                                                if (max == stock[j][k]) {
                                                        System.out.println("[WARNING] THIS FOOD " + stock[j][k]
                                                                        + " IS ALREADY SOLD OUT");
                                                        System.out.println("Please choose another food ID!");
                                                        System.out.print("Back to the menu (y/n): ");
                                                        String decision = inputStr.nextLine();
                                                        if (decision.equalsIgnoreCase("y")) {
                                                                pelanggan();
                                                                break;
                                                        }
                                                }
                                        }
                                }

                                if (pilihMak < menuRes[0].length && pilihMin < menuRes[1].length) {
                                        makanan = menuRes[0][pilihMak];
                                        hargaMakanan = price[0][pilihMak];
                                        minuman = menuRes[1][pilihMin];
                                        hargaMinuman = price[1][pilihMin];

                                } else {
                                        System.out.println("[WARNING] INVALID FOOD ID!");
                                        System.out.println("Please input with the correct ID!");
                                        isBreak = false;
                                        continue;
                                }

                                if (perubahan.equalsIgnoreCase("y")) {
                                        pesananConfirm = true;

                                } else {
                                        continue;
                                }

                        } while (!pesananConfirm);

                        // Processing
                        totalbarang = jumlahMak + jumlahMin;
                        hargaMinuman *= jumlahMin;
                        hargaMakanan *= jumlahMak;
                        hargatotal = hargaMakanan + hargaMinuman;
                        // Today's total + Total of Previous Orders
                        totalToday += hargatotal;
                        // Deducting food & drink from stock
                        stock[0][pilihMak] -= jumlahMak;
                        stock[1][pilihMin] -= jumlahMin;
                        // Order Record and Payment
                        System.out.println("=============================================");
                        System.out.println("Customer's order number " + i + " is " + makanan + " and " + minuman);
                        System.out.println("With a total quantity of " + totalbarang);
                        System.out.println("That is " + makanan + " as much as " + jumlahMak);
                        System.out.println("And " + minuman + " as much as " + jumlahMin);
                        System.out.println("Total customer order is " + hargatotal);
                        System.out.println("How does the customer pay?");
                        System.out.println("[1] Cash | [2] Bank");
                        System.out.print(">>");
                        Method = inputInt.nextInt();
                        switch (Method) {
                                case 1:
                                        System.out.println("=============================================");
                                        System.out.println("Customer pays in cash, opening the cashier tray...");
                                        System.out.print("Enter the amount to be paid: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change < 0) {
                                                System.out.println(
                                                                "Insufficient funds, please enter the correct amount");
                                                continue;
                                        }
                                         if (hargatotal > 50000 && hargatotal <= 75000) {
                                                int remp = discList[0];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "congratulation, your purchase has discounted and become : " + temps);
                                        } else if (hargatotal >= 75000) {
                                                int remp = discList[1];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "congratulation, your purchase has discounted and become : " + temps);
                                        }
                                        System.out.print("Do you want to print a reciept(y/n): ");
                                        String decision = inputStr.nextLine();
                                        if (decision.equalsIgnoreCase("y")) {
                                                EnStrukCash();
                                        }
                                        break;
                                case 2:
                                        System.out.println("=============================================");
                                        System.out.println(
                                                        "Customer pays by bank. Please insert the account numbers.");
                                        System.out.print("Enter the account number on the machine (12 digits): ");
                                        String accountId = inputStr.nextLine();
                                        System.out.print("Enter the payment amount: ");
                                        payment = inputInt.nextInt();
                                        change = payment - hargatotal;
                                        if (change > 0) {
                                                System.out.println(
                                                                "Insufficient funds, please enter the correct amount");
                                                continue;
                                        }
                                         if (hargatotal > 50000 && hargatotal <= 75000) {
                                                int remp = discList[0];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        } else if (hargatotal >= 75000) {
                                                int remp = discList[1];
                                                int temps = hargatotal - (remp / 100 * hargatotal);
                                                change = payment - temps;
                                                System.out.println(
                                                                "Selamat, anda mendapat diskon! Harga yang harus dibayar akan dipotong menjadi : " + temps);
                                        }
                                        System.out.print("Do you want to print a receipt? (y/n): ");
                                        String decision1 = inputStr.nextLine();
                                        if (decision1.equalsIgnoreCase("y")) {
                                                EnStrukBank();
                                        }
                                        break;
                        }
                        System.out.println("=============================================");
                        System.out.println("Does any customer want to buy more?");
                        System.out.println("Enter 'N' if no customers want to buy more.");
                        System.out.print(">>");
                        String morePurchase = inputStr.nextLine();
                        if (morePurchase.equalsIgnoreCase("n")) {
                                totalcustomer = i;
                                break;
                        } else {
                                continue;
                        }
                }

                System.out.println("====================================");
                System.out.println("The restaurant is now closed");
                System.out.println("==================================");
                System.out.print("Log out (y/n): ");
                String decision = inputStr.nextLine();
                if (decision.equalsIgnoreCase("y")) {
                        main(namaList);
                        ;
                }

                inputStr.close();
                inputInt.close();

        }

        public static void main(String[] args) {
                Scanner inputL = new Scanner(System.in);
                Scanner inputB = new Scanner(System.in);
                String langSelect;

                System.out.println(" \t \t ===================================== \t \t");
                System.out.println("\t \t \t Resto Datuk Melayu \t \t \t ");
                System.out.println("\t \t Resto bintang lima, harga kaki lima \t \t");
                System.out.println(" \t \t ===================================== \t \t");
                System.out.println("\t \t \t \t" + tanggalHariIni);
                System.out.println();
                System.out.print("Silahkan memilih bahasa | Please select a language (EN/ID): ");
                langSelect = inputL.nextLine();
                if (langSelect.equalsIgnoreCase("en")) {
                        langENGLISH();
                } else if (langSelect.equalsIgnoreCase("id")) {
                        langINDO();
                }
                inputL.close();
        }
}
