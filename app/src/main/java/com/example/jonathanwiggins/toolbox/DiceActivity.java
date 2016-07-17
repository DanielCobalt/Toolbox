package com.example.jonathanwiggins.toolbox;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DiceActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public float accelerationX = 0;
    public float accelerationY = 0;
    public float accelerationZ = 0;

    public float accelerationXOLD = 0;
    public float accelerationYOLD = 0;
    public float accelerationZOLD = 0;

    public float accelerationXDifference = 0;
    public float accelerationYDifference = 0;
    public float accelerationZDifference = 0;



    public void onSensorChanged(SensorEvent event) {
        accelerationX = event.values[0];
        accelerationY = event.values[1];
        accelerationZ = event.values[2];

        accelerationXDifference = Math.abs(accelerationX-accelerationXOLD);
        accelerationYDifference = Math.abs(accelerationY-accelerationYOLD);
        accelerationZDifference = Math.abs(accelerationZ-accelerationZOLD);

        accelerationXOLD = event.values[0];
        accelerationYOLD = event.values[1];
        accelerationZOLD = event.values[2];

        if (accelerationXDifference+accelerationYDifference+accelerationZDifference-9.8>30){
            diceRoll();
        }


    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public int answer = -1;
    public int dice=1;
    public int dice1=0;
    public int dice2=0;
    public int dice3=0;
    public int dice4=0;
    public int dice5=0;
    public int dice6=0;
    public int dice7=0;
    public int dice8=0;
    public int dice9=0;
    public int dice10=0;
    public String stringAnswer="";
    public int totalDice=0;
    public int averageDice;

    public void diceRoll(){
        if (answer == -1) {
            answer = 1;

            dice1=(int) (1+Math.random()*6);
            dice2=(int) (1+Math.random()*6);
            dice3=(int) (1+Math.random()*6);
            dice4=(int) (1+Math.random()*6);
            dice5=(int) (1+Math.random()*6);
            dice6=(int) (1+Math.random()*6);
            dice7=(int) (1+Math.random()*6);
            dice8=(int) (1+Math.random()*6);
            dice9=(int) (1+Math.random()*6);
            dice10=(int) (1+Math.random()*6);

            if (dice>=1){
                stringAnswer+=Integer.toString(dice1);
                totalDice+=dice1;
                averageDice+=dice1;
            }
            if (dice>=2){
                stringAnswer+=Integer.toString(dice2);
                totalDice+=dice2;
                averageDice+=dice2;
            }
            if (dice>=3){
                stringAnswer+=Integer.toString(dice3);
                totalDice+=dice3;
                averageDice+=dice3;
            }
            if (dice>=4){
                stringAnswer+=Integer.toString(dice4);
                totalDice+=dice4;
                averageDice+=dice4;
            }
            if (dice>=5){
                stringAnswer+=Integer.toString(dice5);
                totalDice+=dice5;
                averageDice+=dice5;
            }
            if (dice>=6){
                stringAnswer+=Integer.toString(dice6);
                totalDice+=dice6;
                averageDice+=dice6;
            }
            if (dice>=7){
                stringAnswer+=Integer.toString(dice7);
                totalDice+=dice7;
                averageDice+=dice7;
            }
            if (dice>=8){
                stringAnswer+=Integer.toString(dice8);
                totalDice+=dice8;
                averageDice+=dice8;
            }
            if (dice>=9){
                stringAnswer+=Integer.toString(dice9);
                totalDice+=dice9;
                averageDice+=dice9;
            }
            if (dice>=10){
                stringAnswer+=Integer.toString(dice10);
                totalDice+=dice10;
                averageDice+=dice10;
            }
            averageDice/=dice;



            TextView textViewResult = (TextView) findViewById(R.id.textViewDiceResult);
            textViewResult.setText(stringAnswer);

            if (dice>1) {
                TextView textViewTotalDice = (TextView) findViewById(R.id.textViewTotalDice);
                textViewTotalDice.setText("Total: " + Integer.toString(totalDice));
                TextView textViewAverageDice = (TextView) findViewById(R.id.textViewAverageDice);
                textViewAverageDice.setText("Average: "+Integer.toString(averageDice));
            }

        }

    }


    public void reset(View view){
        TextView textViewResult = (TextView) findViewById(R.id.textViewDiceResult);
        textViewResult.setText("");
        dice1=0;
        dice2=0;
        dice3=0;
        dice4=0;
        dice5=0;
        dice6=0;
        dice7=0;
        dice8=0;
        dice9=0;
        dice10=0;
        stringAnswer="";
        totalDice=0;
        answer = -1;
        averageDice=0;
        TextView textViewTotalDice = (TextView) findViewById(R.id.textViewTotalDice);
        textViewTotalDice.setText("");
        TextView textViewAverageDice = (TextView) findViewById(R.id.textViewAverageDice);
        textViewAverageDice.setText("");
    }
    public void addDice(View view){
        dice+=1;
        if (dice>10){
            dice=1;
        }
        Button buttonAddDice = (Button) findViewById(R.id.buttonAddDice);
        buttonAddDice.setText("Dice: "+Integer.toString(dice));

    }


}


