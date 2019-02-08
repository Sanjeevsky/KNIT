package com.example.sanjeevyadav.knit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView datashow;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        datashow=itemView.findViewById(R.id.textview_id_recycler_item);

    }
}
