import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new File("/Users/bekesh/Downloads/h.txt"))) {
            int f1 = sc.nextInt();
            float f2 = sc.nextFloat();
            System.out.println("argument:" + f1 + " " +f2);
        }
    }
}