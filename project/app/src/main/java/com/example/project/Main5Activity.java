package com.example.project;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class Main5Activity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPrice;
    EditText editTextPerson;
    Button buttonAddProduct;
    ListView listViewProducts;
    DatabaseReference databaseProducts;

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextPerson = (EditText) findViewById(R.id.editTextPerson);
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        buttonAddProduct = (Button) findViewById(R.id.addButton);

        products = new ArrayList<>();
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                showUpdateDeleteDialog(product.getId(), product.getProductName());
                return true;
            }
        });
    }


    @Override
    protected void onStart() {


        super.onStart();

        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                products.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Product product = postSnapshot.getValue(Product.class);
                    products.add(product);

                }


                ProductList productsAdapter = new ProductList(Main5Activity.this, products);
                listViewProducts.setAdapter(productsAdapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void showUpdateDeleteDialog(final String productId, String productName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_main7, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextPrice  = (EditText) dialogView.findViewById(R.id.editTextPrice);
        final EditText editTextPerson  = (EditText) dialogView.findViewById(R.id.editTextPerson);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateProduct);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteProduct);

        dialogBuilder.setTitle(productName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));
                String person = editTextPerson.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    updateProduct(productId, name, price,person);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(productId);
                b.dismiss();
            }
        });
    }

    private void updateProduct(String id, String name, double price, String person) {


        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);


        Product product = new Product(id, name, price,person);
        dR.setValue(product);
        Toast.makeText(getApplicationContext(), "Product Updated", Toast.LENGTH_LONG).show();
    }

    private boolean deleteProduct(String id) {


        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);


        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Product Deleted", Toast.LENGTH_LONG).show();
        return true;
    }

    private void addProduct() {
        String name = editTextName.getText().toString().trim();
        double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));
        String person = editTextPerson.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){

            String id = databaseProducts.push().getKey();

            Product product = new Product(id, name, price,person);

            databaseProducts.child(id).setValue(product);

            editTextName.setText("");
            editTextPrice.setText("");
            editTextPerson.setText("");


            //displaying a success toast
            Toast.makeText(this, "Product added", Toast.LENGTH_LONG).show();

        }

        else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please Enter a Name", Toast.LENGTH_LONG).show();

        }

    }

    public void onAddCLick(View view) {
        addProduct();
    }
}
