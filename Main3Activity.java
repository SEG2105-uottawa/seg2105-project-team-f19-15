import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText firstName, userPassword, comfirmedPassword, userEmail;
    private Button register;
    private TextView userLogin;
    private MyDBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db= new MyDBHandler(this);
        firstName= (EditText)findViewById(R.id.etfisrtName);
        userPassword= (EditText)findViewById(R.id.et2Password);
        comfirmedPassword= (EditText)findViewById(R.id.et2comfirmPassword);
        userEmail= (EditText)findViewById(R.id.etEmail);
        register= (Button)findViewById(R.id.btn2SignUp);
        userLogin= (TextView)findViewById(R.id.tvUserLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= firstName.getText().toString();
                String password1= userPassword.getText().toString();
                String email= userEmail.getText().toString();
                String password2= comfirmedPassword.getText().toString();

                if(name.isEmpty() && password1.isEmpty() && email.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter more details.", Toast.LENGTH_SHORT).show();

                }else{
                    if(password1.equals(password2)){
                        account newAccount= new account(name, password1, email, Identity.employee);
                        account findAccount= db.findPerson(newAccount.getName(), newAccount.getPassword());
                        if(findAccount!= null){
                            db.addAcount(newAccount);
                            Toast.makeText(getApplicationContext(), "You have registered successfully.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, MainActivity.class));

            }
        });


    }

}
