import java.util.Scanner;
public class FastPay {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String[] username = {"adzka", "syafiq", "ridwan"};
        String[] password = {"111004", "12345", "98765"};
        int saldo=1000000;//<---jangan lupa dihapus
        boolean IsValidMenuFastPay = false;
        do{
        System.out.printf("==================================================================\n");
        System.out.println("Total saldo: Rp." +saldo);
            System.out.println("");
            System.out.println("1) Top-Up");
            System.out.println("2) Pay/Transfer");
            System.out.print("Pilih Menu: ");
            int MenuFastPay = in.nextInt();
            System.out.printf("==================================================================\n");
            in.nextLine();
            switch (MenuFastPay){
                case 1 ->{
                    System.out.println("Pilih nominal Top-Up:");
                    System.out.printf("| %-16s| %-16s|\n","1) Rp. 5.000", "4) Rp. 50.000");
                    System.out.printf("| %-16s| %-16s|\n","2) Rp. 10.000", "5) Rp. 100.000");
                    System.out.printf("| %-16s| %-16s|\n","3) Rp. 25.000", "6) Rp. 200.000");
                    System.out.printf("Nominal lain: ");
                    int nominal = in.nextInt();
                    System.out.printf("==================================================================\n");
                    boolean IsValidFastTopUp = false;
                    in.nextLine();
                    do{
                        System.out.println("Verifikasi akun");
                        System.out.print("Username: ");
                        String inputusername = in.nextLine();
                        System.out.print("Password: ");
                        String inputpassword = in.nextLine();
                        IsValidFastTopUp = verification(username, password, inputusername, inputpassword);
                        System.out.println("");
                        if (IsValidFastTopUp) {
                            System.out.println("Verifikasi berhasil!!!");
                            saldo += nominal;
                            System.out.println("Selamat anda berhasi top up sebesar Rp."+nominal+". Saldo gopay anda sekarang adalah Rp. "+saldo);
                            System.out.printf("==================================================================\n");
                            System.out.println("9) Kembali");
                            System.out.println("0) Home");
                            System.out.print("Pilih menu: ");
                            int menuhome = in.nextInt();
                            if(menuhome==0){
                                IsValidMenuFastPay = true;
                            }
                        } else {
                            System.out.println("Verifikasi gagal!!!");
                            System.out.println("Silahkan Verifikasi kembali");
                            System.out.printf("==================================================================\n");
                        }
                    } while(!IsValidFastTopUp);
                    break;
                }
                case 2 ->{
                    System.out.print("Nama penerima: ");
                    String NamaPenerima = in.nextLine();
                    System.out.println("Pilih nominal yang akan dibayar:");
                    System.out.printf("| %-16s| %-16s|\n","1) Rp. 5.000", "4) Rp. 50.000");
                    System.out.printf("| %-16s| %-16s|\n","2) Rp. 10.000", "5) Rp. 100.000");
                    System.out.printf("| %-16s| %-16s|\n","3) Rp. 25.000", "6) Rp. 200.000");
                    System.out.printf("Nominal lain: ");
                    int nominal = in.nextInt();
                    System.out.printf("==================================================================\n");
                    boolean IsValidFastPay = false;
                    in.nextLine();
                    do{
                        System.out.println("Verifikasi akun");
                        System.out.print("Username: ");
                        String inputusername = in.nextLine();
                        System.out.print("Password: ");
                        String inputpassword = in.nextLine();
                        IsValidFastPay = verification(username, password, inputusername, inputpassword);
                        System.out.println("");
                        if (IsValidFastPay) {
                            System.out.println("Verifikasi berhasil!!!");
                            saldo += nominal;
                            System.out.println("Selamat anda berhasi membayar sebesar Rp."+nominal+" kepada "+NamaPenerima);
                            System.out.println("Saldo gopay anda sekarang adalah Rp. "+saldo);
                            System.out.printf("==================================================================\n");
                            System.out.println("9) Kembali");
                            System.out.println("0) Home");
                            System.out.print("Pilih menu: ");
                            int menuhome = in.nextInt();
                            if(menuhome==0){
                                IsValidMenuFastPay = true;
                            }
                        } else {
                            System.out.println("Verifikasi gagal!!!");
                            System.out.println("Silahkan Verifikasi kembali");
                            System.out.printf("==================================================================\n");
                        }
                    } while(!IsValidFastPay);
                    break;
                }
                default ->{
                    System.out.println("Silahkan masukkan pilihan yang sesuai dengan menu yang ada");
                }
            }
        } while(!IsValidMenuFastPay);
        in.close();
    }

    public static boolean verification(String[] username, String[] password, String inputusername, String inputpassword) {
        for (int i = 0; i < username.length; i++) {
            if (username[i].equals(inputusername) && password[i].equals(inputpassword)) {
                return true;
            }
        }
        return false;
    }
}
