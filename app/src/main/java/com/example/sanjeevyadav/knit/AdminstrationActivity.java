package com.example.sanjeevyadav.knit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AdminstrationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView ByLaws,BoardsOfGoverners,MinutesBog,MembersofAcademic,ListOfficeBearers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminstration);
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Administration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ByLaws=findViewById(R.id.pdf_laws);
        BoardsOfGoverners=findViewById(R.id.pdf_boards_of_governers);
        MinutesBog=findViewById(R.id.pdf_minutes_bog);
        MembersofAcademic=findViewById(R.id.pdf_member_of_academics);
        ListOfficeBearers=findViewById(R.id.pdf_list_of_office_bearers);

        ByLaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(AdminstrationActivity.this, webview_acticity.class);
                adminIntent.putExtra("pdf", "http://www.knit.ac.in/pdf/bylaws_mar0216.pdf");
                startActivity(adminIntent);
            }
        });
        BoardsOfGoverners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(AdminstrationActivity.this, webview_acticity.class);
                adminIntent.putExtra("pdf", "http://www.knit.ac.in/pdf/BOG%20Member.pdf");
                startActivity(adminIntent);

            }
        });
        MinutesBog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(AdminstrationActivity.this, webview_acticity.class);
                adminIntent.putExtra("pdf", "http://www.knit.ac.in/pdf/bog3oct_070118.pdf");
                startActivity(adminIntent);

            }
        });
        MembersofAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(AdminstrationActivity.this, webview_acticity.class);
                adminIntent.putExtra("pdf", "http://www.knit.ac.in/pdf/AC2017.pdf");
                startActivity(adminIntent);

            }
        });
        ListOfficeBearers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(AdminstrationActivity.this, webview_acticity.class);
                adminIntent.putExtra("pdf", "http://www.knit.ac.in/pdf/beares_090818.pdf");
                startActivity(adminIntent);

            }
        });
    }
}
