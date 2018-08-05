package com.example.chengzu.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    /*
    this part of code will build a webview and connect with the deakin
    days website that i have already pre inserted.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.deakin.edu.au/students/enrolment-fees-and-money/university-handbook/2017-handbook/2017-trimester-dates");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            Intent intentprofile=new Intent(WebActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(WebActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(WebActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(WebActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
