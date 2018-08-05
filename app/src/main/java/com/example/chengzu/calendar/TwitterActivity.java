package com.example.chengzu.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/*
in this function you are able to login to twitter or sign up a new account to twitter, also it has
ability to let you to use website version of twitter for experience.
 */

public class TwitterActivity extends AppCompatActivity {


    TwitterLoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_twitter);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;


                login(session);
                // Do something with result, which provides a TwitterSession for making API calls
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(TwitterActivity.this,"Thanks", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void login(TwitterSession session)
    {
        String username = session.getUserName();
        Intent intent = new Intent(TwitterActivity.this, homepage.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
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
            Intent intentprofile=new Intent(TwitterActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(TwitterActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(TwitterActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(TwitterActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(TwitterActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(TwitterActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
