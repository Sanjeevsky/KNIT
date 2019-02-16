package com.example.sanjeevyadav.knit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class FacultyActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button applied_button,civil_button,electrical_button,electronic_button,mechanical_button,computer_button;
    private ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3,expandableLayout4,expandableLayout5,expandableLayout6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        toolbar=findViewById(R.id.toolbar_id_faculty);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        applied_button=findViewById(R.id.faculty_applied_button_id);
        expandableLayout1=findViewById(R.id.expandablelayout1_faculty);
        applied_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout1.toggle();
            }
        });
        civil_button=findViewById(R.id.faculty_civil_button_id);
        expandableLayout2=findViewById(R.id.expandablelayout2_faculty);
        civil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout2.toggle();
            }
        });
        electrical_button=findViewById(R.id.faculty_electrical_button_id);
        expandableLayout3=findViewById(R.id.expandablelayout3_faculty);
        electrical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout3.toggle();
            }
        });
        electronic_button=findViewById(R.id.faculty_electronics_button_id);
        expandableLayout4=findViewById(R.id.expandablelayout4_faculty);
        electronic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout4.toggle();
            }
        });
        mechanical_button=findViewById(R.id.faculty_mechanical_button_id);
        expandableLayout5=findViewById(R.id.expandablelayout5_faculty);
        mechanical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout5.toggle();
            }
        });
        computer_button=findViewById(R.id.faculty_computer_button_id);
        expandableLayout6=findViewById(R.id.expandablelayout6_faculty);
        computer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout6.toggle();
            }
        });
    }
}
