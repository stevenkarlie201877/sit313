package com.example.chengzu.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// It is my Appointment activity, it connected with the button appointment in homescreen activity
// also in this activity, you are able to type word and appointment, then it will insert data to daatabase
// also it has the appointment.xml below

public class AppointmentActivity extends AppCompatActivity {


    // variables
    private static final String TAG = "AppointmentActivity";
    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;


    //find id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("The text field can not be empty!");
                }

            }
        });


        //intent for transition
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppointmentActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }

    //insert and add data
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Saving appointment event successfully!");
        } else {
            toastMessage("error message");
        }
    }
// for the back button of action bar
    @Override
    public boolean onCreateOptionsMenu(Menu manu){
        getMenuInflater().inflate(R.menu.main,manu);
        return true;
    }

    // it is action bar connected with my activities.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_profile){
            Intent intentprofile=new Intent(AppointmentActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(AppointmentActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(AppointmentActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(AppointmentActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(AppointmentActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(AppointmentActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
       private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}