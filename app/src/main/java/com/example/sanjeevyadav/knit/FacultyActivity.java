package com.example.sanjeevyadav.knit;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class FacultyActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Animation nothingtocome;
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

        expandableLayout1=findViewById(R.id.expandablelayout1_faculty);
        expandableLayout2=findViewById(R.id.expandablelayout2_faculty);
        expandableLayout3=findViewById(R.id.expandablelayout3_faculty);
        expandableLayout4=findViewById(R.id.expandablelayout4_faculty);
        expandableLayout5=findViewById(R.id.expandablelayout5_faculty);
        expandableLayout6=findViewById(R.id.expandablelayout6_faculty);
        applied_button=findViewById(R.id.faculty_applied_button_id);
        civil_button=findViewById(R.id.faculty_civil_button_id);
        electrical_button=findViewById(R.id.faculty_electrical_button_id);
        electronic_button=findViewById(R.id.faculty_electronics_button_id);
        mechanical_button=findViewById(R.id.faculty_mechanical_button_id);
        computer_button=findViewById(R.id.faculty_computer_button_id);
        nothingtocome= AnimationUtils.loadAnimation(this,R.anim.nothingtocome);
        applied_button.startAnimation(nothingtocome);
        civil_button.startAnimation(nothingtocome);
        electrical_button.startAnimation(nothingtocome);
        electronic_button.startAnimation(nothingtocome);
        mechanical_button.startAnimation(nothingtocome);
        computer_button.startAnimation(nothingtocome);

        applied_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout1.toggle();
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
            }
        });
        civil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout2.toggle();
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
            }
        });
        electrical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout3.toggle();
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
            }
        });
        electronic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout4.toggle();
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
            }
        });
        mechanical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout5.toggle();
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
            }
        });
        computer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                expandableLayout6.toggle();
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
                if(expandableLayout5.isExpanded())
                {
                    expandableLayout5.collapse();
                }
            }
        });
    }
}
