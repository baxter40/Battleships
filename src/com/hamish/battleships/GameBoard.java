package com.hamish.battleships;

/**
 * Game board class that controls the boards and can pass informationb back to the boards
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

    public void placeShips() {

    }
}