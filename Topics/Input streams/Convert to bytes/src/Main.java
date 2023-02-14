import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //Reader reader = new FileReader();


//        char first = (char) reader.read(); // i
//        char second = (char) reader.read(); // n

//        char[] others = new char[12];
//        int number = reader.read(others); // 10
//        System.out.println(others);

        int charAsNumber = inputStream.read();
        while(charAsNumber != -1) {
            char character = (char) charAsNumber;
            System.out.print(charAsNumber);
            charAsNumber = inputStream.read();

        }
        //reader.close();
    }
}