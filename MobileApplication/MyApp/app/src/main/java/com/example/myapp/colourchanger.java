package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class colourchanger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colourchanger);
        TextView tv = findViewById(R.id.textView3);
        Button size = findViewById(R.id.changesize);
        Button colour = findViewById(R.id.changecolour);

    }
}