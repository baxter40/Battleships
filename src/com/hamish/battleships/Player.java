package com.hamish.battleships;

/**
 * A class to store everything the player needs, including {@link com.hamish.battleships.GameBoard game boards} and
 * {@link com.hamish.battleships.Ship}
 */
public class Player {

    /**
     * Creates an array of {@link com.hamish.battleships.GameBoard game board} of size 2
     */
    public GameBoard[] boards = new GameBoard[2];

    /**
     * Creates an array of {@link com.hamish.battleships.Ship ship}
     */
    private Ship[] ships;

    /**
     * To store the name of the player
     */
    private String name;

    /**
     * Stores the number of {@link com.hamish.battleships.Ship ships} remaining
     */
    private int numShips;

    /**
     * Constructor. Gets the name of players and number of starting ships and assigns these. Then runs
     * {@link Player#createShips() createShips} and {@link Player#assignBoardTypes()}
     *
     * @param name             Name of the player
     * @param startingNumShips Number of ships the player starts with
     */
    public Player(String name, int startingNumShips) {
        this.name = name;
        this.numShips = startingNumShips;
        createShips();
        assignBoardTypes();
    }

    /**
     * Creates all of the {@link com.hamish.battleships.Ship ships}, increasing the size each time by one each time, 7
     * for the number of {@link com.hamish.battleships.Ship ships}
     */
    private void createShips() {
        ships = new Ship[numShips];
        for (int i = 0; i < numShips; i++) {
            ships[i] = new Ship(i + 1);
        }
    }

    /**
     * Creates two {@link com.hamish.battleships.GameBoard game boards} one attack, and one defence
     */
    private void assignBoardTypes() {
        boards[0] = new GameBoard('A');
        boards[1] = new GameBoard('D');
    }
}
