package com.example.sanjeevyadav.knit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class WelcomeActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
        final Handler handler1 = new Handler();
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 10;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler1.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                }
            }
        });

        //Runs Only for First Time after Installation.
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        final String[] topic = {""};

        if (isFirstRun) {
            //show start activity
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
            builder.setCancelable(false);
            builder.setTitle("Continue As");

// add a list
            String[] credentials = {"Faculty", "Student"};
            builder.setItems(credentials, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            topic[0] += "Faculty";
                            break;
                        case 1:
                            topic[0] += "Student";
                            break;

                    }
                    runSecondDialog(topic);
                }
            });

// create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }

//
//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
//            @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//                String token = instanceIdResult.getToken();
//                // send it to server
//                //Toast.makeText(MainActivity.this,"Token "+token,Toast.LENGTH_LONG).show();
//            }
//        });

        if (!isFirstRun) {
            new Handler().postDelayed(new Runnable() {

                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

                @Override
                public void run() {
//                             /This method will be executed once the timer is over
//                             Start your app main activity
                    Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, 4000);

        }
    }

    private void runSecondDialog(final String[] topic) {

        AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
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
        Toast.makeText(WelcomeActivity.this,topic[0],Toast.LENGTH_LONG).show();
//        FirebaseInstanceId.getInstance().getInstanceId()
//                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                        if (!task.isSuccessful()) {
//                            // Log.w(TAG, "getInstanceId failed", task.getException());
//                            return;
//                        }
//
//                        // Get new Instance ID token
//                        String token = task.getResult().getToken();
//                       // Toast.makeText(WelcomeActivity.this, "Instance Created", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//

        FirebaseMessaging.getInstance().subscribeToTopic(topic[0])
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfully Subscribe to"+topic[0];
                        if (!task.isSuccessful()) {
                            msg = "Failed To Subscribe Branch";
                            Toast.makeText(WelcomeActivity.this, "Connect To Internet And Restart App", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(WelcomeActivity.this, msg, Toast.LENGTH_SHORT).show();
                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                                .putBoolean("isFirstRun", false).apply();
                    }
                });


        Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(i);

        // close this activity
        finish();
    }

}

