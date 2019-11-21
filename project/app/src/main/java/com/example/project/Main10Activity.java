package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main10Activity extends AppCompatActivity {
    private TextView Username, wantTo;
    private Button complete, seeTime;
    private MyDBHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Username = (TextView)findViewById(R.id.textView3);
        complete=(Button)findViewById(R.id.button6);
        seeTime= (Button)findViewById(R.id.btnSeeTime);
        wantTo= (TextView)findViewById(R.id.tvWant);
        db= new MyDBHandler(this);

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

        seeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= db.viewAll();
                if(cursor.getCount()== 0){
                    Toast.makeText(getApplicationContext(), "No available time to show at this time.", Toast.LENGTH_SHORT).show();
                }else{
                    StringBuffer buffer= new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("StartingHours:"+ cursor.getString(0)+ "\n");
                        buffer.append("StartMinutes: "+ cursor.getString(1)+ "\n");
                        buffer.append("EndingHours: "+ cursor.getString(2)+ "\n");
                        buffer.append("EndingMinutes: "+ cursor.getString(3)+ "\n\n");
                    }

                    show("Available time", buffer.toString());
                }
            }
        });


    }
    private void show(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
