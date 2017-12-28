package com.zukhrufi.vbeauty.Model;

/**
 * Created by WINDOWS on 12/26/2017.
 */

public class Category {
    private String Nama;
    private String Gambar;

    public Category() {
    }

    public Category(String nama, String gambar) {
        Nama = nama;
        Gambar = gambar;
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
}
