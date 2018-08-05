package com.example.chengzu.calendar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.Date;
import java.util.Locale;

public class EventActivity extends AppCompatActivity {
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMM- yyyy", Locale.getDefault());
    @Override
    public boolean onCreateOptionsMenu(Menu manu){
        getMenuInflater().inflate(R.menu.main,manu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_profile){
            Intent intentprofile=new Intent(EventActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(EventActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(EventActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(EventActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(EventActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(EventActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null) ;
        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //the codes below set events for calendar, it will show weekend days on calendar, these long numbers are Timestamp in milliseconds
        Event ev1 = new Event(Color.RED, 1504312813000L, "");
        compactCalendar.addEvent(ev1);

        Event ev2 = new Event(Color.RED, 1504399213000L, "");
        compactCalendar.addEvent(ev2);

        Event ev3 = new Event(Color.RED, 1504917613000L, "");
        compactCalendar.addEvent(ev3);

        Event ev4 = new Event(Color.RED, 1505004013000L, "");
        compactCalendar.addEvent(ev4);

        Event ev5 = new Event(Color.RED, 1505522413000L, "");
        compactCalendar.addEvent(ev5);

        Event ev6 = new Event(Color.RED, 1505608813000L, "");
        compactCalendar.addEvent(ev6);

        Event ev7 = new Event(Color.RED, 1506127213000L, "");
        compactCalendar.addEvent(ev7);

        Event ev8 = new Event(Color.RED, 1506213613000L, "");
        compactCalendar.addEvent(ev8);

        Event ev9 = new Event(Color.RED, 1506732013000L, "");
        compactCalendar.addEvent(ev9);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {







            // setting the time to match the code above
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                if (dateClicked.toString().compareTo("Sat Aug 5 09:00:00 AST 2017") == 0) {
                    Toast.makeText(context, "Holiday", Toast.LENGTH_SHORT).show();        //  because of time limit, i did not do all events for this calendar,just a bit of code for a few of events.
                }
                     else {
                    Toast.makeText(context, "Holiday", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onMonthScroll(Date firstDayOfNewMonth)
            {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));        // setting format
            }

        });
    }


}

