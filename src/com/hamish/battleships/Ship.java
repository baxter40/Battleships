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
     * Constructor. Gets a {@link com.hamish.battleships.Ship#length length} and assigns this and then sets
     * {@link com.hamish.battleships.Ship#health health} to the same as
     * {@link com.hamish.battleships.Ship#length length}
     *
     * @param length The length of the ship
     */
    public Ship(int length) {
        this.length = length;
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

}
