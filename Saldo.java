import java.util.Scanner;
public class Saldo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] saldoarray = {1000000, 200000, 50000};
        String[] username = {"adzka", "syafiq", "ridwan"};
        String[] password = {"111004", "12345", "98765"};
        boolean isValid;
        String verifiedPassword = null;
        String inputUsername, inputPassword;
        do {
            System.out.print("Masukkan username: ");
            inputUsername = in.nextLine();
            System.out.print("Masukkan password: ");
            inputPassword = in.nextLine();
            isValid = verification1(username, password, inputUsername, inputPassword);
            if (isValid) {
                verifiedPassword = inputPassword;
                System.out.println("Verifikasi 1 berhasil. Selamat datang, " + inputUsername + "!");
            } else {
                System.out.println("Verifikasi 1 gagal. Username atau password salah. Silakan coba lagi.");
            }
        } while (!isValid); // Loop sampai verifikasi 1 berhasil
        int saldo = verifySaldo(username, password, inputUsername, inputPassword, saldoarray);
        System.out.println("Saldomu : Rp."+ saldo);
        do {
            System.out.print("Masukkan password (Verifikasi 2): ");
            inputPassword = in.nextLine();
            isValid = verification2(verifiedPassword, inputPassword);
            if (isValid) {
                System.out.println("Verifikasi 2 berhasil");
            } else {
                System.out.println("Verifikasi 2 gagal. Password salah. Silakan coba lagi.");
            }
        } while (!isValid); // Loop sampai verifikasi 2 berhasil
        in.close();
    }
    public static boolean verification1(String[] usernames, String[] passwords, String inputUsername, String inputPassword) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                return true; // Username dan password cocok
            }
        }
        return false; // Tidak ada kecocokan
    }
    public static boolean verification2(String verifiedPassword, String inputPassword) {
        return verifiedPassword.equals(inputPassword);
    }
    public static int verifySaldo(String[] usernames, String[] passwords, String inputUsername, String inputPassword, int[] saldoarray) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                int saldo = saldoarray[i];
                return saldo;
            }
        }
        return -1;
    }
}

