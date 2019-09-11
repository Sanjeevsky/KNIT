package com.example.sanjeevyadav.knit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView datashow;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        datashow=itemView.findViewById(R.id.textview_id_recycler_item);

    }
}
