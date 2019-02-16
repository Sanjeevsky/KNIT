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

public class CareerDevelopmentActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button career_button,career_click_button,student_button,student_click_button,training_button,intershipButton;
    private ExpandableRelativeLayout expandableLayout1,expandableLayout2,expandableLayout3,expandableLayout4;
    private TextView trainingTextview,internshipTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_development);

        toolbar=findViewById(R.id.toolbar_id_career);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Career Development Cell");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        career_button=findViewById(R.id.career_development_id);
        expandableLayout1=findViewById(R.id.expandablelayout1_career);
        career_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                career_click_button=findViewById(R.id.career_button_id);
                career_click_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent studentIntent=new Intent(CareerDevelopmentActivity.this,webview_acticity.class);
                        studentIntent.putExtra("pdf","http://knit.ac.in/pdf/cdc2016_280916.pdf");
                        startActivity(studentIntent);
                    }
                });
                expandableLayout1.toggle();
            }
        });

        student_button=findViewById(R.id.student_module_id);
        expandableLayout2=findViewById(R.id.expandablelayout2_career);
        student_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student_click_button=findViewById(R.id.student_placement_button_id);
                student_click_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent studentIntent=new Intent(CareerDevelopmentActivity.this,webview_acticity.class);
                        studentIntent.putExtra("url","http://knit.ac.in/online/views/user/login.aspx");
                        startActivity(studentIntent);
                    }
                });
                expandableLayout2.toggle();
            }
        });

        training_button=findViewById(R.id.training_button_id);
        expandableLayout3=findViewById(R.id.expandablelayout3_career);
        trainingTextview=findViewById(R.id.training_textview_id);
        trainingTextview.setText(Html.fromHtml("<p>Technical Education plays a pivotal role in  development of the country by creating skilled manpower, enhancing industrial  productivity and improving the quality of its people.<br><br>\n" +
                "  Hence, the impulse pf imparting technical  training to the novice students paves the way for this exigent development and  training and workshop are held to make them industry ready.<br><br>\n" +
                "  As per the norms of AICTE, Institute provides  various training and workshop sessions for the students which keeps them on  their toes, right since their sophomore year. Catering to the need of present  scenario, institute provides the desired certified courses on up-to-the minute  technical topics.</p>\n"));
        training_button.setOnClickListener(new View.OnClickListener() {
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
        intershipButton=findViewById(R.id.internship_button_id);
        expandableLayout4=findViewById(R.id.expandablelayout4_career);
        internshipTextview=findViewById(R.id.internship_textview_id);
        internshipTextview.setText(Html.fromHtml("<p>\n" +
                        "  Taking forward the zeal of  trainings, internships are provided by the institute to techno birds, to expose  them to the working of the corporate worlds and cutting-edge competition as  well as work pressure which prevails there.<br>\n" +
                        "  The institute provides  internships to the students, to provide them exposure to the trending world and  current working scenario of the modern corporate<br>\n" +
                        "  Students works as Remote as well  as direct interns under professional mentors to work under the professional  environment on various projects.<br>\n" +
                        "  Many companies provide  internship to our college students, some of these are:</p>\n" +
                        "\n" +
                        "<ul class=\"UL1\">\n" +
                        "<li> ITTIAM Systems</li>\n" +
                        "<li> Adobe</li>\n" +
                        "<li> TCS</li>\n" +
                        "<li> AnsalAPI</li>\n" +
                        "<li> L&amp;T</li>\n" +
                        "<li> Pie INFOCOMM</li>\n" +
                        "<li> Nirvana Solutions</li>\n" +
                        "<li> Atventus</li>\n" +
                        "<li> Cedcos0073</li>\n" +
                        "<li> Newgen Apps and many more…</li>\n" +
                        "\n"));
        intershipButton.setOnClickListener(new View.OnClickListener() {
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
    }
}
