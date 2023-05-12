package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class colourchanger extends AppCompatActivity {

    int font_size=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colourchanger);
        TextView tv = findViewById(R.id.textView3);
        Button size = findViewById(R.id.changesize);
        Button colour = findViewById(R.id.changecolour);
        Random r = new Random();
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTextSize(font_size);
                font_size+=10;
                if(font_size==50)
                    font_size=10;

            }
        });

        colour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTextColor(Color.rgb(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            }
        });


    }
}