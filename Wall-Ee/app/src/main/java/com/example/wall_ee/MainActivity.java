package com.example.wall_ee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wall_ee.adapter.WallpaperAdapter;
import com.example.wall_ee.model.WallpaperModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<WallpaperModel> list;

    private WallpaperAdapter adapter;
    DatabaseReference reference;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

      list = new ArrayList<>();
      adapter = new WallpaperAdapter(list);
      recyclerView.setAdapter(adapter);

      reference = FirebaseDatabase.getInstance().getReference().child("Wallpaper");

      reference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                  WallpaperModel model = dataSnapshot.getValue(WallpaperModel.class);
                  list.add(model);

              }
              adapter.notifyDataSetChanged();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {
              Log.e(TAG, error.getMessage());
          }
      });

    }

    private void init(){
        recyclerView = findViewById(R.id.recyclerView);
    }
}

//OLD VERSION OF OUR WORK...
    /*
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
} */