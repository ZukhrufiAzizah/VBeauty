package com.zukhrufi.vbeauty.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.zukhrufi.vbeauty.Interface.ItemClickListener;
import com.zukhrufi.vbeauty.Model.Order;
import com.zukhrufi.vbeauty.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by WINDOWS on 12/27/2017.
 */

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView cartNama, harga;
    public ImageView gambar_cart_count;

    private ItemClickListener itemClickListener;

    public void setCartNama(TextView setCartNama) {
        this.cartNama = cartNama;
    }


    public CartViewHolder(View itemView) {
        super(itemView);
        cartNama = (TextView)itemView.findViewById(R.id.cart_item_nama);
        harga = (TextView)itemView.findViewById(R.id.cart_item_harga);
        gambar_cart_count = (ImageView)itemView.findViewById(R.id.cart_item_count);
    }

    @Override
    public void onClick(View view) {

    }
}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listData, Context context){
        this.listData = listData;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(position).getQuantity(), Color.RED);
        holder.gambar_cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("in_ID","id");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int harga = (Integer.parseInt(listData.get(position).getHarga()))*(Integer.parseInt(listData.get(position).getQuantity()));
        holder.harga.setText(fmt.format(harga));

        holder.cartNama.setText(listData.get(position).getProductNama());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
