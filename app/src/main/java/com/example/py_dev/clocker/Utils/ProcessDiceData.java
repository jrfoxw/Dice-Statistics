package com.example.py_dev.clocker.Utils;

import android.support.v7.app.AppCompatActivity;

import com.example.py_dev.clocker.Models.Rolls;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PY-DEV on 6/21/2016.
 */
public class ProcessDiceData {


    String diceName; // Dice name such as "D20"
    int diceNumberValue; // The dice type as value D20 -> 20
    int tableDiceColVal; // Sets dice Result column
    int tableRolled; // The amount of times a number has been rolled;
    Rolls rolls;
    ArrayList<Rolls> rollsArray = new ArrayList <>();
    HashMap<String, Integer> diceDict = new HashMap<String, Integer>();
    String[] diceList = {"D4","D6","D8","D10","D12","D20","D30","D100"};
    int diceRolls = 0;
    ArrayList<String> diceData = new ArrayList<>();




    public void ProcessDiceData(){

    }


    public void ProcessDiceData(String diceName,
                                int diceNumberValue,
                                int tableDiceColVal,
                                int tableRolled,
                                Rolls rolls){


        this.diceName = diceName;
        this.diceNumberValue = diceNumberValue;
        this.tableDiceColVal = tableDiceColVal;
        this.tableRolled = tableRolled;
        this.rolls = rolls;

        for(String s:diceList) {
            diceDict.put(s, 0);
        }

    }

    public long getRandomNumber(int number, String diceName){
        long result = Math.round(Math.random()*number+1);
        diceDict.put(diceName,diceDict.get(diceName)+1);
        rollsArray.add(new Rolls(diceName, result, diceDict.get(diceName)));
        diceRolls++;
        diceData.add(diceName,result,diceRolls,);

        return result;
    }

    public int getRatio(String die, long result){
        int count = 0;
        for (Rolls r: rollsArray){
            if(r.getDiceUsed().equals(die) && r.getNumberThatRolls() == result){
                count ++;
            }

        }
        return count;


    }



    public String getDiceName() {
        return diceName;
    }

    public void setDiceName(String diceName) {
        this.diceName = diceName;
    }

    public int getDiceNumberValue() {
        return diceNumberValue;
    }

    public void setDiceNumberValue(int diceNumberValue) {
        this.diceNumberValue = diceNumberValue;
    }

    public int getTableDiceColVal() {
        return tableDiceColVal;
    }

    public void setTableDiceColVal(int tableDiceColVal) {
        this.tableDiceColVal = tableDiceColVal;
    }

    public int getTableRolled() {
        return tableRolled;
    }

    public void setTableRolled(int tableRolled) {
        this.tableRolled = tableRolled;
    }
}
