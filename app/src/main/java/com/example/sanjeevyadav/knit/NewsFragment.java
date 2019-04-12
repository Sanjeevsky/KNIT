package com.example.sanjeevyadav.knit;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {

    RecyclerView recyclerView;
    recycler_adapter recyclerAdapter;
    List<DataHold> data;
    DatabaseReference databaseReference;
    Context context;
    private ProgressDialog loadingBar;
    SwipeRefreshLayout swipeRefreshLayout;

        public NewsFragment() {
        }
        View view;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.fragment_news,container,false);
            databaseReference=FirebaseDatabase.getInstance().getReference("newsfeeds");
            databaseReference.keepSynced(true);
            context=getContext();
            return view;
        }

    @Override
    public void onStart() {
        super.onStart();
        context=getContext();
        recyclerView=view.findViewById(R.id.recyclerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(isConnected) {
            RefreshSection();
        }
        else
        {
            Toast.makeText(context,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
        }
        swipeRefreshLayout=view.findViewById(R.id.refreshh_layout_id_newsfeeds);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
                if(isConnected) {
                    RefreshSection();
                    swipeRefreshLayout.setRefreshing(false);
                }
                else
                {
                    Toast.makeText(context,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void RefreshSection() {
        data=new ArrayList<>();
        loadingBar=new ProgressDialog(context);
        loadingBar.create();
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.setTitle("Loading...!!!");
        loadingBar.setMessage("Loading Data Please Wait...!!!");
        loadingBar.show();
        databaseReference=FirebaseDatabase.getInstance().getReference("newsfeeds");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    for(DataSnapshot dataSnap : dataSnapshot.getChildren())
                    {
                        DataHold donorData = dataSnap.getValue(DataHold.class);
                        data.add(donorData);
                    }
                }
                recyclerAdapter = new recycler_adapter(data,context);
                recyclerView.setAdapter(recyclerAdapter);
                loadingBar.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                loadingBar.dismiss();
                Toast.makeText(context, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
