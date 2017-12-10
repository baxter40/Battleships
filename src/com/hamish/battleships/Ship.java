package com.hamish.battleships;

/**
 * A class to store the ships, such as their {@link com.hamish.battleships.Ship#length length} and
 * {@link com.hamish.battleships.Ship#health health}
 */
public class Ship {

    /**
     * Int to store length of ship
     */
    private int length;

    /**
     * Int to store health of ship
     */
    private int health;

    /**
     * Used to store the coordinates of the ship at each position of its length, with 0 being col and 1 being row
     */
    private int[][] coordinates;

    /**
     * Constructor. Gets a {@link com.hamish.battleships.Ship#length length} and assigns this and then sets
     * {@link com.hamish.battleships.Ship#health health} to the same as
     * {@link com.hamish.battleships.Ship#length length}
     *
     * @param length The length of the ship
     */
    public Ship(int length) {
        this.length = length;
        coordinates = new int[length][2];
        health = length;
    }

    /**
     * Returns the {@link com.hamish.battleships.Ship#health health} of the ship
     *
     * @return Health of the ship
     */
    public int getHealth() {
        return health;
    }

    /**
     * Called when ship is hit, decrements {@link com.hamish.battleships.Ship#health health}
     */
    public void shipHit() {
        health--;
    }

    /**
     * Called to get length of the ship
     *
     * @return length of the ship
     */
    public int getLength() {
        return length;
    }

    public void setCoordinates(int startCol, int startRow, String direction) {
        int curCol = startCol;
        int curRow = startRow;
        if (direction.equalsIgnoreCase("r")) {
            for (int i = 0; i < length; i++) {
                coordinates[i][0] = curCol++;
                coordinates[i][1] = startRow;
            }
        } else if (direction.equalsIgnoreCase("d")) {
            for (int i = 0; i < length; i++) {
                coordinates[i][0] = startCol;
                coordinates[i][1] = curRow++;
            }
        }
    }

    public boolean shipInPosition(int col, int row) {
        for (int[] co : coordinates) {
            if (co[0] == col && co[1] == row)
                return true;
        }
        return false;
    }

}
