package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class AcademicActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button admissionButton,feeButton,placementButton;
    private TextView admissionTextview,feeTextview,feeFirst,feeSecond,placementTextview;
    private ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        toolbar=findViewById(R.id.toolbar_id_academic);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Academics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        admissionButton=findViewById(R.id.admission_button_id);
        expandableLayout1=findViewById(R.id.expandablelayout1_academic);
        admissionTextview=findViewById(R.id.admission_textview_id);
        admissionTextview.setText(Html.fromHtml("<h3><font color=\"#ff0000\">Bachelor of Technology (B.Tech) Programmes</h3>\n" +
                "\n" +
                "\n" +
                "<ul class=\"Asd1\">\n" +
                "  <li><strong>(a) Eligibility Requirements</strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"email_lnk\">    </span><br>\n" +
                "  As notified by the State Government of Uttar Pradesh. </li>\n" +
                "  <li><strong>(b) Mode of Admission</strong><br>\n" +
                "    <strong>(i)</strong> The admission to <strong>First Year B.Tech. and M.C.A. Programmes</strong> will be made through\n" +
                "the counseling conducted by Dr. A.P.J. Abdul Kalam Technical University based on the merit of\n" +
                "candidates in the Uttar Pradesh State Entrance Examination (UPSEE) \n" +
                "except for <strong>Other State\n" +
                "Nominees</strong> which are nominated by the Government of India.<br>\n" +
                "<strong>(ii)</strong> The candidate after participating in the counseling is required to report at the institute on\n" +
                "the date mentioned in the Allotment letter.<br>\n" +
                "<strong>(iii)</strong> The Candidate is required to submit the following documents at the time of reporting at\n" +
                "the Institute for registration:\n" +
                "  \n" +
                "  </li><br><ul class=\"UL2\">\n" +
                "<li>Allotment Letter issued by UPSEE</li>\n" +
                "<li>Admit Card by SEE-AKTU, if admit card is submitted at counseling centre, then\n" +
                "photocopy of the admit card</li>\n" +
                "<li>Original Certificate of high School (for proof of the age)</li>\n" +
                "<li>Original mark sheet of qualifying (10+2) examination</li>\n" +
                "<li>Original Character Certificate in prescribed format\n" +
                "issued by Head of the Institute last attended</li>\n" +
                "<li>Original Transfer / Migration Certificate of the Institute last attended.</li>\n" +
                "<li>Category Certificate (If opted for reservation)</li>\n" +
                "<li>SubCategory\n" +
                "Certificate if applicable</li>\n" +
                "<li>Weightage Certificate if applicable</li>\n" +
                "<li>Medical certificate in prescribed format</li>\n" +
                "<li>Income Certificate from those candidates (Gen/OBC/SC/ST/Minorities) whose\n" +
                "parents’/guardians’ annual income from all the sources is ` one lac or less than\n" +
                "` one lac.</li>\n" +
                "<li>Receipt of fee deposited at counseling centre</li>\n" +
                "<li>Two Passport Size Photographs</li>\n" +
                "<li>Medical certificate in prescribed format</li>\n" +
                "<li>Affidavit In case of gap in studies</li><br>\n" +
                "<strong>Two Sets</strong> of photocopies of all the documents/certificates mentioned above are also\n" +
                "required to be submitted along with two recent passport size colour photographs<br>\n" +
                "  <br><strong>&nbsp;&nbsp;(iv)</strong> No direct admission are made to Second Semester of First Year or subsequent years\n" +
                "of the course, except for the Diploma Holders & B.Sc. graduates who are admitted to\n" +
                "Second Year (third semester) through the counseling conducted by the A.K.T.U on the basis of merit of candidates in SEE-AKTU<br>\n" +
                "</li>\n" +
                "<br><strong>&nbsp;&nbsp;(v)</strong> Admission on migration/ transfer from other University/College is not permitted.<br>\n" +
                "</li>\n" +
                "<br><strong>&nbsp;&nbsp;(vi) </strong>Domicile requirement, age limit and medical standards are the same as prescribed in<br>\n" +
                "  the information Brochure of SEE-AKTU<br>\n" +
                "<br>\n" +
                "</li><strong>&nbsp;&nbsp;<li>(C) Reservations</strong><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(As notified in the Information Brochure of SEE-AKTU</li>\n" +
                "\n" +
                "<br><br>\n" +
                "</ul>\n" +
                "\n" +
                "</ul>\n" +
                "</ul>\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<br>\n" +
                "\n" +
                "\n" +
                "  <h3><font color=\"#ff0000\">Master of Computer Application (M.C.A.) Programme</h3>\n" +
                "\n" +
                "\n" +
                "<ul class=\"Asd1\">\n" +
                "<li> <strong>(a) Eligibility Requirements </strong><br>As notified in the information Brochure of SEE-AKTU.</li>\n" +
                "<li> <strong>(b) Mode of Admission </strong><br>Mode of admission to MCA programme is same as for the Undergraduates Programme.</li>\n" +
                "<li> <strong>(c) Reservations</strong> <br>As notified in the information Brochure of SEE-AKTU.</li>\n" +
                "</ul><br><h3><font color=\"#ff0000\">M.Tech. (FullTime)Programmes</h3>\n" +
                "\n" +
                "Admission to the above mentioned\n" +
                "programmes is made on the basis of merit of the valid\n" +
                "GATE Score by AKTU, Lucknow. However, in case of non-availability\n" +
                "of sufficient GATE\n" +
                "qualified candidates, NON GATE\n" +
                "candidates can be considered on vacant seats.</li>\n" +
                "</ul><br><h3><font color=\"#ff0000\">M.Tech. (PartTime)Programmes</h3>\n" +
                "\n" +
                "<ul class=\"Asd1\">\n" +
                "<li><strong>(a) Eligibility Requirements</strong><br>The eligibility requirements shall be as per norms of Dr. A.P.J. Abdul Kalam Technical University, Lucknow.</li>\n" +
                "<li><strong>(b) Mode of Admission</strong><br>Admission is made on the basis of merit of a candidate in the written test / interview\n" +
                "conducted by the department concerned on a specified date.</li>\n" +
                "</ul><br><h3><font color=\"#ff0000\">Doctoral Programmes</h3>\n" +
                "\n" +
                "<ul class=\"Asd1\">\n" +
                "<li><strong>(a) Eligibility Requirements</strong><br>The eligibility requirements are as per the norms of Dr. A.P.J. Abdul Kalam Technical University, Lucknow.</li>\n" +
                "<li><strong>(b) Mode of Registration</strong><br>The application for registration is required to be made on the prescribed application form\n" +
                "of U.P. Technical University, Lucknow.</li>\n" +
                "</ul>"));
        admissionButton.setOnClickListener(new View.OnClickListener() {
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

        feeButton=findViewById(R.id.fee_button_id);
        expandableLayout2=findViewById(R.id.expandablelayout2_academic);
        feeTextview=findViewById(R.id.fee_textview_id);
        feeTextview.setText(Html.fromHtml("<h3><font color=\"#ff0000\">FEE AND OTHER CHARGES FOR FIRST YEAR STUDENTS</h3>\n" +
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
        placementButton=findViewById(R.id.placement_button_id);
        expandableLayout3=findViewById(R.id.expandablelayout3_academic);
        placementTextview=findViewById(R.id.placement_textview_id);
        placementTextview.setText(Html.fromHtml(("<h3><font color=\"#ff0000\">Vocational Training</h3>\n" +
                "B.Tech students are required to undergo ‘Vocational Training’ as per the provision of training in\n" +
                "their curricula arranged by the institute during summer vacation. The students will bear the traveling\n" +
                "and other expenses for the training. Marks assigned for the training are awarded on the basis of\n" +
                "training report and viva voce\n" +
                "examination.\n" +
                "<br/><br/>\n" +
                "           <h3><font color=\"#ff0000\">Placement</h3>\n" +
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
                "<p>Reed Technology </p>")));
        placementButton.setOnClickListener(new View.OnClickListener() {
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
    }
}
