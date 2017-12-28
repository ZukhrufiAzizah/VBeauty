package com.zukhrufi.vbeauty.Model;

/**
 * Created by WINDOWS on 12/26/2017.
 */

public class Product {
    private String Nama, Gambar, Harga, MenuId;

    public Product() {
    }

    public Product(String nama, String gambar, String harga, String menuId) {
        Nama = nama;
        Gambar = gambar;
        Harga = harga;
        MenuId = menuId;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
