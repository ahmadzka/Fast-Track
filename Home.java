import java.util.Scanner;
public class Home {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=========|Selamat Datang di Aplikasi Kami|=========");
        System.out.println("=====|Silahkan Masukkan Password dan Username|=====");
        System.out.printf("%30s : ", "Username");
        String username = in.nextLine();
        System.out.printf("%30s :", "Password");
        String password = in.nextLine();
        System.out.println("");
        int[] userdata = new int[5];
    }
}
