package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Event_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        TextView name_view = findViewById(R.id.name_lable);
        TextView reg_view = findViewById(R.id.reg_lable);
        TextView dept_view = findViewById(R.id.dept_lable);
        Intent i =getIntent();
        String name = i.getStringExtra("name");
        String reg = i.getStringExtra("reg");
        String dept = i.getStringExtra("dept");

        name_view.setText(name);
        reg_view.setText(reg);
        dept_view.setText(dept);
    }
}