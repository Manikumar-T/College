package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,Menu.class);
        Button login  = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView  name_view = findViewById(R.id.name);
                TextView password_view = findViewById(R.id.password);
                String name = name_view.getText().toString();
                String password = password_view.getText().toString();
                if(name.equals("") ) {
                    Toast.makeText(getBaseContext(),"Invalid name",Toast.LENGTH_LONG).show();
                }
                else if(password .equals("1234") ) {

                    intent.putExtra("name",name);
                    startActivity(intent);

                }else{
                    Toast.makeText(getBaseContext(),"invalid password ",Toast.LENGTH_LONG).show();
                    name_view.setText("");
                    password_view.setText("");

                }
            }
        });

    }
}