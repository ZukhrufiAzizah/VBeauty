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

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView menuNama;
    public ImageView menuGambar;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);

        menuNama = (TextView)itemView.findViewById(R.id.menuNama);
        menuGambar = (ImageView)itemView.findViewById(R.id.menuGambar);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onCLick(view,getAdapterPosition(),false);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
