package com.example.sanjeevyadav.knit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText Email,Password;
    private FirebaseAuth mAuth;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Email=findViewById(R.id.login_username);
        Password=findViewById(R.id.login_user_password);
        LoginButton=findViewById(R.id.login_btn);
        mAuth=FirebaseAuth.getInstance();
        loadingBar=new ProgressDialog(this);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    loadingBar.create();
                    loadingBar.setTitle("Logging In");
                    loadingBar.setMessage("Please Wait");
                    loadingBar.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                loadingBar.dismiss();
                                Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                Intent startIntent = new Intent(AdminLoginActivity.this, DatabaseEntryActivity.class);
                                startActivity(startIntent);
                            } else {
                                Toast.makeText(AdminLoginActivity.this, "" + task.getException(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else {
                    loadingBar.dismiss();
                    Toast.makeText(AdminLoginActivity.this, "Enter Email And Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
