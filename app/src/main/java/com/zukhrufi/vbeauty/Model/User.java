package com.zukhrufi.vbeauty.Model;

/**
 * Created by WINDOWS on 12/25/2017.
 */

public class User {
    private String Nama;
    private String Password;
    private String Phone;

    public User() {
    }

    public User(String nama, String password) {
        Nama = nama;
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
