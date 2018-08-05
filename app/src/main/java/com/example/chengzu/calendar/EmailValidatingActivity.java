package com.example.chengzu.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatingActivity extends AppCompatActivity {

    EditText et_email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_validating);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        et_email=(EditText)findViewById(R.id.email);

        btn=(Button)findViewById(R.id.btn);

        /*
        For the code below is regex for setting email's format and validate what is correct
        email format, if the email format is not like XXX@gmail.com(example), it will prompt
        Please enter Valid Email-Id. if the email format is correct, it will tell you that
        Correct email format
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String email = et_email.getText().toString();

                Matcher matcher= Pattern.compile(validemail).matcher(email);


                if (matcher.matches()){
                    Toast.makeText(getApplicationContext(),"Correct email format",Toast.LENGTH_LONG).show();


                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter Valid Email-Id",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu manu){
        getMenuInflater().inflate(R.menu.main,manu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_profile){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(EmailValidatingActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}



