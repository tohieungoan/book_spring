package com.example.demo.model;


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

    public String getmaNganh() {
        return maNganh;
    }

    public void setmaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String gettenNganh() {
        return tenNganh;
    }

    public void settenNganh(String tenNganh) {
       this.tenNganh = tenNganh;
    }

    public String getloaiNganh() {
        return loaiNganh;
    }

    public void setloaiNganh(String loaiNganh) {
        this.loaiNganh = loaiNganh;
    }
}
