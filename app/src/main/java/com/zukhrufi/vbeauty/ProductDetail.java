package com.zukhrufi.vbeauty;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.zukhrufi.vbeauty.Database.Database;
import com.zukhrufi.vbeauty.Model.Order;
import com.zukhrufi.vbeauty.Model.Product;

public class ProductDetail extends AppCompatActivity {

    TextView productNama, productHarga;
    ImageView productGambar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String productId="";

    FirebaseDatabase database;
    DatabaseReference products;

    Product currentProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");

        //init view
        numberButton = (ElegantNumberButton)findViewById(R.id.numberButton);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).addToCart(new Order(
                        productId,
                        currentProduct.getNama(),
                        numberButton.getNumber(),
                        currentProduct.getHarga()
                ));
                Toast.makeText(ProductDetail.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        productNama = (TextView)findViewById(R.id.productNama);
        productHarga = (TextView)findViewById(R.id.productHarga);
        productGambar = (ImageView)findViewById(R.id.productGambar);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //get product id from intent
        if (getIntent() != null)
            productId = getIntent().getStringExtra("ProductId");
        if (!productId.isEmpty()){
            getDetailProduct(productId);
        }
    }

    private void getDetailProduct(String productId) {
        products.child(productId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Product currentProduct = dataSnapshot.getValue(Product.class);

                //set image
                Picasso.with(getBaseContext()).load(currentProduct.getGambar())
                        .into(productGambar);

                collapsingToolbarLayout.setTitle(currentProduct.getNama());
                productHarga.setText(currentProduct.getHarga());
                productNama.setText(currentProduct.getNama());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
