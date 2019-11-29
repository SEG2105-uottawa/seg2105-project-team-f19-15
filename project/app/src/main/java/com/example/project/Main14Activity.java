package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main14Activity extends AppCompatActivity {
    private EditText year;
    private EditText month;
    private EditText day;
    private EditText service_name;
    private EditText user_name;
    private EditText note;
    private Button submit;
    private Button list;
    private EditText hour;
    private  EditText minutes;
    private MyDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        year = (EditText)findViewById(R.id.year);
        month = (EditText)findViewById(R.id.month);
        day = (EditText)findViewById(R.id.day);
        service_name = (EditText)findViewById(R.id.service_name);
        user_name = (EditText)findViewById(R.id.user_name);
        note=(EditText)findViewById(R.id.notes);
        submit = (Button)findViewById(R.id.submit);
        list = (Button)findViewById(R.id.list);
        hour = (EditText)findViewById(R.id.hour);
        minutes = (EditText)findViewById(R.id.minutes);
        db = new MyDBHandler(this);
        final Cursor cursor = db.seeAll();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseTime chooseTime = new ChooseTime();
                if(user_name.getText().toString() == null || service_name.getText().toString()==null||Integer.valueOf(year.getText().toString().trim())==0 || Integer.valueOf(month.getText().toString().trim())==0 ||Integer.valueOf(day.getText().toString().trim())==0 ||Integer.valueOf(hour.getText().toString().trim())==0|| Integer.valueOf(minutes.getText().toString().trim())==0 ){
                    Toast.makeText(getApplicationContext(),"Please reenter the information",Toast.LENGTH_SHORT).show();
                }else if(Integer.valueOf(hour.getText().toString().trim())<chooseTime.getStartingHours() || Integer.valueOf(hour.getText().toString().trim())>chooseTime.getEndingHours()){
                    Toast.makeText(getApplicationContext(),"Please reenter the bookingthour",Toast.LENGTH_SHORT).show();
                }else if(Integer.valueOf(minutes.getText().toString().trim())>60 ||Integer.valueOf(minutes.getText().toString().trim())<0){
                    Toast.makeText(getApplicationContext(),"Please reenter the booking minutes",Toast.LENGTH_SHORT).show();
                    //  }//else if(cursor.getCount()!=0){
                    // double[] tmp = new double[100];
                    //if(cursor.moveToFirst()){
                    //  while (cursor.moveToNext()){
                    //    tmp[cursor.getString(1)];
                    //}
                    //}
                } else {

                    Booking_appointment booking = new Booking_appointment(user_name.getText().toString(), Integer.valueOf(year.getText().toString().trim()), Integer.valueOf(month.getText().toString().trim()), Integer.valueOf(day.getText().toString().trim()), Integer.valueOf(hour.getText().toString().trim()), Integer.valueOf(minutes.getText().toString().trim()), service_name.getText().toString(), note.getText().toString());
                    booking.setYear(Integer.valueOf(year.getText().toString().trim()));
                    booking.setDay(Integer.valueOf(day.getText().toString().trim()));
                    booking.setMonth(Integer.valueOf(month.getText().toString().trim()));
                    booking.setHour(Integer.valueOf(hour.getText().toString().trim()));
                    booking.setMinutes(Integer.valueOf(minutes.getText().toString().trim()));
                    booking.setNotes(note.getText().toString());
                    booking.setService_name(service_name.getText().toString());
                    booking.setUser_name(user_name.getText().toString());
                    boolean insert = db.insert_booking(booking);
                    if(insert){
                        Toast.makeText(getApplicationContext(),"booking is successfully submitted",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor.getCount()==0){
                    Toast.makeText(getApplicationContext(),"There is no booking",Toast.LENGTH_SHORT).show();
                }else{
                    StringBuffer buffer= new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("username: "+ cursor.getString(0)+ "\n");
                        buffer.append("year: "+ cursor.getString(1)+ "month: "+ cursor.getString(2)+ "day: "+ cursor.getString(3)+"hour: "+ cursor.getString(4)+ "minutes: "+ cursor.getString(5)+ "\n");
                        buffer.append("servicename: "+ cursor.getString(6)+ "\n");
                        buffer.append("notes: "+ cursor.getString(7)+ "\n");
                    }
                    show("booking", buffer.toString());
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
