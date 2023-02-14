import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int unit = scanner.nextInt();
        if (unit < 1) {
            System.out.println("no army");
        } else if (unit >= 1 && unit <= 19) {
            System.out.println("pack");
        } else if (unit >= 20 && unit <= 249) {
            System.out.println("throng");
        } else if (unit >= 250 && unit <= 999) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}