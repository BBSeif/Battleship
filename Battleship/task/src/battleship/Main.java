package battleship;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        BattleShip battleShip = new BattleShip();
        showMenu(battleShip);
    }

    /**
     * Outputs the sea and allows user to add coordinates for each ship.
     *
     * @param battleShip BattleShip to be played
     */
    static void showMenu(BattleShip battleShip) {
        battleShip.printSea();
        battleShip.setAircraftCarrier();
        battleShip.printSea();
        battleShip.setBattleship();
        battleShip.printSea();
        battleShip.setSubmarine();
        battleShip.printSea();
        battleShip.setCruiser();
        battleShip.printSea();
        battleShip.setDestroyer();
        battleShip.printSea();
    }

    /**
     * User inputs the ship's coordinates.
     *
     * @return returns the coordinates
     */
    static String[] inputShip() {
        Scanner scanner = new Scanner(System.in);
        return new String[] {scanner.next(), scanner.next()};
    }
}

/**
 * BattleShip is the class to play the game Battleships
 */
class BattleShip {
    private char[][] sea;
    private int i1;
    private int j1;
    private int i2;
    private int j2;
    private String ship;
    private String cells;
    final static String ALPHABET = "ABCDEFGHIJ";

    /**
     * Creates the default sea by calling the method setSea
     */
    BattleShip() {
        setSea();
    }

    void setSea() {
        // Creates default sea
        this.sea = new char[10][10];
        for (char[] row : this.sea) {
            Arrays.fill(row, '~');
        }
    }

    /**
     * Prints the sea with any ships that have been added
     */
    void printSea() {
        // Prints the top row of numbers
        System.out.print(" ");
        for (int j = 1; j <= sea.length; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        // Prints each row. The rows are labelled A to J.
        char letter = 'A';
        for (char[] row : sea) {
            System.out.print(letter++ + " ");
            for (int j = 0; j < sea.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Adds the coordinates for the Aircraft Carrier to the sea.
     */
    void setAircraftCarrier() {
        ship = "Aircraft Carrier";
        cells = "5";
        checkShip();
    }

    /**
     * Adds the coordinates for the Battleship to the sea.
     */
    void setBattleship() {
        ship = "Battleship";
        cells = "4";
        checkShip();
    }

    /**
     * Adds the coordinates for the Submarine to the sea.
     */
    void setSubmarine() {
        ship = "Submarine";
        cells = "3";
        checkShip();
    }

    /**
     * Adds the coordinates for the Cruiser to the sea.
     */
    void setCruiser() {
        ship = "Cruiser";
        cells = "3";
        checkShip();
    }

    /**
     * Adds the coordinates for the Destroyer to the sea.
     */
    void setDestroyer() {
        ship = "Destroyer";
        cells = "2";
        checkShip();
    }

    /**
     * Inputs the coordinates and checks if the coordinates are valid.
     * If valid, then ships are added to the sea.
     *
     * @exception RuntimeException If RuntimeException has been thrown by extractCoordinates method
     */
    private void checkShip() {
        System.out.printf("Enter the coordinates of the %s (%s cells): ", ship, cells);
        boolean correct = false;

        while (!correct) {
            // Inputs coordinates
            String[] coordinates = Main.inputShip();
            try {
                if (coordinates.length != 2) {
                    System.out.print("Error! The coordinates are in the incorrect format! Try again: ");
                    continue;
                }
                extractCoordinates(coordinates);
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
                continue;
            }
            // Checks for if ship is either horizontal or vertical, has correct length and
            // if there are any ships nearby
            correct = checkShipOrientation() && checkShipLength() && checkShipsNearby();

            if (correct) {
                addShipToSea();
            }
        }
    }

    /**
     * Extracts the coordinates from the input.
     *
     * @param coordinates String[] which stores the coordinates from the input
     * @throws RuntimeException If coordinates are in the incorrect format.
     */
    private void extractCoordinates(String[] coordinates) {
        // Represents the row letter position of the 1st coordinate in reference to the char[][] sea field
        i1 = ALPHABET.indexOf(coordinates[0].charAt(0));
        // Represents the column number position of the 1st coordinate in reference to the char[][] sea field
        j1 = Integer.parseInt(coordinates[0].substring(1)) - 1;
        // Represents the row letter position of the 2nd coordinate in reference to the char[][] sea field
        i2 = ALPHABET.indexOf(coordinates[1].charAt(0));
        // Represents the column number position of the 2nd coordinate in reference to the char[][] sea field
        j2 = Integer.parseInt(coordinates[1].substring(1)) - 1;

        // Orders the coordinates in ascending order
        int temp = i1;
        if (i1 > i2) {
            i1 = i2;
            i2 = temp;
        }

        temp = j1;
        if (j1 > j2) {
            j1 = j2;
            j2 = temp;
        }

        if (i1 == -1 || i2 == -1) {
            throw new RuntimeException("Error! Enter the row letters in the correct format: ");
        } else if (j1 < 0 || j1 > 9 || j2 > 9) {
            throw new RuntimeException("Error! Ensure the column number is between 1 and 10: ");
        }
    }

    /**
     * Checks the ship's orientation.
     *
     * @return returns whether ship is vertical or horizontal (true) or not (false)
     */
    private boolean checkShipOrientation() {
        if (i1 != i2 && j1 != j2) {
            System.out.print("Error! Wrong ship location! Try again: ");
            return false;
        }
        return true;
    }

    /**
     * Checks the user has provided coordinates with the appropriate length for the ship.
     * It calculates the length of the ship from the coordinates inputted.
     *
     * @return returns whether user has provided the correct length (true) or the wrong length (false)
     */
    private boolean checkShipLength() {
        int lengthShip = Math.max((Math.abs(j2 - j1) + 1), Math.abs((i2 - i1) + 1));
        if (!Objects.equals(String.valueOf(lengthShip), cells)) {
            System.out.printf("Error! Wrong length of the %s! It should be length %s. Try again: ", ship, cells);
            return false;
        }
        return true;
    }

    /**
     * Checks the user has provided coordinates with does not cross or touch other ships.
     *
     * @return returns whether user has provided the correct coordinates (true) or the wrong coordinates (false)
     */
    private boolean checkShipsNearby() {
        // Loops through each surrounding row of the ship
        for (int i = i1 - 1; i <= i2 + 1; i++) {
            // Loops through each surrounding column of the ship
            for (int j = j1 - 1; j <= j2 + 1; j++) {
                // Ensures surrounding cells are within array
                if (i >= 0 && i < sea.length && j >= 0 && j < sea.length) {
                    if (sea[i][j] == 'O') {
                        System.out.print("Error! You placed it too close to another one. Try again: ");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Adds the ship denoted by 'O' to the sea
     */
    private void addShipToSea() {
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                sea[i][j] = 'O';
            }
        }
    }
}