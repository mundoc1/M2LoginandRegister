package com.example.m2loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void sendRegister(View view){
//        create intent for when the user hit the "register" button, it will go to the registration page
        Intent reg1 = new Intent(this, RegisterActivity.class);
        startActivity(reg1);
        finish();
    }

//    create variables
    Button login;
    EditText email, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

//        define variables
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                login();

            }
        });
    }

//    check if email and password are correct
    public void login(){
        String e=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(e.equals("")&& pass.equals(""))
        {
            Toast.makeText(this, "email and password accepted!",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"login credential is wrong",Toast.LENGTH_LONG).show();
        }
    }
}
