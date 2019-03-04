package com.example.m2loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity{
//      create variables
    EditText firstName, lastName, dob, reg_email, reg_pass;
    Button sendReg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
//       Define variables
        firstName=(EditText)findViewById(R.id.firstName);
        lastName=(EditText)findViewById(R.id.lastName);
        dob=(EditText)findViewById(R.id.dob);
        reg_email=(EditText)findViewById(R.id.reg_email);
        reg_pass=(EditText)findViewById(R.id.reg_pass);
        sendReg=(Button)findViewById(R.id.reg);

        sendReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();

            }
        });
    }

//    create boolean expression to check if email is correct format
    boolean isEmail(EditText text){
        CharSequence reg_email = text.getText().toString();
        return(!TextUtils.isEmpty(reg_email) && Patterns.EMAIL_ADDRESS.matcher(reg_email).matches());
    }

//    create boolean expression to check if fields are empty or not (true or false)
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

//    validate the Data
    void checkDataEntered() {
//        Create Intent to run if all fields are correct and filled up
        Intent reg2 = new Intent(this, MainActivity.class);

        if (isEmpty(firstName) || firstName.length() <= 3) {
            Toast t = Toast.makeText(this, "Enter your First Name or your Name is too short", Toast.LENGTH_SHORT);
            t.show();
        } else if (isEmpty(lastName)) {
            lastName.setError("Enter your Last Name");
        } else if (isEmpty(dob)) {
            dob.setError("Enter your Birthday");
        } else if (isEmail(reg_email) == false) {
            reg_email.setError("Enter a valid Email");
        }
//        if everythig is correct, Inent is run
        else
        startActivity(reg2);

    }

}
