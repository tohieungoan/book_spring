package com.example.demo.models;

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

    public String getMaTruong() {  // sửa tên phương thức getter cho đúng
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;  // sửa tên biến setter
    }

    public String getTenTruong() {  // sửa tên phương thức getter cho đúng
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;  // sửa tên biến setter
    }

    public String getDiaChi() {  // sửa tên phương thức getter cho đúng
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;  // sửa tên biến setter
    }

    public String getSoDT() {  // sửa tên phương thức getter cho đúng
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;  // sửa tên biến setter
    }
}
