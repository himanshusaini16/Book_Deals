package com.example.john.bookdeals;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.Timer;
import java.util.TimerTask;

public class App_SignUp extends AppCompatActivity {

    ProgressDialog pd;
    public static final String url="http://thetechnophile.000webhostapp.com/signup_bookdeals.php";
    public static Button sgnup;
    public static TextInputLayout nameW,usernameW,passW,repassW;
    public static EditText name,email,pass,repass;
    public static String uname,uemail,upass,urepass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app__sign_up);

        name=(EditText)findViewById(R.id.signupusername);
        email=(EditText)findViewById(R.id.signupemail);
        pass=(EditText)findViewById(R.id.signuppassword);
        repass=(EditText)findViewById(R.id.signuprepassword);

        nameW=(TextInputLayout)findViewById(R.id.nameWrapper);
        usernameW=(TextInputLayout)findViewById(R.id.usernameWrapper);
        passW=(TextInputLayout)findViewById(R.id.passwordWrapper);
        repassW=(TextInputLayout)findViewById(R.id.repasswordWrapper);
        nameW.setHint("Full Name");
        usernameW.setHint("Email");
        passW.setHint("Password");
        repassW.setHint("Confirm Password");


        sgnup=(Button)findViewById(R.id.signupfinally);

        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=name.getText().toString().trim();
                uemail=email.getText().toString().trim();
                upass=pass.getText().toString().trim();
                urepass=repass.getText().toString().trim();

               if(uemail.equals("")||!android.util.Patterns.EMAIL_ADDRESS.matcher(uemail).matches())
               {
                   email.setError("Invalid Email Address");
               }
               else if(uname.equals(""))
                {
                    name.setError("Invalid or Empty Fields");
                }
               else if(!upass.equals(urepass))
                {
                    repass.setError("Password Do Not Match");
                }
               else if (upass.isEmpty()||urepass.isEmpty()|| upass.length() < 4 || upass.length() > 15) {
                    pass.setError("Password At Least 4-10 Characters");

                }
                else {
                    pd = new ProgressDialog(App_SignUp.this);
                    pd.setCancelable(false);
                    pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                    pd.show();
                    signUpUser();
                    pd.dismiss();
                    Intent i=new Intent(App_SignUp.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        });
    }


    public void signUpUser() {


        StringRequest st=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(App_SignUp.this,"Unable to Sign Up",Toast.LENGTH_LONG).show();
            }

        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("user_nm",uname);
                parameters.put("email",uemail);
                parameters.put("pwd",upass);
                parameters.put("re_pwd",urepass);
                return parameters;

            }

        };


        RequestQueue rq= Volley.newRequestQueue(App_SignUp.this);
        rq.add(st);

    }

}
