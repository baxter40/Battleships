package com.hamish.battleships;

import java.util.Scanner;

/**
 * This class is where all the game logic is stored. This will create and store the
 * {@link com.hamish.battleships.Player players} and control all turns
 */
public class Game {

    /**
     * Char to make code more readable
     */
    private final static char HIT = 'H';

    /**
     * Char to make code more readable
     */
    private final static char MISS = 'M';

    /**
     * Char to make code more readable
     */
    private final static char SHIP = '*';

    /**
     * To store how many ships should start
     */
    private final static int STARTING_NUM_SHIPS = 5;

    /**
     * Creating instances of the two {@link com.hamish.battleships.Player players}
     */
    private Player[] players = new Player[2];

    /**
     * Scanner to read in
     */
    private Scanner systemIn = new Scanner(System.in);

    /**
     * Constructor. Prints welcome message then runs method {@link Game#setUpPlayers() setUpPlayers}
     */
    public Game() {

        System.out.println("Welcome to battleships!");
        setUpPlayers();

    }

    /**
     * Creates the two {@link com.hamish.battleships.Player players}, getting their names and then creating them
     */
    private void setUpPlayers() {
        for (int i = 0; i < 2; i++) {
            System.out.print("Please enter the name of player " + i + 1 + ":    ");
            players[i] = new Player(systemIn.next(), STARTING_NUM_SHIPS);
        }
    }

}
