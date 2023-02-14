package battleship;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        char[][] table = {{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'},{'~','~','~','~','~','~','~','~','~','~'}};
        char[][] tabel2 = table;
        map(table);
        int i = 5;
        while (i > 1) {
            table = check(table,input(),i);
            if (table != tabel2) {
                map(table);
                tabel2 = table;
                i--;
            }
        }
    }

    public static int[] input() {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");

        String st1 = str[0].replaceAll("[^A-Za-z]", "");
        String st2 = str[0].replaceAll("[^0-9]", "");
        String st3 = str[1].replaceAll("[^A-Za-z]", "");
        String st4 = str[1].replaceAll("[^0-9]", "");

        int[] num = new int[4];
        num[0] = st1.charAt(0) - 65;
        num[1] = Integer.parseInt(st2) -1;
        num[2] = st3.charAt(0) - 65;
        num[3] = Integer.parseInt(st4) -1;
        return num;
    }

    public static char[][] check(char [][] table, int[] in, int n)  {
        boolean checker = true;
        if (in[0] == in[2] || in[1] == in[3]) {
            if (in[0] == in[2]) {
                if (abs(in[1] - in[3]) == n-1) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < n+1; j++) {
                            if (table[in[0]+i][in[1]+j] == 'O') {
                                checker = false;
                            }
                        }
                    }
                    if (checker) {
                        for (int i = 0; i < n; i++) {
                            table[in[0]][in[1]+i] = 'O';
                        }
                        map(table);
                    }
                } else {
                    System.out.println("ERROR1");
                }
            } else {
                if (abs(in[0] - in[2]) == n-1) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < n+1; j++) {
                            if (table[in[0]+j][in[1]+i] == 'O') {
                                checker = false;
                        }
                    }
                }
                    if (checker) {
                        for (int i = 0; i < n; i++) {
                            table[in[0]+i][in[1]] = 'O';
                        }
                        map(table);
                    }

                } else {
                    System.out.println("ERROR2");
                }
            }
        } else {
            System.out.println("ERROR3");
        }
        //map(table);
        return table;
    }

    public static void map(char[][] table) {


        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char letter = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(letter);
            for (int j = 0; j < 10; j++) {
                System.out.print(" ");
                System.out.print(table[i][j]);
            }
            System.out.println();
            int next = (int) letter +1;
            letter = (char) next;
        }
    }
}
