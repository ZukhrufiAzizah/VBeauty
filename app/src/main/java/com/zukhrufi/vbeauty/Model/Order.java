package com.zukhrufi.vbeauty.Model;

/**
 * Created by WINDOWS on 12/27/2017.
 */

public class Order {
    private String ProductId;
    private String ProductNama;
    private String Quantity;
    private String Harga;

    public Order() {
    }

    public Order(String productId, String productNama, String quantity, String harga) {
        ProductId = productId;
        ProductNama = productNama;
        Quantity = quantity;
        Harga = harga;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductNama() {
        return ProductNama;
    }

    public void setProductNama(String productNama) {
        ProductNama = productNama;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}
