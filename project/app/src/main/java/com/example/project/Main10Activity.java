package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main10Activity extends AppCompatActivity {
    private TextView Username;
    private Button complete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Username = (TextView)findViewById(R.id.textView3);
        complete=(Button)findViewById(R.id.button6) ;

        Intent intent = getIntent();
        String name2 = intent.getStringExtra("username");
        Username.setText(name2);
        complete.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                startActivity(new Intent(Main10Activity.this, Main11Activity.class));
                Intent intent = new Intent(getApplicationContext(),Main11Activity.class);
                intent.putExtra("username",Username.getText().toString());
                startActivity(intent);
            }
        });


    }
}
