package battleship;

public class Main {

    public static void main(String[] args) {
        BattleShip battle = new BattleShip();
        UserInterface ui = new UserInterface(battle);
        ui.start();
    }
}