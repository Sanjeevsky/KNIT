package com.example.sanjeevyadav.knit;


import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    private boolean doubleBackToExitPressedOnce = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar= (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        viewPager=(ViewPager) findViewById(R.id.viewPager_id);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(),"Main");
        adapter.addFragment(new NewsFragment(),"News Updates");

        viewPager.setAdapter(adapter);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout_id);
        tabLayout.setupWithViewPager(viewPager);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_id);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }



    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
            else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = true;
                }
            }, 2000);
                if (doubleBackToExitPressedOnce) {
                    this.doubleBackToExitPressedOnce = false;
                    Toast.makeText(this,"Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.director_id:
                Intent dirInent=new Intent(MainActivity.this,DirectorActivity.class);
                startActivity(dirInent);
                break;

            case R.id.adminstration_id:
                Intent adminInent=new Intent(MainActivity.this,AdminstrationActivity.class);
                startActivity(adminInent);
                break;

            case R.id.contacts_id:
                Intent contInent=new Intent(MainActivity.this,ContactsActivity.class);
                startActivity(contInent);
                break;
            case R.id.login_menu_id:
                Intent LoginInent=new Intent(MainActivity.this,LoginIndexActivity.class);
                startActivity(LoginInent);
                break;
            case R.id.department_id:
                Intent depratInent=new Intent(MainActivity.this,DepartmentsActivity.class);
                startActivity(depratInent);
                break;

            case R.id.faculty_id:
                Intent facultyIntent=new Intent(MainActivity.this,FacultyActivity.class);
                startActivity(facultyIntent);
                break;
            case R.id.developers:
                Intent devIntent=new Intent(MainActivity.this,DevelopersActivity.class);
                startActivity(devIntent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
