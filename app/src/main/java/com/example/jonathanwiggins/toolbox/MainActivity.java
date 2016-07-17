package com.example.jonathanwiggins.toolbox;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCoinFlipActivity(View view){
        startActivity(new Intent(MainActivity.this,CoinActivity.class));
    }

    public void openDiceActivity(View view){
        startActivity(new Intent(MainActivity.this,DiceActivity.class));
    }
    public void openNotesActivity(View view){
        startActivity(new Intent(MainActivity.this,NoteChooserActivity.class));
    }
    public void openSoundsActivity(View view){
        startActivity(new Intent(MainActivity.this,SoundsActivity.class));
    }
}
