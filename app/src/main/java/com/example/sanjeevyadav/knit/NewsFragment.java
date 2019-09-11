package com.example.sanjeevyadav.knit;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class NewsFragment extends Fragment {

    private static final int WRITE_REQUEST_CODE = 300;
    RecyclerView recyclerView;
    recycler_adapter recyclerAdapter;
    List<DataHold> data;
    DatabaseReference databaseReference;
    Context context;
    SwipeRefreshLayout swipeRefreshLayout;
    View view;
    private ProgressDialog loadingBar;

    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("newsfeeds");
        databaseReference.keepSynced(true);
        this.context = getContext();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        context = getContext();
        recyclerView = view.findViewById(R.id.recyclerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        /*ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(isConnected) {
            RefreshSection();
        }
        else
        {
            Toast.makeText(context,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
        }*/
        RefreshSection();
        swipeRefreshLayout = view.findViewById(R.id.refreshh_layout_id_newsfeeds);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /*ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
                if(isConnected) {
                    RefreshSection();
                    swipeRefreshLayout.setRefreshing(false);
                }
                else
                {
                    Toast.makeText(context,"Your Device is not connected to Internet",Toast.LENGTH_LONG).show();
                }*/
                RefreshSection();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void RefreshSection() {
        data = new ArrayList<>();
        loadingBar = new ProgressDialog(context);
        loadingBar.create();
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.setTitle("Loading...!!!");
        loadingBar.setMessage("Loading Data Please Wait...!!!");
        databaseReference = FirebaseDatabase.getInstance().getReference("newsfeeds");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    loadingBar.show();
                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                        DataHold donorData = dataSnap.getValue(DataHold.class);
                        data.add(donorData);
                    }
                }
                recyclerAdapter = new recycler_adapter(data, context);
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

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, NewsFragment.this);
    }

    /*@Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        //Download the file once permission is granted
        //new DownloadFile().execute("http://www.knit.ac.in/pdf/COP_Notice_150419.pdf");
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        //Log.d(TAG, "Permission has been denied");
    }*/


    /*void downloadPdf(String url,Context context)
    {

        new DownloadFile(context).execute(url);
        /*if (EasyPermissions.hasPermissions(, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //Get the URL entered
           new DownloadFile(context).execute(url);

        } else {
            //If permission is not present request for the same.
            EasyPermissions.requestPermissions(context, getString(R.string.write_file), WRITE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    /*private class DownloadFile extends AsyncTask<String, String, String> {

        private ProgressDialog progressDialog;
        private String fileName;
        private String folder;
        private boolean isDownloaded;
        Context context;

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */

        /*public DownloadFile(Context context){
            this.context=context;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressDialog = new ProgressDialog(context);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            this.progressDialog.setTitle("Downloading...");
            this.progressDialog.setCancelable(true);
            this.progressDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        /*@Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                // getting file length
                int lengthOfFile = connection.getContentLength();


                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

                //Extract file name from URL
                fileName = f_url[0].substring(f_url[0].lastIndexOf('/') + 1, f_url[0].length());

                //External directory path to save file
                folder = Environment.getExternalStorageDirectory() + File.separator + "Download/";

                //Create androiddeft folder if it does not exist
                File directory = new File(folder);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Output stream to write file
                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    //Log.d(TAG, "Progress: " + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                //return "Downloaded at: " + folder + fileName;
                isDownloaded = true;
                return fileName;

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "Something went wrong";
        }

        /**
         * Updating progress bar
         */
        /*protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            progressDialog.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {
            // dismiss the dialog after the file was downloaded
            this.progressDialog.dismiss();

            if (isDownloaded){
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setTitle("Download Complete");
                builder.setMessage(message);
                builder.setPositiveButton("Open", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            // Display File path after downloading
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }*/
}
