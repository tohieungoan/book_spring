package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {

    @Id
    private String soCMND;

    private String hoTen;

    private String email;

    private String soDT;

    private String diaChi;
    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private TotNghiep totNghiep;
    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private CongViec congViec;
    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
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

    public TotNghiep getTotNghiep() {
        return totNghiep;
    }

    public void setTotNghiep(TotNghiep totNghiep) {
        this.totNghiep = totNghiep;
    }

    public CongViec getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViec congViec) {
        this.congViec = congViec;
    }
}
