package com.example.john.bookdeals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class App_Splash extends AppCompatActivity {

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_app__splash);
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);




        Thread tp = new Thread() {
            public void run() {
                try {
                    sleep(1000);

                } catch (Exception e) {
                    Toast.makeText(App_Splash.this,""+e,Toast.LENGTH_SHORT).show();
                }
                finally {

                    sp=getSharedPreferences(App_Login.PREFS_NAME,MODE_PRIVATE);

                    boolean isloggin =sp.getBoolean("login",false);
                    if(isloggin)
                    {
                        Intent ss=new Intent(App_Splash.this,MainActivity.class);
                        startActivity(ss);
                        finish();
                    }
                    else {
                        Intent ss=new Intent(App_Splash.this,App_AfterSplash.class);
                        startActivity(ss);
                        finish();
                    }

                }
            }
        };
        tp.start();



    }


    }

