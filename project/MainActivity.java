package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity  {

    private EditText username;
    private EditText password_1;
    private Button login_1;
    private Button signup_1;
    private MyDBHandler db;
    //public static final String EXTRA_TEXT1 = "com.example.group.ondemandhomerepair.EXTRA_TEXT1";
    //public static final String EXTRA_TEXT2 = "com.example.group.ondemandhomerepair.EXTRA_TEXT2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUsername);
        password_1 = (EditText)findViewById(R.id.etPassword);
        login_1= (Button)findViewById(R.id.btnLogin);
        signup_1= (Button)findViewById(R.id.btnSignUp);
        db= new MyDBHandler(this);

        login_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                if((username.getText().toString().equals("admin"))&& (password_1.getText().toString().equals("5T5ptQ"))){
                    Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                    startActivity (intent);
                    //startActivity(new Intent(MainActivity.this, Main4Activity.class));
                }
                if(db.findUser(username.getText().toString(),password_1.getText().toString())){
                    Intent intent_login = new Intent(getApplicationContext(),Main2Activity.class);
                    //intent_login.putExtra(EXTRA_TEXT1, username);
                    //intent_login.putExtra(EXTRA_TEXT2, userType);
                    startActivity (intent_login);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong account or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });

    }

}
