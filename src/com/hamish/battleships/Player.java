package com.hamish.battleships;

public class Player {

    public GameBoard[] boards = new GameBoard[2];
    private Ship[] ships;
    private String name;
    private int numShips;

    public Player(String name, int startingNumShips) {
        this.name = name;
        this.numShips = startingNumShips;
        boards[0].setBoardType('A');
        boards[1].setBoardType('D');
        createShips();
    }

    private void createShips() {
        ships = new Ship[numShips];
        for (int i = 0; i < numShips; i++) {
            ships[i] = new Ship(i + 1);
        }
    }
}
