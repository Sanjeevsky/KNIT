package com.example.sanjeevyadav.knit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class recycler_adapter extends RecyclerView.Adapter<viewHolder> {

    private List<DataHold> data;
    private Context context;

    public recycler_adapter(List<DataHold> data, Context context) {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_layout,viewGroup, false);
        viewHolder userviewHolder = new viewHolder(view);
        return userviewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final DataHold dataHold=data.get(position);
        holder.datashow.setText(dataHold.text);
        holder.datashow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,webview_acticity.class);
                if(dataHold.type.equals("pdf"))
                {
                    //intent.putExtra("pdf",""+dataHold.link);
                    new NewsFragment().downloadPdf(dataHold.link,context);
                }
                else {
                    intent.putExtra("url",""+dataHold.link);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
