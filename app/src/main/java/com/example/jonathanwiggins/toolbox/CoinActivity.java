package com.example.jonathanwiggins.toolbox;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CoinActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);

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
            coinFlip();
        }


    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public long answer = -1;

    public void coinFlip(){
        if (answer == -1) {
            answer = Math.round(Math.random());
            TextView textViewResult = (TextView) findViewById(R.id.textViewCoinResult);
            if (answer == 1) {
                textViewResult.setText("Heads");
            } else {
                textViewResult.setText("Tails");
            }

        }

    }


    public void reset(View view){
        TextView textViewResult = (TextView) findViewById(R.id.textViewCoinResult);
        textViewResult.setText("");
        answer = -1;
    }
}


