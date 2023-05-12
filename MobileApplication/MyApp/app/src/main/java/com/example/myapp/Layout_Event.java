package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Layout_Event extends AppCompatActivity {

    String dept[] = {"IT","CSE","ECE","EEE","Mech"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_event);
        TextView name_view = findViewById(R.id.name_detail);
        TextView reg_view = findViewById(R.id.Reg_Details);
        Button submit = findViewById(R.id.submit);

        Spinner sp_viwe = findViewById(R.id.spinner);
        ArrayAdapter adapter =  new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dept);
        sp_viwe.setAdapter(adapter);
        Intent i = new Intent(this,Event_Details.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_view.getText().toString(),reg = reg_view.getText().toString();
                String dept = sp_viwe.getSelectedItem().toString();
                i.putExtra("name",name);
                i.putExtra("reg",reg);
                i.putExtra("dept",dept);
                startActivity(i);
            }
        });




    }
}