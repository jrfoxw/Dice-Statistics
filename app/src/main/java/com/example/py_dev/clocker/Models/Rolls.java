package com.example.py_dev.clocker.Models;

/**
 * Created by PY-DEV on 6/20/2016.
 */
public class Rolls {

    // Tracks number of dice rolls //

    private String diceUsed;
    private long numberThatRolls;
    private int numOfRolls;

    Rolls rolls;

    public Rolls(){

    }

    public Rolls(String diceUsed, long numberThatRolls, int numOfRolls){

        this.diceUsed = diceUsed;
        this.numberThatRolls = numberThatRolls;
        this.numOfRolls = numOfRolls;



    }

    public Rolls addRoll(String diceUsed, long numberThatRolls, int numOfRolls){

        this.diceUsed = diceUsed;
        this.numberThatRolls = numberThatRolls;
        this.numOfRolls = numOfRolls;

        return rolls;
    }


    public int getRolls(){
        int newLength = rolls.toString().length();
        return newLength;
    }

    public String getDiceUsed() {
        return diceUsed;
    }

    public void setDiceUsed(String diceUsed) {
        this.diceUsed = diceUsed;
    }

    public long getNumberThatRolls() {
        return numberThatRolls;
    }

    public void setNumberThatRolls(int numberThatRolls) {
        this.numberThatRolls = numberThatRolls;
    }

    public int getNumOfRolls() {
        return numOfRolls;
    }

    public void setNumOfRolls(int numOfRolls) {
        this.numOfRolls = numOfRolls;
    }
}


