package com.example.demo.models;

import com.example.demo.models.CongViec;
import com.example.demo.models.TotNghiep;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "SINHVIEN")
public class SinhVien {

    @Id
    private String soCMND;

    private String hoTen;

    private String email;

    private String soDT;

    private String diaChi;

    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    private List<TotNghiep> totNghiepList ;

    @OneToMany(mappedBy = "sinhVien")
    private List<CongViec> congViecList ;

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }
    public Boolean isTotNghiep() {
        return totNghiepList != null && !totNghiepList.isEmpty();
    }


    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<CongViec> getCongViecList() {
        return congViecList;
    }

    public void setCongViecList(List<CongViec> congViecList) {
        this.congViecList = congViecList;
    }

    public List<TotNghiep> getTotNghiepList() {
        return totNghiepList;
    }

    public void setTotNghiepList(List<TotNghiep> totNghiepList) {
        this.totNghiepList = totNghiepList;
    }
    @Override
    public String toString() {
        return "SinhVien{" +
                "soCMND='" + soCMND + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                ", soDT='" + soDT + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

}

