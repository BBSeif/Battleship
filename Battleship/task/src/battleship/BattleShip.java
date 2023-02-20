package battleship;


public class BattleShip {
    private int sizeCounter;
    private boolean isClose;
    public final char[][] field = new char[10][10];
    private char row = 'A';
    private boolean miss;
    private boolean hit;
    private int hitCounter;

    public BattleShip() {
    }

    public void fillBoard() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = '~';
            }
        }
    }

    public boolean isClose(int firstL, int firstN, int secondL, int secondN) {
        for (int i = firstL; i <= secondL - 1; i++) {
            for (int j = firstN; j < secondN - 1; j++) {
                if (field[i][j] == 'O' || field[i + 1][j] == 'O' ||
                        field[i - 1][j] == 'O' || field[i][j + 1] == 'O'
                        || field[i][j - 1] == 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    public void addShips(int firstL, int firstN, int secondL, int secondN) {
        if (secondN < firstN) {
            for (int i = firstL; i <= secondL; i++) {
                for (int j = secondN - 1; j < firstN; j++) {
                    field[i][j] = 'O';
                }
            }
        } else {
            for (int i = firstL; i <= secondL; i++) {
                for (int j = firstN - 1; j < secondN; j++) {
                    field[i][j] = 'O';
                }
            }
        }

    }

    public int getSizeCounter(int firstL, int firstN, int secondL, int secondN) {
        this.sizeCounter = 0;
        if (secondN < firstN) {
            for (int i = firstL; i <= secondL; i++) {
                for (int j = secondN - 1; j < firstN; j++) {
                    this.sizeCounter++;
                }
            }
        } else {
            for (int i = firstL; i <= secondL; i++) {
                for (int j = firstN - 1; j < secondN; j++) {
                    this.sizeCounter++;
                }
            }
        }
        return this.sizeCounter;
    }

    public void hitOrMiss(int first, int second) {
        for (int i = 0; i <= field.length - 1; i++) {
            for (int j = 0; j < field[0].length - 1; j++) {
                if (field[first][second] == 'O') {
                    field[first][second] = 'X';
                    hit = true;
                    this.hitCounter++;
                    break;
                }
                if (field[first][second] == '~') {
                    field[first][second] = 'M';
                    miss = true;
                    break;
                }
            }
        }
    }

    public boolean endGame() {
        if(this.hitCounter==17){
            return true;
        }
        return false;

    }

    public boolean missedShot() {
        if (miss) {
            return true;
        }
        return false;
    }

    public boolean hitShot() {
        if (hit) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10 ");
        row = 'A';
        for (char[] chars : field) {
            System.out.print(row++ + " ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }


    public void printFogOfWar() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10 ");
        row = 'A';
        for (char[] chars : field) {
            System.out.print(row++ + " ");

            for (char aChar : chars) {
                if (aChar == 'O') {
                    System.out.print('~' + " ");
                } else {
                    System.out.print(aChar + " ");
                }
            }
            System.out.println();

        }


    }
}