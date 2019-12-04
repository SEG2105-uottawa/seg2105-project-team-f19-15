package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainSearchClinicActivity extends AppCompatActivity {
    private EditText address, startHr, endHr, startMin, endMin, serviceType;
    private Button see;
    private MyDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search_clinic);

        address= (EditText) findViewById(R.id.etAddress);
        startHr= (EditText) findViewById(R.id.etstartingHour);
        endHr= (EditText) findViewById(R.id.etendingHour);
        startMin= (EditText) findViewById(R.id.etstartingMin);
        endMin= (EditText) findViewById(R.id.etendingMin);
        serviceType= (EditText) findViewById(R.id.etserviceType);
        see= (Button) findViewById(R.id.btnSee);
        db= new MyDBHandler(this);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr= address.getText().toString();
                String startWorkingHr= startHr.getText().toString();
                String startWorkingMin= startMin.getText().toString();
                String endWorkingHr= endHr.getText().toString();
                String endWorkingMin= endMin.getText().toString();
                String st= serviceType.getText().toString();

                if(addr!= null && (startWorkingHr== null && startWorkingMin== null && endWorkingHr== null && endWorkingMin== null) && st== null){
                    boolean findClinic= db.findClinicByAddress(addr);
                    if(findClinic){
                        Toast.makeText(getApplicationContext(), "This clinic is found by the address you entered. ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainSearchClinicActivity.this, MainBookCheckActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "There is no clinic who has the address you entered. ", Toast.LENGTH_SHORT).show();
                    }


                }else if(addr== null && (startWorkingHr!= null && startWorkingMin!= null && endWorkingHr!= null && endWorkingMin!= null) && st== null){
                    boolean findClinic= db.findClinicByWorkingHour(startWorkingHr, startWorkingMin, endWorkingHr, endWorkingMin);
                    if(findClinic){
                        Toast.makeText(getApplicationContext(), "This clinic is found by the working hour you entered. ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainSearchClinicActivity.this, MainBookCheckActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "There is no clinic who has the working hour you entered. ", Toast.LENGTH_SHORT).show();
                    }


                }else if(addr== null && (startWorkingHr== null && startWorkingMin== null && endWorkingHr== null && endWorkingMin== null) && st!= null){
                    boolean findClinic= db.findClinicByServiceType(st);
                    if(findClinic){
                        Toast.makeText(getApplicationContext(), "This clinic is found by the type of service you entered. ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainSearchClinicActivity.this, MainBookCheckActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "There is no clinic who has the type of service you entered. ", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "You are only allowed to fill one of three blanks! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

