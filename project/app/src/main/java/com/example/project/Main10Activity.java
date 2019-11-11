package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main10Activity extends AppCompatActivity {
    private TextView Username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Username = (TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        String name2 = intent.getStringExtra("username");
        Username.setText(name2);


    }
}
