package battleship;

import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private boolean endLoop;
    private BattleShip board;

    public UserInterface(BattleShip board) {
        this.board = board;
    }
    protected static boolean end = true;
    Scanner sc = new Scanner(System.in);

    public void start() {
        board.fillBoard();
        board.printBoard();
        for (Ships s : Ships.values()) {
            System.out.print("\nEnter the coordinates of the " + s.getType() + " (" + s.getSize() + " cells):\n");
            do {
                    String[] coordinates = sc.nextLine().split(" ");
                int firstL = coordinates[0].charAt(0) - 65;
                int firstN = Integer.parseInt(coordinates[0].substring(1));
                int secondL = coordinates[1].charAt(0) - 65;
                int secondN = Integer.parseInt(coordinates[1].substring(1));

                int temp = firstL;
                if (firstL > secondL) {
                    firstL = secondL;
                    secondL = temp;
                }
                temp = firstN;
                if (firstN > secondN) {
                    firstN = secondN;
                    secondN = temp;
                }

                if (firstL != secondL && firstN != secondN) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    endLoop = true;
                } else if (board.getSizeCounter(firstL, firstN, secondL, secondN) != s.getSize()) {
                    endLoop = true;
                    System.out.println("Error! Wrong length of the " + s.getType() + "! Try again:");
                } else if (board.isClose(firstL, firstN, secondL, secondN)) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    endLoop = true;
                } else {
                    board.addShips(firstL, firstN, secondL, secondN);
                    board.printBoard();
                    endLoop = false;
                }

            } while (endLoop);

        }
    }







    public void startBattle(String name) {
        //System.out.println("The game starts!");
//        System.out.println();
//        board.printFogOfWar();
//        System.out.println("---------------------");
//        board.printBoard();
//        System.out.println();
        System.out.println(name + ", it's your turn:");
        //do {
            String coordinates = sc.nextLine();
            int firstLetter = coordinates.charAt(0) - 65;
            int firstNumber = Integer.parseInt(coordinates.substring(1));
            if (firstLetter > 10 || firstNumber > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                endLoop = true;
            } else {
                board.hitOrMiss(firstLetter, firstNumber - 1);
                //board.printFogOfWar();
                endLoop = false;
            }
            if(board.endGame()){
                System.out.println(name + "You sank the last ship. You won. Congratulations!");
                end = false;
            }
            if (board.missedShot()) {
                System.out.println("You missed!");
                //board.printFogOfWar();
                endLoop = true;
            } else if (board.hitShot()) {
                System.out.println("You hit a ship!");
                endLoop = true;
            }


        //} while (endLoop);
        //System.out.println("Press Enter and pass the move to another player");

    }
}