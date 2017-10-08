package com.hamish.battleships;

/**
 * Game board class that controls the boards and can pass information back to the boards
 */
public class GameBoard {

    /**
     * Array of chars that is the board
     */
    private char[][] board = new char[10][10];

    /**
     * A char to store the type of board it will be
     */
    private char boardType;

    /**
     * A char to make code more readable
     */
    private final char SHIP = '*';

    /**
     * The constructor. Takes in a char for {@link com.hamish.battleships.GameBoard#boardType board type} and assigns
     * this as the stored {@link com.hamish.battleships.GameBoard#boardType board type}
     *
     * @param boardType The board type
     */
    public GameBoard(char boardType) {
        this.boardType = boardType;
    }

    /**
     * Returns the game board
     *
     * @return The game board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Assigns a character to a certain position
     *
     * @param character Character to assign
     * @param row       Row to assign to
     * @param column    Column to assign to
     */
    public void setPosition(char character, int row, int column) {
        board[row][column] = character;
    }

    /**
     * Gets the character from a certain position
     * @param row Row to get char from
     * @param column Column to get char from
     * @return Char in position asked for
     */
    public char getPosition(int row, int column) {
        return board[row][column];
    }

    /**
     * Returns the {@link com.hamish.battleships.GameBoard#boardType board type}
     * @return The board type
     */
    public char getBoardType() {
        return boardType;
    }

    /**
     * Checks a set area to see if there any ships already placed in this area
     *
     * @param xCoordinate X coordinate of where to start checking
     * @param yCoordinate Y coordinate of where to start checking
     * @param direction   direction to check in
     * @param shipLength  length of ship to check
     * @return true if clear to enter ship, false if not
     */
    public boolean checkPositionClear(int xCoordinate, int yCoordinate, String direction, int shipLength) {
        if (direction.equals("R")) {
            for (int i = 0; i < shipLength; i++) {
                if (getPosition(yCoordinate, xCoordinate + i) == SHIP)
                return false;
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                if (getPosition(yCoordinate + i, xCoordinate) == SHIP)
                return false;
            }
        }
        return true;
    }

    /**
     * Places the ships using * to denote where a ship is
     *
     * @param xCoordinate X coordinate to place ship
     * @param yCoordinate Y coordinate to place ship
     * @param direction   direction ship will be placed in
     * @param shipLength  length of the ship
     */
    public void placeShip(int xCoordinate, int yCoordinate, String direction, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            if (direction.equals("R"))
                setPosition(SHIP, yCoordinate, xCoordinate + i);
            else
                setPosition(SHIP, yCoordinate + i, xCoordinate);
        }
    }

    /**
     * Prints out the game board
     */
    public void printBoard() {
        System.out.println(" \t1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}