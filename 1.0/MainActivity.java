package com.example.segproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private String username, password;
    private EditText usernameET;
    private EditText passwordET;
    private Button login;
    private Button signup;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial(){

        login=(Button)findViewById(R.id.Log_in);
        login.setOnClickListener((View.OnClickListener) MainActivity.this);
        signup=(Button)findViewById(R.id.Sign_up);
        signup.setOnClickListener((View.OnClickListener) MainActivity.this);
        usernameET=(EditText)findViewById(R.id.Username);
        passwordET=(EditText)findViewById(R.id.Password);

    }
    public void OnClick(View arg0){
        switch(arg0.getId()){
            case R.id.Sign_up:
                Intent intent_signup = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent_signup);
                break;
            case R.id.Log_in:
                username = usernameET.getText().toString().trim();
                password = passwordET.getText().toString().trim();
                MyDBHandler mydb=new MyDBHandler(MainActivity.this, "accounts.db", 1);
                SQLiteDatabase db=mydb.getReadableDatabase();
                String sql="select * from accountList where email="+ username+"and password="+password+"";
                Cursor cursor=db.rawQuery(sql,null);
                if(!cursor.moveToNext())
                    Toast.makeText(MainActivity.this,"The password is incorrect!", Toast.LENGTH_SHORT).show();
                if(username.isEmpty() ){
                    Toast.makeText(this,"Re-enter the username please",Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()) {
                    Toast.makeText(this,"Re-enter the password please",Toast.LENGTH_SHORT).show();
                }
                String lastN=cursor.getString(3);
                String accT=cursor.getString(0);
                Intent intent_login = new Intent(getApplicationContext(),Welcome.class);
                intent_login.putExtra("data_name",lastN);
                intent_login.putExtra("data_account",accT);
                startActivity(intent_login);
                break;


        }

    }



}
