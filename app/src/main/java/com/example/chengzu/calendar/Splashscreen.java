package com.example.chengzu.calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// this activity is my splashscreen activity, it will take a while to welcome you
public class Splashscreen extends AppCompatActivity {
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")){
                    Intent intent = new Intent(getApplicationContext(), PassActivity.class);
                    startActivity(intent);
                    finish();
                }else {

                    Intent intent = new Intent(getApplicationContext(),EnterPassActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        },2000);
    }
}
