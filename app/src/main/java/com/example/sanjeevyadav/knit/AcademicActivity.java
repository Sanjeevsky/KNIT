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

public class AcademicActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Animation nothingtocome;
    private Button admissionButton,feeButton,placementButton,coursestudyButton;
    private TextView admissionTextview,feeTextview,feeFirst,feeSecond,placementTextview,coursestudyTextview,coursestudyTextview1;
    private ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3,expandableLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        toolbar=findViewById(R.id.toolbar_id_academic);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Academics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        expandableLayout1=findViewById(R.id.expandablelayout1_academic);
        expandableLayout2=findViewById(R.id.expandablelayout2_academic);
        expandableLayout3=findViewById(R.id.expandablelayout3_academic);
        expandableLayout4=findViewById(R.id.expandablelayout4_academic);

        admissionButton=findViewById(R.id.admission_button_id);
        coursestudyButton=findViewById(R.id.coursestudy_button_id);
        placementButton=findViewById(R.id.placement_button_id);
        feeButton=findViewById(R.id.fee_button_id);

        nothingtocome=AnimationUtils.loadAnimation(this,R.anim.nothingtocome);
        admissionButton.startAnimation(nothingtocome);
        feeButton.startAnimation(nothingtocome);
        placementButton.startAnimation(nothingtocome);
        coursestudyButton.startAnimation(nothingtocome);

        admissionTextview=findViewById(R.id.admission_textview_id);
        admissionTextview.setText(Html.fromHtml(getString(R.string.academic_admission)));
        admissionButton.setOnClickListener(new View.OnClickListener() {
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
            }
        });

        feeTextview=findViewById(R.id.fee_textview_id);
        feeTextview.setText(Html.fromHtml("<h3><font color=\"#5F0D0D\">FEE AND OTHER CHARGES FOR FIRST YEAR STUDENTS</h3>\n" +
                "The schedule of fee  to be paid by each student of First Year B.Tech, M.C.A., M.Tech., (Full Time) &amp; M.Tech (Part Time) is given below :<br>\n" +
                "\n"));
        feeButton.setOnClickListener(new View.OnClickListener() {
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
            }
        });
        feeFirst=findViewById(R.id.feefrist_id);
        feeSecond=findViewById(R.id.feeSecond_id);
        feeFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feeFirstIntent=new Intent(AcademicActivity.this,webview_acticity.class);
                feeFirstIntent.putExtra("pdf","http://www.knit.ac.in/pdf/fees_150617.pdf");
                startActivity(feeFirstIntent);
            }
        });
        feeSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feeSecondIntent=new Intent(AcademicActivity.this,webview_acticity.class);
                feeSecondIntent.putExtra("pdf","http://www.knit.ac.in/pdf/notice_21july16.pdf");
                startActivity(feeSecondIntent);
            }
        });

        placementTextview=findViewById(R.id.placement_textview_id);
        placementTextview.setText(Html.fromHtml("<h3><font color=\"#5F0D0D\">Vocational Training</h3>\n" +
                "B.Tech students are required to undergo ‘Vocational Training’ as per the provision of training in\n" +
                "their curricula arranged by the institute during summer vacation. The students will bear the traveling\n" +
                "and other expenses for the training. Marks assigned for the training are awarded on the basis of\n" +
                "training report and viva voce\n" +
                "examination.\n" +
                "<br/><br/>\n" +
                "           <h3><font color=\"#5F0D0D\">Placement</h3>\n" +
                "The institute has a full fledged Training & Placement cell under the Training & Placement Officer\n" +
                "(TPO) who is a senior faculty member. The Training & Placement office also looks after the\n" +
                "placement of the students. The various reputed Industries /Organizations conduct campus\n" +
                "interviews regularly for selecting suitable candidates in their respective organizations. A few of\n" +
                "industries/organizations visiting the Institute for the last few years are listed below :<br/><br/>\n" +
                "<p>INFOSYS </p>\n" +
                "<p>IGATE </p>\n"+
                "<p>HCL </p>\n" +
                "<p>Iflex </p>\n"+
                "<p>WIPRO Infotech </p>\n" +
                "<p>ALSTOM </p>\n" +
                "<p>SATYAM TCS</p>\n" +
                "<p>Bhartiya Telesoft Ansal Housing </p>\n" +
                "<p>Accenture </p>\n" +
                "<p>Tech. Mahindra </p>\n" +
                "<p>Petrot System </p>\n" +
                "<p>Hindalco </p>\n" +
                "<p>Enercon India Ltd </p>\n" +
                "<p>Adobe Systems India </p>\n" +
                "<p>Indian Army </p>\n" +
                "<p>Larsen &amp; Toubro </p>\n" +
                "<p>Indian Nvy </p>\n" +
                "<p>Newgenapps </p>\n" +
                "<p>THDC </p>\n" +
                "<p>DSCL </p>\n" +
                "<p>Lohia Starlinger Ltd </p>\n" +
                "<p>Mediatek india </p>\n"+
                "<p>Reed Technology </p>"));
        placementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                expandableLayout3.toggle();
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
                if(expandableLayout4.isExpanded()){
                    expandableLayout4.collapse();
                }
            }
        });

        coursestudyTextview=findViewById(R.id.courselayout6_id);
        coursestudyTextview1=findViewById(R.id.courselayout3_id);
        coursestudyTextview.setText(Html.fromHtml("<h3><font color=\"#5F0D0D\">(E) Doctoral Programmes (Ph. D.)</h3>\n" +
                "\n" +
                "<ul class=\"UL1\">\n" +
                "<li> Civil Engineering</li><br>" +
                "<li>Computer Science & Engineering</li><br>" +
                "<li>Electrical Engineering</li><br>" +
                "<li>Electronics Engineering</li><br>" +
                "<li>Mechanical Engineering</li><br>" +
                "<li>Humanities and Applied sciences</li>"));
        coursestudyTextview1.setText(Html.fromHtml("*AICTE sanctioned intake, ** 10% additional intake in lieu of the Fee Waver Scheme<br><br><p>" +
                "<h3>Note:</h3>" +
                "\n"+
                "<li><strong>(i)</strong> The Institution under the <strong>AICTE Tuition Fee Waiver Scheme</strong> has been allowed to admit 10%\n" +
                "of its sanctioned intake as an additional intake in the same discipline/branch of study.</li><br>\n" +
                "<li><strong>(ii) </strong>In addition to the above, a total number of <strong>10 students</strong> as <strong>Other States Nominees</strong> are also admitted as per norms of Govt. of India.</li></p>\n" +
                "<br><li><strong>(iii) 5%</strong> seats on the total sanctioned intake as approved by AICTE are also available for Non Resident\n" +
                "Indians <strong>(NRI).</strong></li><br>\n"));
        coursestudyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                expandableLayout4.toggle();
                if(expandableLayout2.isExpanded()){
                    expandableLayout2.collapse();
                }
                if(expandableLayout3.isExpanded()){
                    expandableLayout3.collapse();
                }
                if(expandableLayout1.isExpanded()){
                    expandableLayout1.collapse();
                }
            }
        });
    }
}
