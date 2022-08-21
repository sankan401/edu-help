package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    Toolbar toolbar;




       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView) findViewById(R.id.nav_menu);
        drawer =(DrawerLayout) findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

           getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            Fragment demo;

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.menu_home:

                        demo=new HomeFragment();

                        Toast.makeText(getApplicationContext(),"Home ",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,demo).commit();

                        break;
                    case R.id.menu_course:


                   startActivity(new Intent(MainActivity.this,CourseActivity.class));
                        Toast.makeText(getApplicationContext(),"Course ",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,demo).addToBackStack(null).commit();
                        break;

                    case R.id.menu_Mock:

                        startActivity(new Intent(MainActivity.this,Mocksection.class));
                        Toast.makeText(getApplicationContext(),"Course ",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,demo).addToBackStack(null).commit();
                        break;

                    case R.id.menu_about:
                        demo=new AboutFragment();

                        Toast.makeText(getApplicationContext(),"About ",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,demo).addToBackStack(null).commit();

                        break;
                    case R.id.menu_contact:
                        demo=new ContactFragment();
                        Toast.makeText(getApplicationContext(),"Contact ",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,demo).addToBackStack(null).commit();

                        break;

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dot_icon,menu);
        return super.onCreateOptionsMenu(menu);
    }



}