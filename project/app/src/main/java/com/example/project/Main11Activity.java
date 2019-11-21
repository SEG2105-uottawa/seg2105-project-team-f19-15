package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.Toast;

public class Main11Activity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText address, phoneNumber, nameOfClinic, insurance,payment;
    private Button fixService, setHour,save;
    private MyDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        db= new MyDBHandler(this);

        address= (EditText)findViewById(R.id.etAddress);
        phoneNumber= (EditText)findViewById(R.id.etPhone);
        nameOfClinic= (EditText)findViewById(R.id.etClinic);
        insurance= (EditText)findViewById(R.id.etInsurance);
        insurance.setOnFocusChangeListener(this);
        payment= (EditText)findViewById(R.id.etPayment);
        payment.setOnFocusChangeListener(this);
        fixService= (Button)findViewById(R.id.button4);
        setHour= (Button)findViewById(R.id.button5);
        save= (Button)findViewById(R.id.button3);
        Intent intent = getIntent();
        final String Username = intent.getStringExtra("username");


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Address = address.getText().toString();
                String phoneNum = phoneNumber.getText().toString();
                String clinicName = nameOfClinic.getText().toString();
                String Insurance = insurance.getText().toString();
                String Payment = payment.getText().toString();


                if (Address.isEmpty() && phoneNum.isEmpty() && clinicName.isEmpty() && Insurance.isEmpty() && Payment.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter more details.", Toast.LENGTH_SHORT).show();

                } else {
                    if (checkAddress(Address)) {
                        if (checkPho(phoneNum)) {
                            if (checkClinic(clinicName)) {
                                if (checkIns(Insurance)) {
                                    if (checkPay(Payment)) {
                                        boolean insert = db.insertPro(Username, Address, phoneNum, clinicName, Insurance, Payment);
                                        if (insert) {
                                            Toast.makeText(getApplicationContext(), "You have complete the profile", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Haven't complete", Toast.LENGTH_SHORT).show();

                                        }
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Wrong payment type", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Wrong insurance type", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong clinic name type", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong phone number type", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong address type", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        fixService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main11Activity.this, Main13Activity.class));
            }
        });
        setHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main11Activity.this, Main12Activity.class));
            }
        });

    }

    private boolean checkAddress(String Address){
        String s =  "((?=.*[0-9])(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{4,20})";
        if (Address.isEmpty()) {
            return false;
        } else {
            return Address.matches(s);
        }
    }
    private boolean checkPho(String phoneNum){
        String s = "((?=.*[0-9]).{8,20})";
        if (phoneNum.isEmpty()) {
            return false;
        } else {
            return phoneNum.matches(s);
        }
    }
    private boolean checkClinic(String clinicName){
        String s = "((?=.*[a-z])(?=.*[A-Z]).{4,20})";
        if (clinicName.isEmpty()) {
            return false;
        } else {
            return clinicName.matches(s);
        }
    }
    private boolean checkIns(String Insurance){
        String s = "((?=.*[A-Z]).{4,30})";
        if (Insurance.isEmpty()) {
            return false;
        } else {
            return Insurance.matches(s);
        }
    }
    private boolean checkPay(String Payment){
        String s = "((?=.*[a-z]).{4,20})";
        if (Payment.isEmpty()) {
            return false;
        } else {
            return Payment.matches(s);
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            showListPopulWindow();
            show();
        }
    }


    private void showListPopulWindow() {
        final String[] list = {"OHIP", "UHIP", "PRIVATE","NONE"};
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));
        listPopupWindow.setAnchorView(insurance);
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                insurance.setText(list[i]);
                listPopupWindow.dismiss();
            }
        });
        listPopupWindow.show();
    }
    private void show() {
        final String[] pay={"debit", "credit","cash"};
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, pay));
        listPopupWindow.setAnchorView(payment);
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                payment.setText(pay[i]);
                listPopupWindow.dismiss();
            }
        });
        listPopupWindow.show();
    }
}
