package com.example.sanjeevyadav.knit;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private recycler_adapter recyclerAdapter;
    private List<DataHold> data;
    private Toolbar toolbar;
    private DatabaseReference databaseReference;
    private Context context;
    private ProgressDialog loadingBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView=findViewById(R.id.recyclerview_id_results);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolbar=findViewById(R.id.toolbar_id_results);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Results");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        context=ResultActivity.this;

        databaseReference= FirebaseDatabase.getInstance().getReference("results");
        databaseReference.keepSynced(true);

        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(isConnected) {
            RefreshSection();
        }
        else
        {
            Toast.makeText(ResultActivity.this,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
        }
        swipeRefreshLayout=findViewById(R.id.refresh_layout_id_result);
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
                    Toast.makeText(ResultActivity.this,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void RefreshSection() {
        data=new ArrayList<>();
        loadingBar=new ProgressDialog(this);
        loadingBar.create();
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.setTitle("Loading...!!!");
        loadingBar.setMessage("Loading Data Please Wait...!!!");
        loadingBar.show();
        databaseReference= FirebaseDatabase.getInstance().getReference("results");
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
                recyclerAdapter = new recycler_adapter(data,ResultActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
                loadingBar.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                loadingBar.dismiss();
                Toast.makeText(ResultActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
