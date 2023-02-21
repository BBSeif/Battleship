package battleship;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BattleShip battle = new BattleShip();
        BattleShip battle2 = new BattleShip();
        UserInterface ui = new UserInterface(battle);
        UserInterface ui2 = new UserInterface(battle2);
        System.out.println("Player 1, place your ships on the game field");
        ui.start();
        System.out.println();
        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field");
        System.out.println();
        ui2.start();
        promptEnterKey();
       while (UserInterface.end) {
           System.out.println();
           battle2.printFogOfWar();
           System.out.println("---------------------");
           battle.printBoard();
           System.out.println();
           ui2.startBattle("Player 1");
           promptEnterKey();
            System.out.println();
            battle.printFogOfWar();
            System.out.println("---------------------");
            battle2.printBoard();
            System.out.println();
           ui.startBattle("Player 2");
           promptEnterKey();

       }


    }
    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}