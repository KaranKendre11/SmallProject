package com.example.wall_ee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button Galxbutton = (Button) findViewById(R.id.Galxbtn);
        Button Advbutton = (Button) findViewById(R.id.Adventurebtn);

        Button Natbutton = (Button) findViewById(R.id.Natbtn);

        Button Aesbutton = (Button) findViewById(R.id.aesbtn);

        Galxbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GalxActivity.class);
                startActivity(i);
            }
        });

        Advbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AdvActivity.class);
                startActivity(i);
            }
        });

        Natbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,NatActivity.class);
                startActivity(i);
            }
        });

        Aesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AesActivity.class);
                startActivity(i);
            }
        });


    }
}