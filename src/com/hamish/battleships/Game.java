package com.hamish.battleships;

import java.util.Scanner;

public class Game {

    private final char HIT = 'H';
    private final char MISS = 'M';
    private final char SHIP = '*';
    private final int STARTING_NUM_SHIPS = 5;

    private enum boardNumbers {Attack, Defence}

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
