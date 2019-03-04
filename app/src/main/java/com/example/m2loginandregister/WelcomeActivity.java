package com.example.m2loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
//    shows the splash screen for 10000ms
    private static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        new Handler().postDelayed(new Runnable() {
//            Creating new intent to go to MainActivity.java after 10000ms
            @Override
            public void run() {
                Intent loginIntent = new Intent(WelcomeActivity.this, MainActivity.class);
//                start intent
                startActivity(loginIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
