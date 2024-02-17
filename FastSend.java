import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class FastSend{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] NamaDriver = {"fatir", "ivan", "ariel", "radit", "desta", "albab", "faiz", "wahyu"};
        int n = NamaDriver.length;
        int indeksAcak = (int) (Math.random() * n);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00", symbols);
        System.out.println("===========================|Fast--Send|===========================");
        System.out.printf("%-40s %s","Masukkan Berat Barang (Kg)",": ");
        float berat = in.nextInt();
        subborder();
        double harga = hargatarif(berat);
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Opsi Pembayaran","Diskon %", "Harga");
        System.out.printf("| %-15s | %-8s | %-15s |\n", "","", "(Setelah %)");
        subborder();
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Fast-Pay","30%",df.format(harga*0.7));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Gopay","10%", df.format(harga*0.9));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "OVO","5%", df.format(harga*0.95));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Cash","-", df.format(harga));
        subborder();
        System.out.printf("%-40s %s","Masukkan Opsi Pembayaran",": ");
        in.nextLine();
        String pembayaran = in.nextLine();
        double total = hitunghargaDiskon(harga, pembayaran);
        border();
        System.out.printf("%-40s %s\n","Total pembayaran",": " + df.format(total));
        border();
        System.out.println("Selamat, anda berhasil memesan layanan Fast-Send dengan");
        System.out.println("tarif sebesar "+df.format(total)+". Tunggu Driver mas "+ NamaDriver[indeksAcak]+" tiba yaa!!");
        border();
    }
    public static int hargatarif(float berat){
        int harga =0;
        if(berat<=2){
            harga = 15000;
        } else if(2<berat && berat<=5){
            harga=20000;
        } else if(5<berat&& berat<=10){
            harga = 30000;
        } else{
            harga = (int)berat*8000;
        }
        return harga;
    }
    public static double hitunghargaDiskon(double tarif, String metodePembayaran) {
        double hargadiskon = 0;
        if (metodePembayaran.equalsIgnoreCase("GoPay")) {
            hargadiskon = 0.9 * tarif;
        } else if (metodePembayaran.equalsIgnoreCase("OVO")) {
            hargadiskon = 0.95 * tarif;
        } else if(metodePembayaran.equalsIgnoreCase("fastpay")){
            hargadiskon = 0.7 * tarif;
        } else if(metodePembayaran.equalsIgnoreCase("cash")){
            hargadiskon =tarif;
        }
        return hargadiskon;
    }
    public static void subborder() {
        System.out.println("------------------------------------------------");
    }
    public static void border() {
        System.out.println("==================================================================");
    }
}
