package com.example.wall_ee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class GalxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galx);

        Button backbtn = (Button) findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalxActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void methodtoexe(View view) {
        WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
        try{
            wlp.setResource(+R.drawable.galx4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}