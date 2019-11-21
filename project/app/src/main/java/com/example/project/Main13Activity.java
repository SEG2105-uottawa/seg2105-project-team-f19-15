package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main13Activity extends AppCompatActivity {
    private EditText etService;
    private Button add, listService;
    private MyDBHandler db;
    private ListView list;
    List<Product> products;
    DatabaseReference databaseProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        databaseProducts = FirebaseDatabase.getInstance().getReference("clinics");
        db= new MyDBHandler(this);
        etService = (EditText) findViewById(R.id.editText);
        add = (Button) findViewById(R.id.button7);
        listService= (Button) findViewById(R.id.btnListSerivice);
        Intent intent = getIntent();
        final String Username = intent.getStringExtra("username");
        list = (ListView) findViewById(R.id.list);
        products = new ArrayList<>();
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                showUpdateDeleteDialog(product.getId(), product.getProductName());
                return true;
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = etService.getText().toString();
                if (service.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter more details.", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insert = db.insertSer(Username, service);
                    if (insert) {
                        Toast.makeText(getApplicationContext(), "You have add the service", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Haven't added", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        listService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= db.seeAll();
                if(cursor.getCount()== 0){
                    Toast.makeText(getApplicationContext(), "No item to show at this time.", Toast.LENGTH_SHORT).show();
                }else{
                    StringBuffer buffer= new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("username:"+ cursor.getString(0)+ "\n");
                        buffer.append("service: "+ cursor.getString(1)+ "\n\n");

                    }

                    show("User and Service", buffer.toString());
                }
            }
        });
    }

    private void showUpdateDeleteDialog ( final String productId, String productName){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_main13, null);
        dialogBuilder.setView(dialogView);

        dialogBuilder.setTitle(productName);
        final AlertDialog b = dialogBuilder.create();
        b.show();


    }

    private void show(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}