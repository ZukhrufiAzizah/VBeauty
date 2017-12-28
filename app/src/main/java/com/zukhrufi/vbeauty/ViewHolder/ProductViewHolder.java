package com.zukhrufi.vbeauty.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zukhrufi.vbeauty.Interface.ItemClickListener;
import com.zukhrufi.vbeauty.R;

/**
 * Created by WINDOWS on 12/26/2017.
 */

public class ProductViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productNama;
    public ImageView productGambar;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ProductViewHolder(View itemView) {
        super(itemView);
        productNama = (TextView)itemView.findViewById(R.id.productNama);
        productGambar = (ImageView)itemView.findViewById(R.id.productGambar);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onCLick(view,getAdapterPosition(),false);

    }
}
