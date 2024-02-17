import java.util.Scanner;

public class FastFood {
static final String[] FOOD_OPTIONS = {"Nasi Goreng", "Sate Ayam", "Mie Ayam", "Bakso", "Martabak", "Ayam Geprek", "Gacoan", "Naoki Rice", "Nasi Ayam", "Soto", "Tahu Telur", "Chicken Katsu"};
static final int[] FOOD_PRICES = {15000, 20000, 15000, 18000, 30000, 15000, 10000, 30000, 11000, 11000, 12000, 15000};
static final String[] DRINK_OPTIONS = {"Es Teh", "Es Jeruk", "Es Cincau", "Jus Alpukat", "Kopi", "Jus", "Es Teler", "Thai Tea", "Boba Tea", "Mixue", "Avocado Choco"};
static final int[] DRINK_PRICES = {5000, 6000, 7000, 8000, 4000, 12000, 13000, 15000, 20000, 13000, 16000};
static final int BIAYA_PER_KM = 1000;
static final int biayaAplikasi = 5000;
static final String[] YA_OPTIONS = {"Ya", "Iya", "iya", "y", "ya", "oke", "Oke", "Y", "Ya", "ya", "Boleh", "boleh", "sip", "Sip", "Siap", "siap"};
static final String[] TIDAK_OPTIONS = {"no", "No", "nope", "Nope", "Tidak", "tidak", "enggak", "engga", "ngga", "nggak", "Enggak", "Engga", "Ngga", "Nggak", "Ga", "ga", "g", "G", "Ga", "GA", "Gak", "GAK", "gak", "Gak dulu", "gadulu", "Gadulu"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            displayMenu();
            String check = input.next();
            input.nextLine();

            while (true) {
                boolean Ya = false;
                boolean Tidak = false;
            
                for (String yaOption : YA_OPTIONS) {
                    if (yaOption.equalsIgnoreCase(check)) {
                        Ya = true;
                        break;
                    }
                }
            
                for (String tidakOption : TIDAK_OPTIONS) {
                    if (tidakOption.equalsIgnoreCase(check)) {
                        Tidak = true;
                        break;
                    }
                }
            
                if (Tidak || Ya) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again : ");
                    check = input.nextLine();
                }
            }
            

            System.out.println("Pilih jenis pesanan (1. Makanan, 2. Minuman): ");
            int jenisPesanan = input.nextInt();
            input.nextLine();

            if (jenisPesanan == 1) {
                int jenisMakanan = jenisMakanan(input);
                int jumlah = jumlahMakanan(input);
                double distance = jarakOngkir(input);

                double hargaTotalMakanan = penjumlahanMakanan(jenisMakanan, jumlah);
                double biayaOngkir = calculatebiayaOngkir(distance);
                double totalCost = hargaTotalMakanan + biayaOngkir + biayaAplikasi;

                System.out.println("=".repeat(60));
                System.out.println("Total Harga Makanan: Rp" + hargaTotalMakanan);
                System.out.println("Biaya Ongkir: Rp" + biayaOngkir);
                System.out.println("Total Biaya: Rp" + totalCost);

            } else if (jenisPesanan == 2) {
                int jenisMinuman = jenisMinuman(input);
                int jumlah = jumlahMinuman(input);
                double distance = jarakOngkir(input);

                double hargaTotalMinuman = penjumlahanMinuman(jenisMinuman, jumlah);
                double biayaOngkir = calculatebiayaOngkir(distance);
                double totalCost = hargaTotalMinuman + biayaOngkir + biayaAplikasi;

                System.out.println("=".repeat(60));
                System.out.println("Total Harga Minuman: Rp" + hargaTotalMinuman);
                System.out.println("Biaya Ongkir: Rp" + biayaOngkir);
                System.out.println("Total Biaya: Rp" + totalCost);
            }

            System.out.print("Apakah anda ingin melanjutkan ke checkout? (Y/N) ");
            check = input.next();
            input.nextLine();

