package com.example.jonathanwiggins.toolbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SoundsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
    }


    public void openSoundsActivity(View view){
        startActivity(new Intent(SoundsActivity.this,SoundChooserActivity.class));
    }

}
