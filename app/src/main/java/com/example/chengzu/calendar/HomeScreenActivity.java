package com.example.chengzu.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


// this activity connected with the home_screen.xml, also it my projects' menu part, after splash
//screen and you enter correct password you will enter my home screen
// it also connected with 3 different activities including appointment,friends,calendar
public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }

    //go to calendar
    public void GotoSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    //go to friends
    public void GotoListViewActivity(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    //for action bar
    @Override
    public boolean onCreateOptionsMenu(Menu manu){
        getMenuInflater().inflate(R.menu.main,manu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_profile){
            Intent intentprofile=new Intent(HomeScreenActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(HomeScreenActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(HomeScreenActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(HomeScreenActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(HomeScreenActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(HomeScreenActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        return true;
    }

    // go to appointment
    public void GotoAppointmentActivity(View view) {
        Intent intent = new Intent(this, AppointmentActivity.class);
        startActivity(intent);
    }

    public void GotoEncryptionActivity(View view) {
        Intent intent = new Intent(this, EncryptionActivity.class);
        startActivity(intent);
    }

    public void GotoSocialActivity(View view) {
        Intent intent = new Intent(this, SocialActivity.class);
        startActivity(intent);
    }
}
