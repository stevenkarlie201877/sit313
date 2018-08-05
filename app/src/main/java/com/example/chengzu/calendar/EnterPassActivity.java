package com.example.chengzu.calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


// this activity is connected with the enter_pass.xml, you are required to enter the password that
// you save before, and the password must be exactly same with the one you have already saved before
public class EnterPassActivity extends AppCompatActivity {

    //variables
    EditText editText;
    Button button;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pass);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        editText = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                if(text.equals(password)){
                    Intent intent = new Intent(getApplicationContext(),HomeScreenActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(EnterPassActivity.this, "Passwords does not match to the one you saved", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
