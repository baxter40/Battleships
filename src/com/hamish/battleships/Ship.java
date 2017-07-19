package com.hamish.battleships;

public class Ship {
    private int length;
    private int health;

    public Ship(int length) {
        this.length = length;
        health = length;
    }

    public int getHealth() {
        return health;
    }

    public void shipHit() {
        health--;
    }

}
