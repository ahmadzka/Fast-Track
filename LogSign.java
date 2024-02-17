import java.util.Scanner;

public class LogSign{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] saldoarray = {1000000, 200000, 50000};
        String[] username = {"adzka", "syafiq", "ridwan"};
        String[] password = {"111004", "12345", "98765"};
        boolean isValid_LogIn, isValid_SignIn = false, isValid_Verification = false;
        String inputUsername, inputPassword;

        do {
            clearScreen();
            System.out.printf("===========================|FAST-TRACK|===========================\n");
            System.out.println("Silahkan log-in atau Sign-In terlebih dahulu");
            System.out.printf("\n%25s %20s\n", "Log-In", "Sign-in");
            border();
            System.out.print("Masukkan pilihanmu: ");
            String pilihan = in.nextLine();

            while (!(pilihan.equalsIgnoreCase("login")|| pilihan.equalsIgnoreCase("log in") || pilihan.equalsIgnoreCase("sign in") || pilihan.equalsIgnoreCase("signin"))) {
                System.out.print("Invalid input. Please try again : ");
                pilihan = in.nextLine();
            }

            if (pilihan.equalsIgnoreCase("login")|| pilihan.equalsIgnoreCase("log in")) {
                do {
                    System.out.printf("===========================|FAST-TRACK|===========================\n");
                    System.out.println("Silahkan masukkan username dan password akun anda");
                    System.out.print("Username: ");
                    inputUsername = in.nextLine();
                    System.out.print("Password: ");
                    inputPassword = in.nextLine();
                    isValid_LogIn = verification1(username, password, inputUsername, inputPassword);

                    if (isValid_LogIn) {
                        System.out.println("Login berhasil.");
                        isValid_Verification = true;
                        clearScreen();
                    } else {
                        System.out.println("Login gagal. Mungkin Username atau password yang kamu masukkan ");
                        System.out.println("salah. Silakan coba lagi yaa!!!.");
                        border();
                    }
                } while (!isValid_LogIn);
            } else if (pilihan.equalsIgnoreCase("sign in") || pilihan.equalsIgnoreCase("signin")) {
                do {
                    System.out.printf("===========================|FAST-TRACK|===========================\n");
                    System.out.println("Silahkan masukkan username dan password akun anda");
                    System.out.print("Username: ");
                    inputUsername = in.nextLine();
                    System.out.print("Password: ");
                    inputPassword = in.nextLine();
                    isValid_SignIn = verification1(username, password, inputUsername, inputPassword);
                    if (isValid_SignIn) {
                        System.out.println("Sign-In gagal. Username atau password sudah digunakan. Silakan coba lagi yaa!!!.");
                        border();
                    } else {
                        System.out.println("Sign-In berhasil.");
                        isValid_Verification = true;
                        username = appendArrayStrings(username, inputUsername);
                        password = appendArrayStrings(password, inputPassword);
                        clearScreen();
                    }
                } while (isValid_SignIn);
            }
        } while (!isValid_Verification);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Border
    public static void border() {
        System.out.println("==================================================================");
    }

    public static boolean verification1(String[] usernames, String[] passwords, String inputUsername, String inputPassword) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }

    public static String[] appendArrayStrings(String[] a, String b) {
        String[] decoy = new String[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            decoy[i] = a[i];
        }
        decoy[a.length] = b;
        a = decoy;
        return a;
    }
}
