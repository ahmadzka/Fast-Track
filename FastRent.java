import java.util.Scanner;

public class FastRent {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("=".repeat(60));
            System.out.print("Lanjut ke menu Fast-Rent? (Y?N) ");
            String check = input.next();
            input.nextLine();
            while (!check.equals("Y") && !check.equals("N")) {
                System.out.println("Invalid input. Please try again : ");
                check = input.nextLine();
            }
            if (check.equals("N")) {
                break;
            }
            System.out.println("=".repeat(60));
            System.out.println("Selamat datang di layanan Fast-Rent");
            System.out.println("Berikut adalah list dari kendaraan yang bisa anda sewa:");
            System.out.println("1) Mobil Biasa");
            System.out.println("2) Mobil Pickup");
            System.out.println("3) Minitruck");
            System.out.println("4) Minibus");
            System.out.println("5) Motor");
            System.out.println("=".repeat(60));
            System.out.print("Silakan masukan pilihan anda berdasarkan nomornya: ");
            int kendaraan = input.nextInt();
            while (kendaraan < 1 && kendaraan > 5) {
                System.out.println("Invalid input. Please try again : ");
                kendaraan = input.nextInt();
            }
            System.out.println("=".repeat(60));
            System.out.println("Berikut adalah pilihan durasi peminjaman:");
            System.out.println("1) 12 jam");
            System.out.println("2) 24 jam");
            System.out.println("3) 1 minggu");
            System.out.println("=".repeat(60));
            System.out.print("Silakan masukan pilihan anda berdasarkan nomornya: ");
            int durasi = input.nextInt();
            while (durasi < 1 && durasi > 3) {
                System.out.println("Invalid input. Please try again : ");
                durasi = input.nextInt();
            }
            System.out.println("=".repeat(60));
            System.out.println("Berikut adalah total penyewaan anda: " + rentCalc(kendaraan, durasi));
            System.out.print("Apakah anda ingin melanjutkan ke checkout? (Y/N) ");
            check = input.next();
            input.nextLine();
            while (!check.equals("Y") && !check.equals("N")) {
                System.out.println("Invalid input. Please try again :");
                check = input.nextLine();
            }
            if (check.equals("Y")) {
                System.out.println("=".repeat(60));
                System.out.println("*confirm regist");
                System.out.println("=".repeat(60));
                System.out.println("Permohonan sewa anda diterima.");
                System.out.println("Terima kasih telah menggunakan layanan Fast-Rent.");
            } else if (check.equals("N")) {
                System.out.println("Mengembalikan ke menu.....");
                continue;
            }
        }
    }

    public static int rentCalc(int k, int d) {
        int mobil_Biasa = 400000; // perhari
        int mobil_pickup = 150000; // perhari
        int minitruck = 1000000; // perhari
        int minibus = 2000000; // perhari
        int motor = 60000; // perhari
        int biaya_aplikasi = 10000;
        int total = 0;
        if (k == 1) {
            if (d == 1) {
                total += (mobil_Biasa / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += mobil_Biasa + biaya_aplikasi;
            } else if (d == 3) {
                total += (mobil_Biasa * 7) + biaya_aplikasi;
            }
        } else if (k == 2) {
            if (d == 1) {
                total += (mobil_pickup / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += mobil_pickup + biaya_aplikasi;
            } else if (d == 3) {
                total += (mobil_pickup * 7) + biaya_aplikasi;
            }
        } else if (k == 3) {
            if (d == 1) {
                total += (minitruck / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += minitruck + biaya_aplikasi;
            } else if (d == 3) {
                total += (minitruck * 7) + biaya_aplikasi;
            }
        } else if (k == 4) {
            if (d == 1) {
                total += (minibus / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += minibus + biaya_aplikasi;
            } else if (d == 3) {
                total += (minibus * 7) + biaya_aplikasi;
            }
        } else if (k == 5) {
            if (d == 1) {
                total += (motor / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += motor + biaya_aplikasi;
            } else if (d == 3) {
                total += (motor * 7) + biaya_aplikasi;
            }
        }
        return total;
    }
}
