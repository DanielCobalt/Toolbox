package com.example.jonathanwiggins.toolbox;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class NoteChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Standard generated stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_chooser);

        //Shared Preferences Variables
        SharedPreferences sharedpreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("load",-1);

        editor.commit();


        //Update the nameArrayList based on what is stored in the shared prefs
        ArrayList<String> nameArrayList = new ArrayList<>();
        boolean a=true;
        for(int i=0;a;i++){
            if (sharedpreferences.getString("name"+Integer.toString(i),"")!=""){
                nameArrayList.add(i,sharedpreferences.getString("name"+Integer.toString(i),""));
            }
            else{
                a = false;
            }
            //Variables in the Shared prefs are stored as name0, name1, name2
        }

        //Create the Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this,R.layout.list_view_layout,nameArrayList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //On Click listener for individual items int he list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                SharedPreferences sharedpreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                //save the position that was clicked so that it can be loaded by the editor
                editor.putInt("load",position);
                editor.commit();

                //start the journal editor
                startActivity(new Intent(NoteChooserActivity.this, NoteEditorActivity.class));
                finish();
            }
        });

    }

    public void newJournal(View view){
        //Opens the journal editor activity, which when opened is a blank journal because the "load" variable has not been changed
        startActivity(new Intent(NoteChooserActivity.this,NoteEditorActivity.class));
        finish();
    }


}

