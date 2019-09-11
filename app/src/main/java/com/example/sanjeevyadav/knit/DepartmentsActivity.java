package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class DepartmentsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Animation nothingtocome;
    private Button applied_button,civil_button,electrical_button,electronics_button,mechanical_button,computer_button,workshop_button,library_button;
    private TextView applied_textview,civil_textview,electrical_textview,electronics_textview,mechanical_textview,computer_textview,workshop_textview,workshop_textview2,computer_textvie2,library_textview,library_textview2;
    private ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3,expandableLayout4,expandableLayout5,expandableLayout6,expandableLayout7,expandableLayout8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        toolbar=findViewById(R.id.toolbar_id_departments);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Department");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        expandableLayout1=findViewById(R.id.expandablelayout1_depart);
        expandableLayout2=findViewById(R.id.expandablelayout2_depart);
        expandableLayout3=findViewById(R.id.expandablelayout3_depart);
        expandableLayout4=findViewById(R.id.expandablelayout4_depart);
        expandableLayout5=findViewById(R.id.expandablelayout5_depart);
        expandableLayout6=findViewById(R.id.expandablelayout6_depart);
        expandableLayout7=findViewById(R.id.expandablelayout7_depart);
        expandableLayout8=findViewById(R.id.expandablelayout8_depart);
        applied_button=findViewById(R.id.department_id_applied_science);
        civil_button=findViewById(R.id.department_id_civil_engi);
        electrical_button=findViewById(R.id.department_id_electrical_engi);
        electronics_button=findViewById(R.id.department_id_electronics_engi);
        mechanical_button=findViewById(R.id.department_id_mechanical_engi);
        computer_button=findViewById(R.id.department_id_computer_engi);
        workshop_button=findViewById(R.id.department_id_workshop);
        library_button=findViewById(R.id.department_id_library);

        nothingtocome=AnimationUtils.loadAnimation(this,R.anim.nothingtocome);
        applied_button.startAnimation(nothingtocome);
        civil_button.startAnimation(nothingtocome);
        electrical_button.startAnimation(nothingtocome);
        electronics_button.startAnimation(nothingtocome);
        mechanical_button.startAnimation(nothingtocome);
        computer_button.startAnimation(nothingtocome);
        workshop_button.startAnimation(nothingtocome);
        library_button.startAnimation(nothingtocome);

        applied_textview=findViewById(R.id.applied_textview_id);
        applied_textview.setText(Html.fromHtml("<p>  \n" +
                "The Applied Sciences and Humanities Department is an allied department which serves as a\n" +
                "bedrock for the engineering departments of the Institute. The department takes care of core\n" +
                "subjects like Mathematics, Physics, Chemistry and Professional communications. The department\n" +
                "has competent and knowledgeable faculty and well equipped laboratories.<br><br>\n" +
                "<h3><font color =\"#5F0D0D\">Laboratories</h3>\n" +
                "<ul class=\"UL1\">" +
                "<li>Chemistry Lab</li><br>" +
                "<li>Laser Lab</li><br>" +
                "<li>Physics Lab</li><br>" +
                "<li>Departmental Computer Centre</li><br>" +
                "<li>Professional Communications Lab</li><br>" +
                "</ul>" +
                "</p>"));
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        civil_textview=findViewById(R.id.civil_textview_id);
        civil_textview.setText(Html.fromHtml(" The Civil Engineering Department is one of the oldest departments of the institute. The department\n" +
                "has a well qualified faculty and technical supporting staff. The department offers U.G. as well as\n" +
                "P.G. (FullTime)\n" +
                "and P.G. (PartTime)\n" +
                "courses. All the laboratories of the department are well\n" +
                "equipped with modern equipments. The department has acquired state of the art\n" +
                "equipments\n" +
                "through World Bank assisted TEQIP programme.<br><br>\n" +
                "<h3><font color=\"#5F0D0D\">Laboratories</h3>\n" +
                "<ul class=\"UL1\">\n" +
                "<li>Environmental Engineering Laboratory</li><br>" +
                "<li>Hydraulics Laboratory</li><br>" +
                "<li>Geotechnical Engineering Laboratory</li><br>" +
                "<li>Geology Laboratory</li><br>" +
                "<li>Transportation Laboratory</li><br>" +
                "<li>Rock Mechanics Laboratory</li><br>" +
                "<li>Structures Laboratory</li><br>" +
                "<li>Departmental Computer centre</li><br>" +
                "<li>Survey Laboratory</li><br>" +
                "<li>Graphics laboratory</li><br>" +
                "<li>Concrete Laboratory</li><br>" +
                "</ul>"));
        civil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        electrical_textview=findViewById(R.id.electrical_textview_id);
        electrical_textview.setText(Html.fromHtml(" The Electrical Engineering Department is also one of the oldest departments of the Institute. The\n" +
                "department has a well qualified faculty and technical supporting staff. All the laboratories of the\n" +
                "department are well equipped with modern equipments. The department offers U.G. as well as P.G.\n" +
                "(FullTime)\n" +
                "and P.G. (PartTime)\n" +
                "courses. The department has acquired stateoftheart\n" +
                "equipments\n" +
                "through World Bank assisted TEQIP programme. The department is also developing Power\n" +
                "Electronics Centre under the grant received from MHRD, New Delhi.\n" +
                "<br>\n" +
                "<br>\n" +
                "\n" +
                "<h3><font color=\"#5F0D0D\">Laboratories</h3>\n" +
                "\n" +
                "<ul class=\"UL1\">\n" +
                "<li>Electrical Science Lab.</li><br>" +
                "<li>Electrical Machines lab</li><br>" +
                "<li>Electrical Measurement Lab</li><br>" +
                "<li>Electrical Instrumentation Lab</li><br>" +
                "<li>Control Systems lab</li><br>" +
                "<li>Microprocessors Lab</li><br>" +
                "<li>PC & Simulation Lab</li><br>" +
                "<li>Power Electronics Lab</li><br>" +
                "<li>Power Systems lab</li><br>" +
                "<li>High Voltage Eng. lab</li><br>" +
                "</ul>\n"));
        electrical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        electronics_textview=findViewById(R.id.electronics_textview_id);
        electronics_textview.setText(Html.fromHtml(" The Electronics Engineering Department offers both U.G. and P.G. (PartTime)\n" +
                "courses. It has a\n" +
                "well qualified faculty and technical supporting staff. All the laboratories of the department are well\n" +
                "equipped with modern equipments. The department has also acquired stateoftheart\n" +
                "equipments\n" +
                "through World Bank assisted TEQIP programme.\n" +
                "<br>\n" +
                "<br>\n" +
                "\n" +
                "\n" +
                "<br>\n" +
                "<h3><font color=\"#5F0D0D\">Laboratories</h3>\n" +
                "\n" +
                "</ul><ul class=\"UL1\">\n" +
                "<li>Semiconductor Devices lab</li><br>" +
                "<li>Digital Electronics Lab</li><br>" +
                "<li>Digital Signal Processing Lab</li><br>" +
                "<li>Computer Simulation Lab</li><br>" +
                "<li>Digital Signal & Speech Processing Lab</li><br>" +
                "<li>Digital & Optical Communications Lab</li><br>" +
                "<li>Analog Communications Lab</li><br>" +
                "<li>T.V. & Satellite Communications Lab</li><br>" +
                "<li>Biomedical Electronics Lab</li><br>" +
                "<li>Microwave & Radar Lab </li><br>" +
                "<li>Electronic Measurement &<br>" +
                "Instrumentation Lab </li><br>" +
                "<li>Electronic Workshop & PCB Lab </li><br>" +
                "</ul>\n"));
        electronics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        mechanical_textview=findViewById(R.id.mechanical_textview_id);
        mechanical_textview.setText(Html.fromHtml("The Mechanical Engineering Department is among the oldest departments of the Institute. The\n" +
                "department has a well qualified faculty and technical supporting staff. All the laboratories of the\n" +
                "department are well equipped with modern equipments. The department offers U.G. as well as\n" +
                "P.G. (FullTime)\n" +
                "and P.G. (PartTime)\n" +
                "courses. The department has acquired state of the art\n" +
                "equipments through World Bank assisted TEQIP programme.<br>\n" +
                "<br>\n" +
                "\n" +
                "\n" +
                "<br>\n" +
                "<h3><font color=\"#5F0D0D\">Laboratories</h3>\n" +
                "\n" +
                "<ul class=\"UL1\">\n" +
                "<li>Refrigeration & Air Conditioning Lab</li><br>" +
                "<li>Heat & Mass Transfer Lab</li><br>" +
                "<li>I.C. Engines & Automotive Vehicles Lab</li><br>" +
                "<li>Steam power Lab</li><br>" +
                "<li>Fluid Machinery Lab</li><br>" +
                "<li>Wind Energy Lab</li><br>" +
                "<li>KOM & Vibration Lab</li><br>" +
                "<li>CAM & FMS Lab</li><br>" +
                "<li>Engineering Mechanics & M.O.S. Lab</li><br>" +
                "<li>Tribology Lab</li><br>" +
                "<li>Material Sciences Lab</li><br>" +
                "<li>Production Engineering Lab</li><br>" +
                "<li>Metrology and Measurement lab</li><br>" +
                "<li>CAD Lab</li><br>" +
                "<li>Bio Gas Lab</li><br>" +
                "</ul>\n"));
        mechanical_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        computer_textview=findViewById(R.id.computer_textview_id);
        computer_textview.setText(Html.fromHtml("Computer Science &amp; Engineering Department is the largest department of the Institute. It offers\n" +
                "B.Tech. (Computer Science. &amp; Engineering), B.Tech. (Information Technology) and MCA\n" +
                "programmes. The Department is well equipped with high end computers, latest software &amp; state of          \n" +
                "the art \n" +
                "IT infrastructure. All computing resources are interconnected\n" +
                "with high speed internet. The\n" +
                "campus wide Networking facility is also managed by the department.\n" +
                "The Department has a well qualified faculty and several well equipped laboratories catering to the\n" +
                "needs of not only the CSE, IT and MCA students but also students from other departments. The present infrastructure is sufficient enough to carry out research and other academic work by UG\n" +
                "and PG students. The Department has following Computing facilities/Laboratories.<br>\n" +
                "<br><h3><font color=\"#5F0D0D\">(1) Computer Centre</h3>\n" +
                "The Department has excellent Centrally Air Conditioned Computer centre\n" +
                "consisting of about 6 servers &amp; 120 Machines, Various types of Printers, scanners etc etc. Latest &amp;\n" +
                "required soft wares are loaded on the Servers &amp; Computers hence the centre is catering the need\n" +
                "of following laboratories.<br>\n"));
        computer_textvie2=findViewById(R.id.computer_textview_id2);
        computer_textvie2.setText(Html.fromHtml("<br><h3><font color=\"#5F0D0D\">(2) Computing Lab</h3> \n" +
                "This lab consists of about one server &amp; 30 Computers, Printers etc.\n" +
                "<br><br>\n" +
                "</ul><br><h3><font color=\"#5F0D0D\">M.C.A. Department</h3>\n" +
                "\n" +
                "\n" +
                "The Department offers 3 year PG degree in M.C.A. The department has a well qualified faculty, well\n" +
                "equipped laboratories and the infrastructure. Prof. A K Malviya Head, Computer Science and\n" +
                "Engineering Department is also looking after the affairs of the M.C.A. department as Head.<br>\n" +
                "\n"));
        computer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
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
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        workshop_textview=findViewById(R.id.workshop_textview_id);
        workshop_textview.setText(Html.fromHtml("The workshop of the Institute sprawls over a large area having Fitting, Carpentry, Blacksmith,\n" +
                "Welding, Foundry, Sheet Metal and Sand Testing Shops. Besides above, the workshop has an\n" +
                "excellent Machine Shop with various kinds of stateoftheart\n" +
                "machines of industry standards\n" +
                "including the EDM. The workshop has also been modernized under World Bank assisted TEQIP\n" +
                "programme.<br>\n"));
        workshop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                expandableLayout7.toggle();
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
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
                if(expandableLayout8.isExpanded()){
                    expandableLayout8.collapse();
                }
            }
        });
        workshop_textview2=findViewById(R.id.workshop_textview_id2);
        workshop_textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workshopintent=new Intent(DepartmentsActivity.this,webview_acticity.class);
                workshopintent.putExtra("pdf","http://knit.ac.in/pdf/workshop%20major_equipments.pdf");
                startActivity(workshopintent);
            }
        });
        library_textview=findViewById(R.id.library_textview_id);
        library_textview.setText(Html.fromHtml("Library is the soul of any professional institute. All the departments have also their own\n" +
                "departmental libraries. The Central Library of the Institute is spacious, well equipped and fully\n" +
                "automated. Presently it has around 50000 books consisting both of Indian and Foreign authors and\n" +
                "bound journal volumes. The central library subscribes a good number of reputed Indian andInternational journals in engineering subjects as well as in sciences and humanities and also has\n" +
                "access to several ejournals.\n" +
                "The students and staff have a free access to books and journals in the\n" +
                "Library. The central library also offers Book Bank facility to the students through which every\n" +
                "student can get five books issued free of charge in each semester. The Central Library ordinarily\n" +
                "functions from 10 am to 8 pm. The Library has been greatly benefited under World Bank assisted\n" +
                "TEQIP programme. Library rules are given in AnnexureI.<br>\n"));
        library_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                expandableLayout8.toggle();
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
                if(expandableLayout5.isExpanded()){
                    expandableLayout5.collapse();
                }
                if(expandableLayout6.isExpanded())
                {
                    expandableLayout6.collapse();
                }
                if(expandableLayout7.isExpanded()){
                    expandableLayout7.collapse();
                }
            }
        });
        library_textview2=findViewById(R.id.library_textview_id2);
        library_textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libraryIntent=new Intent(DepartmentsActivity.this,webview_acticity.class);
                libraryIntent.putExtra("pdf","http://knit.ac.in/pdf/library_at_a_glance.pdf");
                startActivity(libraryIntent);
            }
        });
    }
}
