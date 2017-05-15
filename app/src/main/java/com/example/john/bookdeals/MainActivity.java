package com.example.john.bookdeals;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.john.bookdeals.navigation.App_AboutUs;
import com.example.john.bookdeals.navigation.App_Home;
import com.example.john.bookdeals.navigation.App_PostAds;
import com.example.john.bookdeals.navigation.App_Profile;
import com.example.john.bookdeals.navigation.App_RateUs;


public class MainActivity extends AppCompatActivity{

    DrawerLayout drawer=null;
    FragmentTransaction fragmentTransaction=null;
    NavigationView navigationView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer= (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment,new App_Home());
        fragmentTransaction.commit();

        navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment,new App_Home());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        drawer.closeDrawers();
                        break;


                    case R.id.nav_profile:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment,new App_Profile());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("User Profile");
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_postad:

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment,new App_PostAds());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Post Ads");
                        drawer.closeDrawers();
                        break;


                    case R.id.nav_feedback:
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"himanshusaini299@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, "(Book Deals) User Feedback:");
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Send Email:"));
                        break;


                    case R.id.nav_rateus:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment,new App_RateUs());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Rate Us");
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_aboutus:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment,new App_AboutUs());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About Us");
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_share:

                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Book Deals");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Buy or Sell Old Books Here:");
                        startActivity(Intent.createChooser(sharingIntent, "Share via:"));

                        drawer.closeDrawers();
                        break;
                }

                return true;
            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
