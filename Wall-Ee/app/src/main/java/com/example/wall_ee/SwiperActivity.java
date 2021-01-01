package com.example.wall_ee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class SwiperActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);
    }

    private void init(){
        viewPager = findViewById(R.id.viewPager);

        position = getIntent().getIntExtra("position",0);
    }
}