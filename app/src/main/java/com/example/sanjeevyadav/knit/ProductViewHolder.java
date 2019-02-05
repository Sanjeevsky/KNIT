package com.example.sanjeevyadav.knit;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {

    private TextView mTextView;
    public ProductViewHolder(View itemView) {
        super(itemView);

        mTextView=itemView.findViewById(R.id.product_id);
    }

    public void bind(Product product)
    {
        mTextView.setText(Html.fromHtml(product.name));
    }
}
