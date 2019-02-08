package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        viewPager=(ViewPager)findViewById(R.id.viewPager_id);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(),"Main");
        adapter.addFragment(new NewsFragment(),"News Updates");

        viewPager.setAdapter(adapter);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout_id);
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
        }else{
            super.onBackPressed();
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

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
