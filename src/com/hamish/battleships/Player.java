package com.hamish.battleships;

import java.util.Scanner;

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
     * Stores char used to show ship
     */
    private final static char SHIP = '*';

    /**
     * Char to make code more readable
     */
    private final static char HIT = 'H';

    /**
     * Char to make code more readable
     */
    private final static char MISS = 'M';

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
        placeShips();
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
        boards[0] = new GameBoard('D');
        boards[1] = new GameBoard('A');
    }

    /**
     * Called to place the ships. Gets an x coordinate and y coordinate using {@link #getCoordinate()} and direction,
     * and checks to make sure that this position is on the board. It then checks for errors then uses
     * {@link com.hamish.battleships.GameBoard#checkPositionClear(int, int, String, int)} to check to see if this is
     * available. If it isn't it loops. Then uses
     * {@link com.hamish.battleships.GameBoard#placeShip(int, int, String, int)} to put the ships on the board and
     * prints the board when done using {@link GameBoard#printBoard()}
     */
    private void placeShips() {
        Scanner systemIn = new Scanner(System.in);
        int col, row;
        String direction;
        boolean shipPlacement;

        System.out.println("Please place your ships with an column and row and the a direction, either R for" +
                "right, or D for down");

        for (Ship ship : ships) {
            shipPlacement = false;
            while (!shipPlacement) {

                System.out.println("Place ship of length " + ship.getLength());

                col = -1;
                while (col < 0 || col >= 10) {
                    col = getValue("column");
                }

                row = -1;
                while (row < 0 || row >= 10) {
                    row = getValue("row");
                }

                while (true) {
                    System.out.print("\nPlease enter the direction:\t");
                    direction = systemIn.next();
                    if (direction.equalsIgnoreCase("R") || direction.equalsIgnoreCase("D"))
                        break;
                    else
                        System.out.println("Please enter a valid option of either 'R' or 'D'");
                }


                if (checkPositionValid(col, row, ship.getLength(), direction)) {
                    if (boards[0].checkPositionClear(col, row, direction, ship.getLength())) {
                        boards[0].placeShip(col, row, direction, ship.getLength());
                        ship.setCoordinates(col, row, direction);
                        boards[0].printBoard();
                        shipPlacement = true;
                    } else {
                        System.out.println("Position not clear, please choose a clear position");
                        shipPlacement = false;
                    }
                } else
                    shipPlacement = false;
            }
        }
    }

    /**
     * Gets and int value from an input and then passes it back
     *
     * @return int value of input
     */
    private int getCoordinate() {
        int value = -1;
        Scanner systemIn = new Scanner(System.in);
        try {
            value = Integer.parseInt(systemIn.next()) - 1; //Takes one off to account for 0 counting
        } catch (Exception e) {
            System.out.println("Please enter a valid option between 1 and 10");
            //System.err.print(e);
        }
        if (value < 0 || value >= 10) {
            System.out.println("Please entHer a valid option between 1 and 10");
        }

        return value;
    }

    /**
     * Returns a boolean if a ship can be placed in the position provided and direction.
     *
     * @param col        column to be checked
     * @param row        row to be checked
     * @param shipLength the length of the ship
     * @param direction  the direction to be placed
     * @return a boolean if the ship can be entered in this position
     */
    private boolean checkPositionValid(int col, int row, int shipLength, String direction) {
        if (direction.equalsIgnoreCase("D")) {
            if (row + shipLength > 10) {
                System.out.println("Please enter an option that keeps the ship on the board!");
                return false;
            } else
                return true;
        } else {
            if (col + shipLength > 10) {
                System.out.println("Please enter an option that keeps the ship on the board!");
                return false;
            } else
                return true;
        }
    }

    public boolean shipLeft() {
        for (Ship ship : ships) {
            if (ship.getHealth() > 0)
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int[] playerGo() {
        int[] coord = new int[2];
        System.out.println(getName() + " to go!");
        boards[1].printBoard();

        coord[0] = getValue("column");
        coord[1] = getValue("row");

        return coord;
    }

    private int getValue(String output) {
        System.out.print("\nEnter the " + output + ":\t");
        return getCoordinate();
    }

    public boolean positionTaken(int col, int row) {
        return boards[0].getPosition(col, row) == SHIP;
    }

    public void attackHit(int col, int row) {
        for (Ship sh : ships) {
            if (sh.shipInPosition(col, row)) {
                sh.shipHit();
                if (sh.getHealth() < 1) {
                    System.out.println("Ship sunk!");
                }
            }
        }
        boards[1].setPosition(HIT, col, row);
        boards[1].printBoard();
    }

    public void attackMissed(int col, int row) {
        boards[1].setPosition(MISS, col, row);
        boards[1].printBoard();
    }


}
