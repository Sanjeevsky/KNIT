package com.example.sanjeevyadav.knit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private CardView resCard,aboutCard,studentCard,developerCard,academicsCard,calenderCard;
        public MainFragment() {
        }
        View view;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.fragment_main,container,false);
            return view;
        }


    @Override
    public void onStart() {
        super.onStart();
        resCard=view.findViewById(R.id.result_cardview_id);
        aboutCard=view.findViewById(R.id.about_cardview_id);
        studentCard=view.findViewById(R.id.studnets_cardview_id);
        developerCard=view.findViewById(R.id.devlopers_cardview_id);
        academicsCard=view.findViewById(R.id.academic_cardview_id);
        calenderCard=view.findViewById(R.id.calendar_cardview_id);
        resCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent=new Intent(getContext(),ResultActivity.class);
                startActivity(resultIntent);
            }
        });
        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent=new Intent(getContext(),AboutUsActivity.class);
                startActivity(aboutIntent);
            }
        });

        studentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent=new Intent(getContext(),StudentActivity.class);
                startActivity(studentIntent);
            }
        });

        developerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent developerIntent=new Intent(getContext(),CareerDevelopmentActivity.class);
                startActivity(developerIntent);
            }
        });
        academicsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent academicsIntent=new Intent(getContext(),AcademicActivity.class);
                startActivity(academicsIntent);
            }
        });
        calenderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calenderIntent=new Intent(getContext(),CalenderActivity.class);
                startActivity(calenderIntent);

            }
        });
    }
}