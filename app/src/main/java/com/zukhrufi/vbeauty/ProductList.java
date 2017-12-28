package com.zukhrufi.vbeauty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.zukhrufi.vbeauty.Interface.ItemClickListener;
import com.zukhrufi.vbeauty.Model.Product;
import com.zukhrufi.vbeauty.ViewHolder.ProductViewHolder;

public class ProductList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference ProductList;

    String categoryId= "";

    FirebaseRecyclerAdapter<Product,ProductViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        //firebase
        database = FirebaseDatabase.getInstance();
        ProductList = database.getReference("Product");

        recyclerView = (RecyclerView)findViewById(R.id.rv_product);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //get intentg here
        if (getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty() && categoryId != null){
            loadListProduct(categoryId);
        }

    }

    private void loadListProduct(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Product, ProductViewHolder>(Product.class,
                R.layout.product_item,ProductViewHolder.class,
                ProductList.orderByKey().equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(ProductViewHolder viewHolder, Product model, int position) {
                viewHolder.productNama.setText(model.getNama());
                Picasso.with(getBaseContext()).load(model.getGambar())
                        .into(viewHolder.productGambar);
                final Product local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onCLick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(ProductList.this, ""+local.getNama(),Toast.LENGTH_SHORT).show();
                        //start new activity
                        Intent productDetail = new Intent(com.zukhrufi.vbeauty.ProductList.this, com.zukhrufi.vbeauty.ProductDetail.class);
                        //ProductDetail.putExtra("MakananId",adapter.getRef(position).getKey());
                        productDetail.putExtra("ProductId",adapter.getRef(position).getKey());
                        startActivity(productDetail);
                    }
                });
            }
        };

        //set adapter
        //Log.d("TAG",""+adapter.getItemCount());
        recyclerView.setAdapter(adapter);
    }
}