            while (true) {
                boolean Ya = false;
                boolean Tidak = false;
            
                for (String yaOption : YA_OPTIONS) {
                    if (yaOption.equalsIgnoreCase(check)) {
                        Ya = true;
                        break;
                    }
                }
            
                for (String tidakOption : TIDAK_OPTIONS) {
                    if (tidakOption.equalsIgnoreCase(check)) {
                        Tidak = true;
                        break;
                    }
                }
            
                if (Tidak || Ya) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again : ");
                    check = input.nextLine();
                }
            }
            
        }
    }
    
        private static int jenisMinuman(Scanner input) {
            tampilanMinuman();
            System.out.print("Silakan masukkan pilihan minuman anda berdasarkan nomornya: ");
            int jenisMinuman = input.nextInt();
    
            while (jenisMinuman < 1 || jenisMinuman > 11) {
                System.out.println("Invalid input. Please try again : ");
                jenisMinuman = input.nextInt();
            }
            return jenisMinuman;
        }
    
        private static void tampilanMinuman() {
            System.out.println("=".repeat(60));
            System.out.println("Berikut adalah list minuman yang bisa anda pesan:");
    
            for (int i = 0; i < DRINK_OPTIONS.length; i++) {
                System.out.println((i + 1) + ") " + DRINK_OPTIONS[i] + " - Rp" + DRINK_PRICES[i]);
            }
            System.out.println("=".repeat(60));
        }
    
        private static int jumlahMinuman(Scanner input) {
            System.out.print("Silakan masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();
    
            while (jumlah <= 0) {
                System.out.println("Invalid input. Please try again : ");
                jumlah = input.nextInt();
            }
            return jumlah;
        }
    
        private static double penjumlahanMinuman(int jenisMinuman, int jumlah) {
            int harga = jenisMinuman - 1; 
            return DRINK_PRICES[harga] * jumlah;
        }

    private static void displayMenu() {
        System.out.println("=".repeat(60));
        System.out.print("Lanjut ke menu GoFood? (Y/N) ");
    }

    private static int jenisMakanan(Scanner input) {
        tampilanAplikasi();
        System.out.print("Silakan masukan pilihan makanan anda berdasarkan nomornya: ");
        int jenisMakanan = input.nextInt();

        while (jenisMakanan < 1 || jenisMakanan > 12) {
            System.out.println("Invalid input. Please try again : ");
            jenisMakanan = input.nextInt();
        }
        return jenisMakanan;
    }

    private static void tampilanAplikasi() {
        System.out.println("=".repeat(60));
        System.out.println("Selamat datang di layanan GoFood");
        System.out.println("Berikut adalah list makanan yang bisa anda pesan:");

        for (int i = 0; i < FOOD_OPTIONS.length; i++) {
            System.out.println((i + 1) + ") " + FOOD_OPTIONS[i] + " - Rp" + FOOD_PRICES[i]);
        }
        System.out.println("=".repeat(60));
    }

    private static int jumlahMakanan(Scanner input) {
        System.out.print("Silakan masukkan jumlah pesanan: ");
        int jumlah = input.nextInt();

        while (jumlah <= 0) {
            System.out.println("Invalid input. Please try again : ");
            jumlah = input.nextInt();
        }
        return jumlah;
    }


    private static double jarakOngkir(Scanner input) {
        System.out.print("Silakan masukkan jarak pesanan (km): ");
        double distance = input.nextDouble();

        while (distance <= 0) {
            System.out.println("Invalid input. Please try again : ");
            distance = input.nextDouble();
        }
        return distance;
    }

    private static double penjumlahanMakanan(int jenisMakanan, int jumlah) {
        int harga = jenisMakanan - 1; 
        return FOOD_PRICES[harga] * jumlah;
    }

    private static int getOrderChoice(Scanner input) {
        System.out.println("=".repeat(60));
        System.out.println("Pilih kategori pesanan:");
        System.out.println("1) Makanan");
        System.out.println("2) Minuman");
        System.out.print("Masukkan pilihan (1/2): ");
        return input.nextInt();
    }

    private static double calculatebiayaOngkir(double distance) {
        return BIAYA_PER_KM * distance;
    }

    private static void confirmOrder() {
        System.out.println("=".repeat(60));
        System.out.println("*confirm order");
        System.out.println("=".repeat(60));
        System.out.println("Pesanan anda telah diterima.");
        System.out.println("Terima kasih telah menggunakan layanan GoFood.");
    }
}
