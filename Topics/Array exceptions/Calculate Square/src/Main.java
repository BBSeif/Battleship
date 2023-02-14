class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        try {
            int a = array[index] * array[index];
            System.out.println(a);
        } catch (NullPointerException e) {
            System.out.println("Exception!");
        }

    }
}

public class Main {
    public static void main(String[] args) {
        FixingExceptions a = new FixingExceptions();

        int[] b = {1,2,3,4,5,6,7,8};
        int index = 4;


    }
}