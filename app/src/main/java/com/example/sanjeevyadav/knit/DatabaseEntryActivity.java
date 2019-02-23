package com.example.sanjeevyadav.knit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class DatabaseEntryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] spinnertype={"url","pdf"};

    private FirebaseAuth mAuth;
    private DatabaseReference newsRef,resRef;
    private EditText NewsText, NewsLink,ResText,ResLink;
    private Button NewsSubmitButton,ResultSubmitButton;
    private String newsText,newsLink,newsType,resText,resLink,resType;
    private RecyclerView recyclerView,recyclerView2;
    private ExpandableLayout expandableLayout1,expandableLayout2;
    private Button NewsExpand,ResultExpand;
    private Toolbar toolbar;
    private Animation nothingtocome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_entry);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DataBase Entry Section");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        newsRef = FirebaseDatabase.getInstance().getReference("newsfeeds");
        resRef = FirebaseDatabase.getInstance().getReference("results");
        NewsText = findViewById(R.id.news_text_id);
        NewsLink = findViewById(R.id.news_link_id);
        ResText=findViewById(R.id.result_text_id);
        ResLink=findViewById(R.id.result_link_id);
        recyclerView=findViewById(R.id.recyclerview_id_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2=findViewById(R.id.recyclerview_id_data2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        NewsExpand=findViewById(R.id.news_update_expandable);
        expandableLayout1=findViewById(R.id.expandableLayout1_news);
        ResultExpand=findViewById(R.id.result_update_expandable);
        expandableLayout2=findViewById(R.id.expandableLayout1_result);
        nothingtocome= AnimationUtils.loadAnimation(this,R.anim.nothingtocome);
        NewsExpand.startAnimation(nothingtocome);
        ResultExpand.startAnimation(nothingtocome);

        mAuth=FirebaseAuth.getInstance();

        NewsExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1.toggle();
            }
        });

        ResultExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2.toggle();
            }
        });




        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnertype);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin2.setAdapter(aa);

        //News Update

        NewsSubmitButton = findViewById(R.id.submit_news_button);

        NewsSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsText = NewsText.getText().toString();
                newsLink = NewsLink.getText().toString();
                NewsText.setText("");
                NewsLink.setText("");

                if (!TextUtils.isEmpty(newsText) && !TextUtils.isEmpty(newsLink) && !TextUtils.isEmpty(newsType)) {
                    Long tsLong = 1000000000-((System.currentTimeMillis() / 1000)%100000);
                    String ts = tsLong.toString();
                    Map messageTextBody = new HashMap();
                    messageTextBody.put("text", newsText);
                    messageTextBody.put("type", newsType);
                    messageTextBody.put("link", newsLink);

                    Map messageBodyDetails = new HashMap();
                    messageBodyDetails.put(ts, messageTextBody);


                    newsRef.updateChildren(messageBodyDetails).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(DatabaseEntryActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(DatabaseEntryActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(DatabaseEntryActivity.this, "Please Provide With All Entry Section", Toast.LENGTH_SHORT).show();
                }
            }
        });


        FirebaseRecyclerOptions<DataHold> options = new FirebaseRecyclerOptions.Builder<DataHold>()
                .setQuery(newsRef, DataHold.class)
                .build();

        FirebaseRecyclerAdapter<DataHold, RequestsViewHolder> adapter = new FirebaseRecyclerAdapter<DataHold, RequestsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final RequestsViewHolder holder, int position, @NonNull DataHold model) {
                String list_user_id=getRef(position).getKey();

                DatabaseReference getTypeRef=getRef(position).getRef();

                getTypeRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()) {

                                holder.text.setText(dataSnapshot.child("text").getValue().toString());
                                holder.text.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        CharSequence options[] = new CharSequence[]
                                                {
                                                        "Delete",
                                                        "Cancel"
                                                };
                                        AlertDialog.Builder builder = new AlertDialog.Builder(DatabaseEntryActivity.this);
                                        builder.setTitle(" Delete News");
                                        builder.setItems(options, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (which == 0) {
                                                    newsRef.child(dataSnapshot.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            Toast.makeText(DatabaseEntryActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }

                                                if (which == 1) {
                                                    Toast.makeText(DatabaseEntryActivity.this, "Cancelled Deletion", Toast.LENGTH_SHORT).show();
                                                }


                                            }
                                        });
                                        builder.show();
                                    }
                                });

                            }
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(DatabaseEntryActivity.this, "Error Loading Data From Database", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @NonNull
            @Override
            public RequestsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view= LayoutInflater.from(DatabaseEntryActivity.this).inflate(R.layout.recycler_item_layout,viewGroup,false);
                RequestsViewHolder holder=new RequestsViewHolder(view);
                return holder;
            }


        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

        ResultSubmitButton = findViewById(R.id.submit_result_button);

        ResultSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resText = ResText.getText().toString();
                resLink = ResLink.getText().toString();
                ResLink.setText("");
                ResText.setText("");

                if (!TextUtils.isEmpty(resText) && !TextUtils.isEmpty(resLink) && !TextUtils.isEmpty(resType)) {
                    Long tsLong = 1000000000-((System.currentTimeMillis() / 1000)%100000);
                    String ts = tsLong.toString();
                    Map messageTextBody = new HashMap();
                    messageTextBody.put("text", resText);
                    messageTextBody.put("type", resType);
                    messageTextBody.put("link", resLink);

                    Map messageBodyDetails = new HashMap();
                    messageBodyDetails.put(ts, messageTextBody);


                    resRef.updateChildren(messageBodyDetails).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(DatabaseEntryActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(DatabaseEntryActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(DatabaseEntryActivity.this, "Please Provide With All Entry Section", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FirebaseRecyclerOptions<DataHold> options2 = new FirebaseRecyclerOptions.Builder<DataHold>()
                .setQuery(resRef, DataHold.class)
                .build();

        FirebaseRecyclerAdapter<DataHold, RequestsViewHolder> adapter2 = new FirebaseRecyclerAdapter<DataHold, RequestsViewHolder>(options2) {
            @Override
            protected void onBindViewHolder(@NonNull final RequestsViewHolder holder, int position, @NonNull DataHold model) {
                String list_user_id=getRef(position).getKey();

                DatabaseReference getTypeRef=getRef(position).getRef();

                getTypeRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()) {

                            holder.text.setText(dataSnapshot.child("text").getValue().toString());
                            holder.text.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    CharSequence options[] = new CharSequence[]
                                            {
                                                    "Delete",
                                                    "Cancel"
                                            };
                                    AlertDialog.Builder builder = new AlertDialog.Builder(DatabaseEntryActivity.this);
                                    builder.setTitle(" Delete News");
                                    builder.setItems(options, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (which == 0) {
                                                resRef.child(dataSnapshot.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        Toast.makeText(DatabaseEntryActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }

                                            if (which == 1) {
                                                Toast.makeText(DatabaseEntryActivity.this, "Cancelled Deletion", Toast.LENGTH_SHORT).show();
                                            }


                                        }
                                    });
                                    builder.show();
                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(DatabaseEntryActivity.this, "Error Loading Data From Database", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @NonNull
            @Override
            public RequestsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view= LayoutInflater.from(DatabaseEntryActivity.this).inflate(R.layout.recycler_item_layout,viewGroup,false);
                RequestsViewHolder holder=new RequestsViewHolder(view);
                return holder;
            }


        };
        recyclerView2.setAdapter(adapter2);
        adapter2.startListening();


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        newsType=spinnertype[position];
        resType=spinnertype[position];


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Select Type", Toast.LENGTH_SHORT).show();

    }

    public static class RequestsViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public RequestsViewHolder(View itemView) {
            super(itemView);

           text=itemView.findViewById(R.id.textview_id_recycler_item);
        }
    }

    @Override
    public void onBackPressed() {
        mAuth.signOut();
        Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
