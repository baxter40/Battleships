package com.hamish.battleships;

import java.util.Scanner;

public class Game {

    private final static char HIT = 'H';
    private final static char MISS = 'M';
    private final static char SHIP = '*';
    private final static int STARTING_NUM_SHIPS = 5;

    private Player[] players = new Player[2];
    private Scanner systemIn = new Scanner(System.in);

    public Game() {

        System.out.println("Welcome to battleships!");
        setUpPlayers();

    }

    private void setUpPlayers() {
        for (int i = 0; i < 2; i++) {
            System.out.print("Please enter the name of player " + i + 1 + ":    ");
            players[i] = new Player(systemIn.next(), STARTING_NUM_SHIPS);
        }
    }

}
