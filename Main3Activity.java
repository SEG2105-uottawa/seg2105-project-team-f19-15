import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    private EditText accountName, userPassword, comfirmedPassword, userEmail;
    private Button register;
    private TextView userLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        accountName= (EditText)findViewById(R.id.etAccountName);
        userPassword= (EditText)findViewById(R.id.et2Password);
        comfirmedPassword= (EditText)findViewById(R.id.et2comfirmPassword);
        userEmail= (EditText)findViewById(R.id.etEmail);
        register= (Button)findViewById(R.id.btn2SignUp);
        userLogin= (TextView)findViewById(R.id.tvUserLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //some code associated with database goes here
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

    private Boolean validate(){
        boolean flag= false;

        String name= accountName.getText().toString();
        String password1= userPassword.getText().toString();
        String email= userEmail.getText().toString();
        String password2= comfirmedPassword.getText().toString();

        if(name.isEmpty() && password1.isEmpty() && email.isEmpty()){
            Toast.makeText(this, "Please enter more details!", Toast.LENGTH_SHORT).show();
        }else if(password1.equals(password2)){
            Toast.makeText(this, "Two passwords you entered does not match!", Toast.LENGTH_SHORT).show();
        }else{
            flag= true;
        }
        return flag;

    }

}