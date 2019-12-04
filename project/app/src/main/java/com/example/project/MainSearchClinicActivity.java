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
    private EditText address, workingHour, serviceType;
    private Button see;
    private MyDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search_clinic);

        address= (EditText) findViewById(R.id.etAddress);
        workingHour= (EditText) findViewById(R.id.etworkingHour);
        serviceType= (EditText) findViewById(R.id.etserviceType);
        see= (Button) findViewById(R.id.btnSee);
        db= new MyDBHandler(this);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr= address.getText().toString();
                String wh= workingHour.getText().toString();
                String st= serviceType.getText().toString();

                if(addr!= null && wh== null && st== null){
                    boolean findClinic= db.findClinicByAddress(addr);
                    if(findClinic){
                        Toast.makeText(getApplicationContext(), "This clinic is found by the address you entered. ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainSearchClinicActivity.this, MainBookCheckActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "There is no clinic who has the address you entered. ", Toast.LENGTH_SHORT).show();
                    }


           //     }else if(addr== null && wh!= null && st== null){
          //          boolean findClinic= db.findClinicByWorkingHour(wh);
           //     }else if(addr== null && wh== null && st!= null){
           //         boolean findClinic= db.findClinicByServiceType(st);
                }else{
                    Toast.makeText(getApplicationContext(), "You are only allowed to fill one of three blanks! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

