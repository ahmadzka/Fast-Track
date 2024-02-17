import java.util.Scanner;

public class Verification{
    public static void main(String[] args) {
        // Inisialisasi array untuk menyimpan username dan password
        String[] usernames = {"adzka", "syafiq", "ridwan"};
        String[] passwords = {"111004", "12345", "98765"};

        // Menggunakan Scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);

        boolean isValid = false;

        // Loop do-while untuk terus meminta input sampai verifikasi berhasil
        do {
            // Menerima input username dan password dari pengguna
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            // Memanggil metode verification untuk memeriksa kecocokan
            isValid = verification(usernames, passwords, inputUsername, inputPassword);

            // Menampilkan hasil verifikasi
            if (isValid) {
                System.out.println("Verifikasi berhasil. Selamat datang, " + inputUsername + "!");
            } else {
                System.out.println("Verifikasi gagal. Username atau password salah. Silakan coba lagi.");
            }
        } while (!isValid); // Loop sampai verifikasi berhasil
    }

    // Metode untuk melakukan verifikasi
    public static boolean verification(String[] usernames, String[] passwords, String inputUsername, String inputPassword) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                return true; // Username dan password cocok
            }
        }
        return false; // Tidak ada kecocokan
    }
}
