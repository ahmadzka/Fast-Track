import java.util.Scanner;

public class Verification2{
    public static void main(String[] args) {
        // Inisialisasi array untuk menyimpan username dan password
        String[] username = {"adzka", "syafiq", "ridwan"};
        String[] password = {"111004", "12345", "98765"};

        // Menggunakan Scanner untuk menerima input dari pengguna
        Scanner in = new Scanner(System.in);

        boolean isValid;
        String verifiedPassword = null;

        // Loop do-while untuk terus meminta input sampai verifikasi berhasil
        do {
            // Menerima input username dan password dari pengguna
            System.out.print("Masukkan username: ");
            String inputUsername = in.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = in.nextLine();

            // Memanggil metode verification1 untuk memeriksa kecocokan
            isValid = verification1(username, password, inputUsername, inputPassword);

            // Menampilkan hasil verifikasi
            if (isValid) {
                verifiedPassword = inputPassword;
                System.out.println("Verifikasi 1 berhasil. Selamat datang, " + inputUsername + "!");
            } else {
                System.out.println("Verifikasi 1 gagal. Username atau password salah. Silakan coba lagi.");
            }
        } while (!isValid); // Loop sampai verifikasi 1 berhasil

        // Verifikasi kedua menggunakan username dan password yang telah diverifikasi pada verifikasi pertama
        do {
            System.out.print("Masukkan password (Verifikasi 2): ");
            String inputPassword = in.nextLine();

            // Memanggil metode verification2 untuk memeriksa kecocokan
            isValid = verification2(verifiedPassword, inputPassword);

            // Menampilkan hasil verifikasi
            if (isValid) {
                System.out.println("Verifikasi 2 berhasil");
            } else {
                System.out.println("Verifikasi 2 gagal. Password salah. Silakan coba lagi.");
            }
        } while (!isValid); // Loop sampai verifikasi 2 berhasil

        in.close();
    }

    // Metode untuk melakukan verifikasi 1
    public static boolean verification1(String[] usernames, String[] passwords, String inputUsername, String inputPassword) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                return true; // Username dan password cocok
            }
        }
        return false; // Tidak ada kecocokan
    }

    // Metode untuk melakukan verifikasi 2
    public static boolean verification2(String verifiedPassword, String inputPassword) {
        // Memeriksa kecocokan password
        return verifiedPassword.equals(inputPassword);
    }
}
