package com.example.chengzu.calendar;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/*
For this part is for saving user's password as a hash, not the actual password, when user enter
some important things, they can set up a credential for the content. when they want to see what
content whey saved, they just need to use password to decrypt the content.
 */

public class EncryptionActivity extends AppCompatActivity {


    EditText inputText, inputPassword;
    TextView outputText;
    Button encBtn, decBtn;
    String outputString;
    String AES = "AES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // setting UI edit text, textview, buttons
        inputText = (EditText)findViewById(R.id.inputText);
        inputPassword = (EditText)findViewById(R.id.password);

        outputText = (TextView)findViewById(R.id.outputText);
        encBtn = (Button)findViewById(R.id.encBtn);
        decBtn = (Button)findViewById(R.id.decBtn);

        //set button encryption
        encBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                try{
                    outputString = encrypt(inputText.getText().toString(), inputPassword.getText().toString());
                    outputText.setText(outputString);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //set button decryption
        decBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                try {
                    outputString = decrypt(outputString,inputPassword.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(EncryptionActivity.this,"incorrect password",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                outputText.setText(outputString);
            }
        });




    }

    // the function of decrypt part with AES and decrypt_mdoe
    private String decrypt(String outputString, String password)throws Exception {
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedValue = Base64.decode(outputString, Base64.DEFAULT);
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    // the function of encrypt part with AES and decrypt_mdoe
    private String encrypt(String Data, String password) throws Exception{
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = Base64.encodeToString(encVal,Base64.DEFAULT);
        return encryptedValue;
    }
    // using the secret function that SHA256, it is a modern encryption method for sure
    private SecretKeySpec generateKey(String password) throws Exception{
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return  secretKeySpec;
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
            Intent intentprofile=new Intent(EncryptionActivity.this, HomeScreenActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_set){
            Intent intentprofile=new Intent(EncryptionActivity.this, SecondActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_card){
            Intent intentprofile=new Intent(EncryptionActivity.this, ListViewActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_appointment){
            Intent intentprofile=new Intent(EncryptionActivity.this, AppointmentActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Social){
            Intent intentprofile=new Intent(EncryptionActivity.this, SocialActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id==R.id.id_Encryption){
            Intent intentprofile=new Intent(EncryptionActivity.this, EncryptionActivity.class);
            startActivity(intentprofile);
            return true;
        }
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

