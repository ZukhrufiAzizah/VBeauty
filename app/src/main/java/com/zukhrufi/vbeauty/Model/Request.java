package com.zukhrufi.vbeauty.Model;

import java.util.List;

/**
 * Created by WINDOWS on 12/27/2017.
 */

public class Request {
    private String phone;
    private String nama;
    private String alamat;
    private String total;
    private String status;
    private List<Order> products; //list of products order

    public Request(){

    }

    public Request(String phone, String nama, String alamat, String total, List<Order> products) {
        this.phone = phone;
        this.nama = nama;
        this.alamat = alamat;
        this.total = total;
        this.products = products;
        this.status = "0"; //default is 0
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getProducts() {
        return products;
    }

    public void setProducts(List<Order> products) {
        this.products = products;
    }
}
