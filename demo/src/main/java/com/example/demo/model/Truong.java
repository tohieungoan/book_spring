package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRUONG")
public class Truong {

    @Id
    private String maTruong;  // Khóa chính

    private String tenTruong;
    private String diaChi;
    private String soDT;

    // Constructor
    public Truong() {}

    public String getmaTruong() {
        return maTruong;
    }

    public void setmaTruong(String maTruong) {
        maTruong = maTruong;
    }

    public String gettenTruong() {
        return tenTruong;
    }

    public void settenTruong(String tenTruong) {
        tenTruong = tenTruong;
    }

    public String getdiaChi() {
        return diaChi;
    }

    public void setdiaChi(String diaChi) {
        diaChi = diaChi;
    }

    public String getsoDT() {
        return soDT;
    }

    public void setsoDT(String soDT) {
        soDT = soDT;
    }
}
