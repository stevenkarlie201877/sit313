package com.example.chengzu.calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// this activity is used for after you saved your password then you may quit this project.
//after you reload my project , you are required to type the password that you have already
// saved before
public class PassActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);


        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if (text1.equals("") || text2.equals("")){

                    Toast.makeText(PassActivity.this,"No password entered", Toast.LENGTH_SHORT).show();
                } else {
                    if (text1.equals(text2)) {

                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //end

                        Intent intent = new Intent(getApplicationContext(),HomeScreenActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(PassActivity.this, "Passwords does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
