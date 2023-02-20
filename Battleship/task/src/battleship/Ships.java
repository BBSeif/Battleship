package battleship;

public enum Ships {
    CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);
    int size;
    String type;

    Ships(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

}