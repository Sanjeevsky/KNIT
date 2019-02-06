package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class StudentActivity extends AppCompatActivity {
    ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3,expandableLayout4,expandableLayout5;
    Button StudentAcademicsButton,UpdateStudentProfile,DownloadProvisionalCerti,StudentWelfare,StudentBodies;
    Button t1,t2,t3;
    TextView text,text2,text3;
    ImageView Image1,Image2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        StudentAcademicsButton =findViewById(R.id.student_academics_btn);
        UpdateStudentProfile=findViewById(R.id.update_student_profile);
        DownloadProvisionalCerti=findViewById(R.id.download_provisional_certi);
        StudentWelfare=findViewById(R.id.student_welfare);
        StudentBodies=findViewById(R.id.student_bodies);
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        StudentAcademicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1 = findViewById(R.id.expandableLayout1);

                t1=findViewById(R.id.button_id1);
                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent studentIntent=new Intent(StudentActivity.this,webview_acticity.class);
                        studentIntent.putExtra("url","http://knit.ac.in/academics/Login.aspx");
                        startActivity(studentIntent);
                    }
                });
                expandableLayout1.toggle();
            }
        });
    UpdateStudentProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            expandableLayout2 = findViewById(R.id.expandableLayout2);

            t2=findViewById(R.id.button_id2);
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent studentIntent=new Intent(StudentActivity.this,webview_acticity.class);
                    studentIntent.putExtra("url","http://knit.ac.in/online/views/user/login.aspx");
                    startActivity(studentIntent);
                }
            });
            expandableLayout2.toggle();
        }
    });
           DownloadProvisionalCerti.setOnClickListener(new View.OnClickListener() {
               @Override
                   public void onClick(View v) {
                       expandableLayout3 = findViewById(R.id.expandableLayout3);

                       t3=findViewById(R.id.button_id3);
                       t3.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               Intent studentIntent=new Intent(StudentActivity.this,webview_acticity.class);
                               studentIntent.putExtra("url","http://knit.ac.in/academics/Provisional/FrmProvisional.aspx");
                               startActivity(studentIntent);
                           }
                       });
                   expandableLayout3.toggle();
                   }

           });

        text=findViewById(R.id.text_id);
        text.setText(Html.fromHtml(getString(R.string.html)));

           StudentWelfare.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   expandableLayout4=findViewById(R.id.expandableLayout4);
                   expandableLayout4.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                       }
                   });
                   expandableLayout4.toggle();
               }

           });
           text2=findViewById(R.id.text_id1);
           text2.setText(Html.fromHtml(getString(R.string.student_body1)));
           text3=findViewById(R.id.text_id2);
           text3.setText(Html.fromHtml(getString(R.string.student_body2)));
           Image1=findViewById(R.id.img1);
           Image2=findViewById(R.id.img2);

           StudentBodies.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   expandableLayout5=findViewById(R.id.expandableLayout5);
                   expandableLayout5.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                       }
                   });
                   expandableLayout5.toggle();
               }
           });



    }
}
