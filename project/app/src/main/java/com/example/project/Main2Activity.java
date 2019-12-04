package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;



public class Main2Activity extends AppCompatActivity {
    private TextView Username;
    private Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Username = (TextView)findViewById(R.id.textView6);
        search = (Button) findViewById(R.id.btn8Search);

        Intent intent = getIntent();
        String name2 = intent.getStringExtra("username");
        Username.setText(name2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainSearchClinicActivity.class));
            }
        });

    }
}
