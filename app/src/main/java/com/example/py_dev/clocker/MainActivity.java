package com.example.py_dev.clocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.py_dev.clocker.Models.Rolls;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    int diceRolls = 0;
    ArrayList<Rolls> rolls = new ArrayList<>();
    HashMap<String, Integer> diceDict = new HashMap<String, Integer>();
    String[] diceList = {"D4","D6","D8","D10","D12","D20","D30","D100"};


     // holds data for amount of dice rolls should be changed to hashmap//


    @Bind(R.id.buttonD4) Button buttonD4;
    @Bind(R.id.buttonD6) Button buttonD6;
    @Bind(R.id.buttonD8) Button buttonD8;
    @Bind(R.id.buttonD10) Button buttonD10;
    @Bind(R.id.buttonD12) Button buttonD12;
    @Bind(R.id.buttonD20) Button buttonD20;
    @Bind(R.id.buttonD30) Button buttonD30;
    @Bind(R.id.buttonD100) Button buttonD100;
//    @Bind(R.id.displayView) TextView displayView;
    @Bind(R.id.scrollView) ScrollView scrollView;
    @Bind(R.id.numOfDiceRolls) TextView numOfDiceRolls;
//    @Bind(R.id.displayTracker) TextView displayTracker;
    @Bind(R.id.tableD4ColValue) TextView tableD4ColValue;
    @Bind(R.id.tableD6ColValue) TextView tableD6ColValue;
    @Bind(R.id.tableD8ColValue) TextView tableD8ColValue;
    @Bind(R.id.tableD10ColValue) TextView tableD10ColValue;


    @Bind(R.id.rolledD4) TextView rolledD4;
    @Bind(R.id.rolledD6) TextView rolledD6;
    @Bind(R.id.rolledD8) TextView rolledD8;
    @Bind(R.id.rolledD10) TextView rolledD10;

    @Bind(R.id.ratioD4) TextView ratioD4;
    @Bind(R.id.ratioD6) TextView ratioD6;
    @Bind(R.id.ratioD8) TextView ratioD8;
    @Bind(R.id.ratioD10) TextView ratioD10;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for(String s:diceList) {
            diceDict.put(s, 0);
        }
        // clear text view //
//        displayView.setText("...");
    }

    @OnClick(R.id.buttonD4)
    public void buttonD4 (Button buttonD4){
        long result = getRandomNumber(4,"D4");
        int ratio = getRatio("D4",result);
        tableD4ColValue.setText(""+result);
        rolledD4.setText(""+diceDict.get("D4")); //returns quantity of dice rolled
        ratioD4.setText(""+ratio+" : "+diceRolls);
    }

    @OnClick(R.id.buttonD6)
    public void buttonD6 (Button buttonD6){

        long result = getRandomNumber(6,"D6");
        int ratio = getRatio("D6", result);
        tableD6ColValue.setText(""+result);
        rolledD6.setText(""+diceDict.get("D6"));
        ratioD6.setText(""+ratio+" : "+diceRolls);
    }

    @OnClick(R.id.buttonD8)
    public void buttonD8 (Button buttonD8){

        long result = getRandomNumber(8,"D8");
        int ratio = getRatio("D8", result);
        tableD8ColValue.setText(""+result);
        rolledD8.setText(""+diceDict.get("D8"));
        ratioD8.setText(""+ratio+" : "+diceRolls);
    }

    @OnClick(R.id.buttonD10)
    public void buttonD10 (Button buttonD10){

        long result = getRandomNumber(10,"D10");
        int ratio = getRatio("D10", result);
        tableD10ColValue.setText(""+result);
        rolledD10.setText(""+diceDict.get("D10"));
        ratioD10.setText(""+ratio+" : "+diceRolls);
    }

    @OnClick(R.id.buttonD12)
    public void buttonD12 (Button buttonD12){ getRandomNumber(12,"D12"); }

    @OnClick(R.id.buttonD20)
    public void buttonD20 (Button buttonD20){
        getRandomNumber(20,"D20");
    }

    @OnClick(R.id.buttonD30)
    public void buttonD30 (Button buttonD30){
        getRandomNumber(30, "D30");
    }

    @OnClick(R.id.buttonD100)
    public void buttonD100 (Button buttonD100){
        getRandomNumber(100, "D100");
    }

//    @OnClick(R.id.buttonD100)
//    public void buttonD30 (Button buttonD30){
//        readout.append("6");
//    }

    public long getRandomNumber(int number, String die ){
        long result = Math.round(Math.random()*number+1);
//        scrollView.fullScroll(View.FOCUS_DOWN);
//        displayView.append("1"+die+" :"+result+"\n");
//        scrollView.fullScroll(View.FOCUS_DOWN);
        trackRolls();



        diceDict.put(die,diceDict.get(die)+1);
        rolls.add(new Rolls(die,result,diceDict.get(die)));

//        displayTracker.append(""+die+" N: "+result+" R: 1\n");

        return result;

    }

    // Iterate through dice and get ratio that number has been rolled.
    public int getRatio(String die, long result){
        int count = 0;
        for (Rolls r: rolls){
            if(r.getDiceUsed().equals(die) && r.getNumberThatRolls() == result){
                count ++;
            }

        }
        return count;
    }

    public void trackRolls(){
        diceRolls++;
        numOfDiceRolls.setText("Rolls: "+diceRolls);


    }

}
