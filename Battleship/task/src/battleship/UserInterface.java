package battleship;

import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private boolean endLoop;
    private BattleShip board;

    public UserInterface(BattleShip board) {
        this.board = board;
    }

    Scanner sc = new Scanner(System.in);

    public void start() {
        board.fillBoard();
        board.printBoard();
        for (Ships s : Ships.values()) {
            System.out.print("Enter the coordinates of the " + s.getType() + " (" + s.getSize() + " cells):");
            do {
                String[] coordinates = sc.nextLine().split(" ");
                int firstL = coordinates[0].charAt(0) - 65;
                int firstN = Integer.parseInt(coordinates[0].substring(1));
                int secondL = coordinates[1].charAt(0) - 65;
                int secondN = Integer.parseInt(coordinates[1].substring(1));

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
        startBattle();
    }
    public void startBattle() {
        System.out.println("The game starts!");
        System.out.println();
        board.printFogOfWar();
        System.out.println();
        System.out.println("Take a shot!");
        do {
            String coordinates = sc.nextLine();
            int firstLetter = coordinates.charAt(0) - 65;
            int firstNumber = Integer.parseInt(coordinates.substring(1));
            if (firstLetter > 10 || firstNumber > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                endLoop = true;
            } else {
                board.hitOrMiss(firstLetter, firstNumber - 1);
                board.printFogOfWar();
                endLoop = false;
            }
            if(board.endGame()){
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            if (board.missedShot()) {
                System.out.println("You missed! Try again:");
                board.printFogOfWar();
                endLoop = true;
            } else if (board.hitShot()) {
                System.out.println("You hit a ship! Try again:");
                endLoop = true;
            }


        } while (endLoop);


    }
}