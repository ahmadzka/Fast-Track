import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class FastTrack{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("============================|Fast--Go|============================");
        System.out.printf("%-50s %s","Pilih jenis Kendaraan (Motor/Mobil)",": ");
        String kendaraan = in.next();
        System.out.printf("%-50s %s","Masukkan Jarak Perjalanan (Km)",": ");
        float jarak = in.nextInt();
        System.out.printf("Opsi pembayaran: \n");
        System.out.printf("|%-10s |%-10s|\n", "Fast-Pay","GOPAY");
        System.out.printf("|%-10s |%-10s|\n","OVO","CASH");
        System.out.printf("%-50s %s","Masukkan opsi pembayaran",": ");
        String pembayaran = in.next();
        border();
        double tarif = hitungTarif(jarak, kendaraan);
        double diskon = hitungDiskon(tarif, pembayaran);
        double total = tarif - diskon;
        pembayaran(total);
        border();
    }
    public static void pembayaran(double total){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00",symbols);
        System.out.printf("%-50s %s\n","Total pembayaran",": " + df.format(total));
    }
    public static void border() {
        System.out.println("==================================================================");
    }
    public static double hitungTarif(double jarak, String kendaraan) {
        double tarif = 0;
        if (jarak <= 2) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 25000 : 15000;
        } else if (jarak <= 5) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 40000 : 20000;
        } else if (jarak <= 10) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 65000 : 30000;
        } else {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? jarak * 15000 : jarak * 8000;
        }
        return tarif;
    }
    public static double hitungDiskon(double tarif, String metodePembayaran) {
        double diskon = 0;
        if (metodePembayaran.equalsIgnoreCase("GoPay")) {
            diskon = 0.1 * tarif;
        } else if (metodePembayaran.equalsIgnoreCase("OVO")) {
            diskon = 0.05 * tarif;
        } else if(metodePembayaran.equalsIgnoreCase("fastpay")){
            diskon = 0.3 * tarif;
        }
        return diskon;
    }
}