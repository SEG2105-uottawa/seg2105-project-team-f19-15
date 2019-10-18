package com.example.segproject;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.makeText;

public class Main2Activity extends AppCompatActivity {

    private EditText accountName, userPassword, comfirmedPassword, userEmail;
    private Button register;
    private TextView userLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        accountName= (EditText)findViewById(R.id.etAccountName);
        userPassword= (EditText)findViewById(R.id.et2Password);
        comfirmedPassword= (EditText)findViewById(R.id.et2comfirmPassword);
        userEmail= (EditText)findViewById(R.id.etEmail);
        register= (Button)findViewById(R.id.btn2SignUp);
        userLogin= (TextView)findViewById(R.id.tvUserLogin);
        String an=accountName.getText().toString().trim();
        String up=userPassword.getText().toString().trim();
        String uE=userEmail.getText().toString().trim();
        String fn=FirstName.getText().toString().trim();
        String ln=LastName.getText().toString().trim();


        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Email;
                MyDBHandler mydb = new MyDBHandler(Main2Activity.this, "accounts.db", 1);
                SQLiteDatabase db = mydb.getWritableDatabase();
                String sqlb = "select * from accountList";
                Cursor cursor = db.rawQuery(sqlb, null);
                while (cursor.moveToNext()) {
                    Email = cursor.getString(1);
                    if ((userEmail.getText().toString().equals(Email))) {
                        Toast.makeText(Main2Activity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                db.execSQL("insert into accountList values(an,uE,fn,ln,up)");
                Toast.makeText(Main2Activity.this, "sucessfully sign up ", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);



            }

        }
        userLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        }

    }





    private Boolean validate(){
        boolean flag= false;

        String name= accountName.getText().toString();
        String password1= userPassword.getText().toString();
        String email= userEmail.getText().toString();
        String password2= comfirmedPassword.getText().toString();

        if(name.isEmpty() && password1.isEmpty() && email.isEmpty()){
            makeText(this, "Please enter more details!", Toast.LENGTH_SHORT).show();
        }else if(password1.equals(password2)){
            makeText(this, "Two passwords you entered does not match!", Toast.LENGTH_SHORT).show();
        }else{
            flag= true;
        }
        return flag;

    }

}