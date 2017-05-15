package com.example.john.bookdeals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class App_AfterSplash extends AppCompatActivity implements View.OnClickListener{

    Button skip,login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app__after_splash);

        skip=(Button)findViewById(R.id.skipbutton);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);


        skip.setOnClickListener(this);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==skip)
        {
            Intent i=new Intent(App_AfterSplash.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        if(v==login)
        {
            Intent i=new Intent(App_AfterSplash.this,App_Login.class);
            startActivity(i);

        }
        if(v==signup)
        {
            Intent i=new Intent(App_AfterSplash.this,App_SignUp.class);
            startActivity(i);


        }


    }
}
