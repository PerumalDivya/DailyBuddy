package com.example.keerthana.dailybud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent i1 = new Intent(selection.this, Todayexp.class);
            startActivity(i1);
        }
        if (v.getId() == R.id.button2) {
            Intent i2 = new Intent(selection.this, Weekly10.class);
            startActivity(i2);}

          if(v.getId()==R.id.button3) {
        Intent i3 = new Intent(selection.this, CatalogActivity.class);
        startActivity(i3);
       }
}}

