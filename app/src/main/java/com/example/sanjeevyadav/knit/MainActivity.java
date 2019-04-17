package com.example.sanjeevyadav.knit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

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

        //Runs Only for First Time after Installation.
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        final String[] topic = {""};

        if (isFirstRun) {
            //show start activity
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(false);
            builder.setTitle("Continue As");

// add a list
            String[] credentials = {"Faculty", "Student"};
            builder.setItems(credentials, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            topic[0] +="Faculty";
                            break;
                        case 1:
                            topic[0] +="Student";
                            break;

                    }
                    runSecondDialog(topic);
                }
            });

// create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }



        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                // send it to server
                //Toast.makeText(MainActivity.this,"Token "+token,Toast.LENGTH_LONG).show();
            }
        });
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

    private void runSecondDialog(final String[] topic) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(false);
            builder.setTitle("Choose Your Department");

// add a list
            String[] animal = {"Civil", "Computer Science", "Electrical", "Electronic", "Mechanical","Information Technology","MCA"};
            builder.setItems(animal, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            topic[0]+="_Civil";
                            break;
                        case 1:
                            topic[0]+="_Computer_Science";
                            break;
                        case 2:
                            topic[0]+="_Electrical";
                            break;
                        case 3:
                            topic[0]+="_Electronic";
                            break;
                        case 4:
                            topic[0]+="_Mechanical";
                            break;
                        case 5:
                            topic[0]+="_Information_Technology";
                            break;
                        case 6:
                            topic[0]+="_MCA";
                            break;
                    }

                    saveTopic(topic);
                }
            });

// create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();


    }

    private void saveTopic(final String[] topic) {
        Toast.makeText(MainActivity.this,topic[0],Toast.LENGTH_LONG).show();
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            // Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Toast.makeText(MainActivity.this, "Instance Created", Toast.LENGTH_SHORT).show();

                    }
                });

        FirebaseMessaging.getInstance().subscribeToTopic(topic[0])
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfully Subscribe to"+topic[0];
                        if (!task.isSuccessful()) {
                            msg = "Failed To Subscribe Branch";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
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
