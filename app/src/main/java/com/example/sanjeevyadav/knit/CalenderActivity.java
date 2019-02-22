package com.example.sanjeevyadav.knit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CalenderActivity extends AppCompatActivity {
    private ImageView imageView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        toolbar=findViewById(R.id.toolbar_id_cal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calendar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageView=findViewById(R.id.calender_img);
        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/knit-app-94130.appspot.com/o/Calender%2Fcalender.jpg?alt=media&token=9e5778c3-9e66-4b24-ba43-fd7486a67eb5").into(imageView);
    }
}
