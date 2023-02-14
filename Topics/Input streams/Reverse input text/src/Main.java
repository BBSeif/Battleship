import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String b = new String();
        int a =  reader.read();
         while (a != -1) {
             b = (char) a + b;
             a =  reader.read();
         }
        System.out.println(b);
         reader.close();
    }
}