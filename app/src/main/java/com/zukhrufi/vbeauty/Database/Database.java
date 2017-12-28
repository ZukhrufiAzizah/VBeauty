package com.zukhrufi.vbeauty.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.zukhrufi.vbeauty.Model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WINDOWS on 12/27/2017.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="VBeauty.db";
    private static final int DB_VER=1;

    public Database(Context context) {
        super(context, DB_NAME,null, DB_VER);
    }

    public List<Order> getCarts(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"ProductNama","ProductId","Quantity","Harga"};
        String sqlTable="OrderDetail";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result = new ArrayList<>();
        if (c.moveToFirst()){
            do{
                result.add(new Order(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductNama")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Harga"))
                ));
            }while(c.moveToNext());
        }
        return result;
    }

    public void addToCart(Order order){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail(ProductId,ProductNama,Quantity,Harga) VALUES('%s','%s','%s','%s');",
                order.getProductId(),
                order.getProductNama(),
                order.getQuantity(),
                order.getHarga());
        db.execSQL(query);
    }

    public void cleanCart(){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELET FROM OrderDetail");

        db.execSQL(query);
    }
}
