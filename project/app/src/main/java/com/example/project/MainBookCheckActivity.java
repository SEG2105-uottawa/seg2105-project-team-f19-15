package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainBookCheckActivity extends AppCompatActivity {
    private EditText clinicName, commentText, rateText;
    private Button CheckIn, BookAppointment, viewWaitingTime, rate, viewAllComment;
    private MyDBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_book_check);

        clinicName = (EditText) findViewById(R.id.editText6);
        commentText = (EditText) findViewById(R.id.editText4);
        rateText = (EditText) findViewById(R.id.editText5);
        CheckIn = (Button) findViewById(R.id.button13);
        BookAppointment = (Button) findViewById(R.id.button12);
        viewWaitingTime = (Button) findViewById(R.id.button17);

        rate = (Button) findViewById(R.id.button14);
        viewAllComment = (Button) findViewById(R.id.button15);

        db = new MyDBHandler(this);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = clinicName.getText().toString();
                String comment = commentText.getText().toString();
                String rateNum = rateText.getText().toString();



                if (name.isEmpty() || comment.isEmpty() || rateNum.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter more details.", Toast.LENGTH_SHORT).show();

                }else{
                    if (isRate(rateNum)){
                        boolean checkClinic= db.checkClinic(name);
                        if(checkClinic){
                            boolean insert=db.insertCR(name, rateNum,comment);
                            if(insert){
                                Toast.makeText(getApplicationContext(),
                                        "You have rate successfully", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "There is not such a clinic", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(),
                                "you should rate it from 1 to 5", Toast.LENGTH_SHORT).show();
                    }





                }
            }
        });
        viewAllComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= db.showAllClinicRate();
                if(cursor.getCount()== 0){
                    Toast.makeText(getApplicationContext(),
                            "No rating to show at this time.", Toast.LENGTH_SHORT).show();
                }else{
                    StringBuffer buffer= new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("clinic name:"+ cursor.getString(0)+ "\n");
                        buffer.append("rate: "+ cursor.getString(1)+ "\n");
                        buffer.append("comment: "+ cursor.getString(2)+ "\n");

                    }

                    show("Comment and Rate", buffer.toString());
                }

            }
        });

    }
    private Boolean isRate(String num){

        if(Integer.parseInt(num)==5){
            return true;
        }
        if(Integer.parseInt(num)==4){
            return true;
        }
        if(Integer.parseInt(num)==3){
            return true;
        }
        if(Integer.parseInt(num)==2){
            return true;
        }
        if(Integer.parseInt(num)==1){
            return true;
        }


        return false;

    }
    private void show(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
