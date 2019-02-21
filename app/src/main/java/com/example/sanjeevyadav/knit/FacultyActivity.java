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

        expandableLayout1=findViewById(R.id.expandablelayout1_faculty);
        expandableLayout2=findViewById(R.id.expandablelayout2_faculty);
        expandableLayout3=findViewById(R.id.expandablelayout3_faculty);
        expandableLayout4=findViewById(R.id.expandablelayout4_faculty);
        expandableLayout5=findViewById(R.id.expandablelayout5_faculty);
        expandableLayout6=findViewById(R.id.expandablelayout6_faculty);

        applied_button=findViewById(R.id.faculty_applied_button_id);
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
        civil_button=findViewById(R.id.faculty_civil_button_id);
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
        electrical_button=findViewById(R.id.faculty_electrical_button_id);
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
        electronic_button=findViewById(R.id.faculty_electronics_button_id);
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
        mechanical_button=findViewById(R.id.faculty_mechanical_button_id);
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
        computer_button=findViewById(R.id.faculty_computer_button_id);
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
