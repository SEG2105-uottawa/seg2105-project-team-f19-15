package com.example.segproject;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    private TextView LastNameLayout;
    private TextView AccountNameLayout;
    private String layoutName;
    private String layoutAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        LastNameLayout = (TextView) findViewById(R.id.welcome);
        
        AccountNameLayout = (TextView) findViewById(R.id.loginas);
        Intent intent = getIntent();
        String layoutName = intent.getStringExtra("data_name");
        LastNameLayout.setText(layoutName);
        String layoutAccount = intent.getStringExtra("data_account");
        AccountNameLayout.setText(layoutAccount);
    }
}
