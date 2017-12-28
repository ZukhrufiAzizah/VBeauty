package com.zukhrufi.vbeauty.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zukhrufi.vbeauty.Interface.ItemClickListener;
import com.zukhrufi.vbeauty.R;

/**
 * Created by WINDOWS on 12/27/2017.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView orderId, orderStatus, orderPhone, orderAddress;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);

        orderAddress = (TextView)itemView.findViewById(R.id.order_address);
        orderId = (TextView)itemView.findViewById(R.id.order_id);
        orderStatus = (TextView)itemView.findViewById(R.id.order_status);
        orderPhone = (TextView)itemView.findViewById(R.id.order_phone);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onCLick(view, getAdapterPosition(),false);

    }
}
