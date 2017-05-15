package com.example.john.bookdeals;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class App_Login extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor ep;
    public static final String PREFS_NAME = "MyPrefsFile";

    public static ProgressDialog pd;
    public static final String UrlLogin="http://thetechnophile.000webhostapp.com/login_bookdeals.php";
    public static final String KEY_USERNAME="email";
    public static final String KEY_PASSWORD="pwd";

    private EditText etusername,etpassword;
    Button buttonLogin;

    private String username=null,password=null;

     Button t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app__login);

        sp=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        ep=sp.edit();
        ep.apply();

        etusername=(EditText)findViewById(R.id.editTextemail);
        etpassword=(EditText)findViewById(R.id.editTextpassword);


        buttonLogin=(Button)findViewById(R.id.loginfinally);
        
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(App_Login.this);
                pd.setCancelable(false);
                pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                pd.show();
                userLogin();
                pd.dismiss();
                Intent ee=new Intent(App_Login.this,MainActivity.class);
                startActivity(ee);
            }
        });


        t=(Button) findViewById(R.id.adb);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(App_Login.this,App_SignUp.class);
                startActivity(i);
            }
        });

    }

    private void userLogin() {
        username=etusername.getText().toString().trim();
        password=etpassword.getText().toString().trim();

        ep.putString("Key_User",username);
        ep.putString("Key_Pass",password);
        ep.putBoolean("login",true);
        ep.commit();


        StringRequest st=new StringRequest(Request.Method.POST, UrlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("Successful Login")) {
                    openProfile();
                }
                else {
                    Toast.makeText(App_Login.this,"Unable To Login",Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                etpassword.setError("Wrong Username/Passsword");
            }

        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put(KEY_USERNAME,username);
                parameters.put(KEY_PASSWORD,password);

                return parameters;

            }

        };
        RequestQueue rq= Volley.newRequestQueue(App_Login.this);
        rq.add(st);

    }

    private void openProfile() {
        Intent ii=new Intent(this,MainActivity.class);
        startActivity(ii);
    }
}
