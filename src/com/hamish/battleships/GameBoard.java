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
     * @param col    Column to assign to
     */
    public void setPosition(char character, int col, int row) {
        board[col][row] = character;
    }

    /**
     * Gets the character from a certain position
     * @param col Column to get char from
     * @param row Row to get char from
     * @return Char in position asked for
     */
    public char getPosition(int col, int row) {
        return board[col][row];
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
     * @param col X coordinate of where to start checking
     * @param row Y coordinate of where to start checking
     * @param direction   direction to check in
     * @param shipLength  length of ship to check
     * @return true if clear to enter ship, false if not
     */
    public boolean checkPositionClear(int col, int row, String direction, int shipLength) {
        if (direction.equalsIgnoreCase("R")) {
            for (int i = 0; i < shipLength; i++) {
                if (getPosition(col + i, row) == SHIP)
                return false;
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                if (getPosition(col, row + i) == SHIP)
                return false;
            }
        }
        return true;
    }

    /**
     * Places the ships using * to denote where a ship is
     *
     * @param col X coordinate to place ship
     * @param row Y coordinate to place ship
     * @param direction   direction ship will be placed in
     * @param shipLength  length of the ship
     */
    public void placeShip(int col, int row, String direction, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            if (direction.equalsIgnoreCase("R"))
                setPosition(SHIP, col + i, row);
            else
                setPosition(SHIP, col, row + i);
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
                System.out.print(board[j][i] + " ");
            }
            System.out.print("\n");
        }
    }
}