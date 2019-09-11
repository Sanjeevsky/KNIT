package com.example.sanjeevyadav.knit;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class CalenderActivity extends AppCompatActivity {

    private ImageView imageView;
    private Toolbar toolbar;
    private ProgressDialog loadingBar;

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
        loadingBar=new ProgressDialog(this);
        loadingBar.create();
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.setTitle("Loading...!!!");
        loadingBar.setMessage("Loading File Please Wait...!!!");
        loadingBar.show();
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(isConnected)
        {
            Glide.with(this)
                    .load("https://firebasestorage.googleapis.com/v0/b/knit-app-94130.appspot.com/o/Calender%2Fcalender.jpg?alt=media&token=9e5778c3-9e66-4b24-ba43-fd7486a67eb5")
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            loadingBar.dismiss();
                            Toast.makeText(CalenderActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            loadingBar.dismiss();
                            return false;
                        }
                    }).into(imageView);
        }
        else
        {
            Toast.makeText(CalenderActivity.this,"Device is not connected to internet",Toast.LENGTH_LONG).show();
        }
    }
}
