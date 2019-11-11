package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;



public class Main2Activity extends AppCompatActivity {
    private TextView Username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Username = (TextView)findViewById(R.id.textView6);

        Intent intent = getIntent();
        String name2 = intent.getStringExtra("username");
        Username.setText(name2);

    }
}
