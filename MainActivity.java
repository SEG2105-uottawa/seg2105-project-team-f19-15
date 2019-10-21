package com.example.seg2105project1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity  {

    private EditText username;
    private EditText password_1;
    private Button login_1;
    private Button signup_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUsername);
        password_1 = (EditText)findViewById(R.id.etPassword);
        login_1= (Button)findViewById(R.id.btnLogin);
        signup_1= (Button)findViewById(R.id.btnSignUp);

        login_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                login(username.getText().toString(), password_1.getText().toString());
            }
        });

        signup_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });

    }



    private void login(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("5T5ptQ"))){
            startActivity(new Intent(MainActivity.this, Welcome.class));
        }

    }
}

