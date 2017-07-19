package com.hamish.battleships;

public class Player {

    private final int STARTING_SHIP_NUM = 5;
    public GameBoard[] boards = new GameBoard[2];
    private Ship[] ships = new Ship[STARTING_SHIP_NUM];
    private String name;
    private int numShips = STARTING_SHIP_NUM;

    public Player(String tempName) {
        name = tempName;
        boards[0].setBoardType('A');
        boards[1].setBoardType('D');
        createShips();
    }

    private void createShips() {
        for (int i = 0; i < STARTING_SHIP_NUM; i++) {
            ships[i] = new Ship(i + 1);
        }
    }
}
