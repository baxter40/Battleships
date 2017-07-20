package com.hamish.battleships;

public class GameBoard {

    private char[][] board = new char[10][10];
    private char boardType;

    public char[][] getBoard() {
        return board;
    }

    public GameBoard(char boardType) {
        this.boardType = boardType;
    }
    public void setPosition(char character, int row, int column) {
        board[row][column] = character;
    }

    public char getPosition(int row, int column) {
        return board[row][column];
    }

    public char getBoardType() {
        return boardType;
    }

    public void placeShips() {

    }
}