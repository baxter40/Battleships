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
        boards[0] = new GameBoard('A');
        boards[1] = new GameBoard('D');
    }

    /**
     * Called to place the ships. Gets an x coordinate and y coordinate and direction, checks for errors then uses
     * {@link com.hamish.battleships.GameBoard#checkPositionClear(int, int, String, int)} to check to see if this is
     * available. If it isn't it loops. Then uses
     * {@link com.hamish.battleships.GameBoard#placeShip(int, int, String, int)} to put the ships on the board and
     * prints the board when done using {@link GameBoard#printBoard()}
     */
    private void placeShips() {
        Scanner systemIn = new Scanner(System.in);
        int x = 0, y = 0;
        String direction = "";
        boolean shipPlacement = false;

        System.out.println("Please place your ships with an x, y coordinate, i.e x,y and the a direction, either R for" +
                "right, or D for down");

        for (int i = 0; i < numShips; i++) {
            while (!shipPlacement) {

                System.out.println("Place ship of length " + ships[i].getLength());

                while (true) {
                    System.out.print("\nPlease enter x coordinate:\t");
                    try {
                        x = Integer.parseInt(systemIn.next()) - 1; //Takes one off to account for 0 counting
                    } catch (Exception e) {
                        System.err.print(e);
                    }
                    if (x >= 0 && x < 10)
                        break;
                }

                while (true) {
                    System.out.print("\nPlease enter the y coordinate:\t");
                    try {
                        y = Integer.parseInt(systemIn.next()) - 1; //Takes one off to account for 0 counting
                    } catch (Exception e) {
                        System.err.print(e);
                    }
                    if (y >= 0 && y < 10)
                        break;
                }

                while (true) {
                    System.out.print("\nPlease enter the direction:\t");
                    direction = systemIn.next();
                    direction.toUpperCase();
                    if (direction.equals("R") || direction.equals("D")) ;
                    break;
                }

                shipPlacement = boards[0].checkPositionClear(x, y, direction, ships[i].getLength());
                if (!shipPlacement) {
                    System.out.println("Position not clear, please choose a clear position");
                }

            }
            boards[0].placeShip(x, y, direction, ships[i].getLength());
            boards[0].printBoard();
            shipPlacement = false;
        }
    }
}
