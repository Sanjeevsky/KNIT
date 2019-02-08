package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginIndexActivity extends AppCompatActivity {
    private Button DirectorLoginButton,ContentProviderButton,DeveloperLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_index);
    DirectorLoginButton=findViewById(R.id.directorImgButton);
    ContentProviderButton=findViewById(R.id.contentLoginButton);
    DeveloperLoginButton=findViewById(R.id.developerButton);

    DirectorLoginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent dirIntent=new Intent(LoginIndexActivity.this,AdminLoginActivity.class);
            startActivity(dirIntent);

        }
    });
    ContentProviderButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ContentIntent=new Intent(LoginIndexActivity.this, AdminLoginActivity.class);
            startActivity(ContentIntent);

        }
    });

    DeveloperLoginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent devIntent=new Intent(LoginIndexActivity.this,AdminLoginActivity.class);
        startActivity(devIntent);
        }
    });

    }
}
