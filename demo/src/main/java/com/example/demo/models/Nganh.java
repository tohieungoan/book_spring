package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "NGANH")
public class Nganh {
    @Id
    private String maNganh;  // khóa chính

    private String tenNganh;
    private String loaiNganh;

    public String getMaNganh() {  // sửa tên phương thức getter cho đúng
        return maNganh;
    }

    public void setMaNganh(String maNganh) {  // sửa tên phương thức setter cho đúng
        this.maNganh = maNganh;
    }

    public String getTenNganh() {  // sửa tên phương thức getter cho đúng
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {  // sửa tên phương thức setter cho đúng
        this.tenNganh = tenNganh;
    }

    public String getLoaiNganh() {  // sửa tên phương thức getter cho đúng
        return loaiNganh;
    }

    public void setLoaiNganh(String loaiNganh) {  // sửa tên phương thức setter cho đúng
        this.loaiNganh = loaiNganh;
    }
}
