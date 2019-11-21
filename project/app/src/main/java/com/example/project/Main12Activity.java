package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import static android.app.ProgressDialog.show;

public class Main12Activity extends AppCompatActivity {
    private EditText StartHours;
    private  EditText StartMinutes;
    private  EditText EndingHours;
    private EditText EndingMinutes;
    private Button Set;
    private int year;
    private int month;
    private int day;
    private CalendarView calendarView;
    private MyDBHandler db;
    private Button Find;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        StartHours = (EditText)findViewById(R.id.StartHours);
        StartMinutes = (EditText)findViewById(R.id.StartMinutes);
        EndingHours = (EditText)findViewById(R.id.EndingHours);
        EndingMinutes=(EditText)findViewById(R.id.EndingMinutes);
        Set = (Button)findViewById(R.id.Set);
        Find = (Button)findViewById(R.id.Find);
        db= new MyDBHandler(this);
        calendarView = (CalendarView)findViewById(R.id.calendarView) ;
        //  calendarView.setOnClickListener((View.OnClickListener) this);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView calendarView, int y, int m, int d) {
                year = y;
                month = m;
                day = d;

            }
        });
        Set.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(StartHours.getText().toString() == null || StartMinutes.getText().toString() ==null|| EndingHours.getText().toString()==null||EndingMinutes.getText().toString()==null){
                    Toast.makeText(getApplicationContext(),"Please enter the time",Toast.LENGTH_SHORT).show();
                }else if(Integer.valueOf(StartHours.getText().toString())>13 || Integer.valueOf(StartMinutes.getText().toString())>60 || Integer.valueOf(EndingHours.getText().toString())>13 || Integer.valueOf(EndingMinutes.getText().toString())>60){
                    Toast.makeText(getApplicationContext(),"Please reEnter the time",Toast.LENGTH_SHORT).show();
                }else{
                    ChooseTime chooseTime = new ChooseTime(Integer.valueOf(StartHours.getText().toString().trim()),Integer.valueOf(StartMinutes.getText().toString().trim()),Integer.valueOf(EndingHours.getText().toString().trim()),Integer.valueOf(EndingMinutes.getText().toString().trim()));
                    chooseTime.setStartHours(Integer.valueOf(StartHours.getText().toString().trim()));
                    chooseTime.setStartMinutes(Integer.valueOf(StartMinutes.getText().toString().trim()));
                    chooseTime.setEndingHours(Integer.valueOf(EndingHours.getText().toString().trim()));
                    chooseTime.setEndingMinutes(Integer.valueOf(EndingMinutes.getText().toString().trim()));
                    boolean insert= db.insert_WorkingTime(chooseTime);
                    if(insert){
                        Toast.makeText(getApplicationContext(),"Time has been set up successfully! ",Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });
        //You may need to enter the StartingTime and EndingTime to check the working hours
        Find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StartHours.getText().toString() == null || EndingHours.getText().toString()==null){
                    Toast.makeText(getApplicationContext(),"Please enter the StartingHours and EndingHours",Toast.LENGTH_SHORT).show();
                }else if(Integer.valueOf(StartHours.getText().toString())>13||Integer.valueOf(EndingHours.getText().toString())>13){
                    Toast.makeText(getApplicationContext(),"reEnter please",Toast.LENGTH_SHORT).show();
                }else{
                    db.selectTime(Integer.valueOf(StartHours.getText().toString()),Integer.valueOf(EndingHours.getText().toString()));

                }
            }
        });




    }
}

