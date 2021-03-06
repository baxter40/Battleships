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
     * Constructor. Prints welcome message then runs method {@link Game#setUpPlayers() setUpPlayers}, after which runs
     * {@link Game#playGame() playGame}.
     */
    public Game() {

        System.out.println("Welcome to battleships!");
        setUpPlayers();
        playGame();

    }

    /**
     * Creates the two {@link com.hamish.battleships.Player players}, getting their names and then creating them
     */
    private void setUpPlayers() {
        for (int i = 0; i < 2; i++) {
            int playerNum = i + 1;
            System.out.print("Please enter the name of player " + playerNum + ":    ");
            players[i] = new Player(systemIn.next(), STARTING_NUM_SHIPS);
            clearBoard();
        }

    }

    /**
     * Runs the game while both players have ships left. Once done prints a congratulations message
     */
    private void playGame() {
        int[] attackCo;
        boolean bothPlayersIn = true;
        while (bothPlayersIn) {
            for (int i = 0; i < 2; i++) {
                if (bothPlayersIn) {
                    attackCo = players[i].playerGo();
                    if (players[i == 1 ? 0 : 1].positionTaken(attackCo[0], attackCo[1])) {
                        System.out.println("Ship Hit!");
                        players[i].attackHit(attackCo[0], attackCo[1]);
                    } else {
                        System.out.println("No ships hit");
                        players[i].attackMissed(attackCo[0], attackCo[1]);
                    }
                    if (i == 0) {
                        if (!players[1].shipLeft()) {
                            bothPlayersIn = false;
                            System.out.println("Congratulations " + players[0].getName() + " won!");
                        }
                    } else {
                        if (!players[0].shipLeft()) {
                            bothPlayersIn = false;
                            System.out.println("Congratulations " + players[1].getName() + " won!");
                        }
                    }
                    System.out.println("Enter any key to continue");
                    systemIn.nextLine();
                    systemIn.nextLine();
                    clearBoard();
                }
            }
        }
    }

    /**
     * Prints enough new lines to hide board from other player
     */
    private void clearBoard() {
        for (int i = 0; i < 5; i++)
            System.out.println("\n\n");
    }

}
