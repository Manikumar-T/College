package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String  name= getIntent().getStringExtra("name");
        TextView msg = findViewById(R.id.welcomemsg);
        msg.setText("Welcome "+name.toUpperCase(Locale.ROOT));
        Button colourchanger = findViewById(R.id.colour_changer);
        colourchanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}