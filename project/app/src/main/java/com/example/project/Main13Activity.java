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
    private Button add;
    private Button delete;
    ListView listViewProducts;
    List<Product> products;
    DatabaseReference databaseProducts;
    Intent intent = getIntent();
    final String username = intent.getStringExtra("username");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        databaseProducts = FirebaseDatabase.getInstance().getReference("clinics");

        etService = (EditText) findViewById(R.id.editText);
        add = (Button) findViewById(R.id.button7);
        delete = (Button) findViewById(R.id.button8);
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        products = new ArrayList<>();
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");
        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                showUpdateDeleteDialog(product.getId(), product.getProductName());
                return true;
            }
        });
        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct();
            }
        });






    }
    /*private void addProduct() {
        String Service=etService.getText().toString();
        if(!TextUtils.isEmpty(Service)){
            String id = databaseProducts.push().getKey();
            Clinic clinic = new Clinic(username, Service,true);
            databaseProducts.child(id).setValue(clinic);
            //displaying a success toast
            Toast.makeText(this, "service added", Toast.LENGTH_LONG).show();

        }

        else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please Enter a Name", Toast.LENGTH_LONG).show();
        }

    }
    /*private void deleteProduct(){
        String Service=etService.getText().toString();
        if(!TextUtils.isEmpty(Service)){
            String id = databaseProducts.push().getKey();
            Clinic clinic = new Clinic(username, Service,false);
            databaseProducts.child(id).setValue(clinic);
            //displaying a success toast
            Toast.makeText(this, "service added", Toast.LENGTH_LONG).show();

        }

        else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please Enter a Name", Toast.LENGTH_LONG).show();
        }

    }*/

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
}