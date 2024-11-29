package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@IdClass(TotNghiepId.class)
@Table(name = "TOTNGHIEP")
public class TotNghiep {

    @Id
    private String soCMND;

    @Id
    private String maTruong;

    @Id
    private String maNganh;

    private String heTN;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTN;

    private String loaiTN;

    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "maTruong", referencedColumnName = "maTruong", insertable = false, updatable = false)
    private Truong truong;

    @ManyToOne
    @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false)
    private Nganh nganh;


    // Getter và Setter
    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getHeTN() {
        return heTN;
    }

    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }

    public Date getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(Date ngayTN) {
        this.ngayTN = ngayTN;
    }

    public String getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Truong getTruong() {
        return truong;
    }

    public void setTruong(Truong truong) {
        this.truong = truong;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }
    @Override
    public String toString() {
        return "TotNghiep{" +
                "soCMND='" + soCMND + '\'' +
                ", maTruong='" + maTruong + '\'' +
                ", maNganh='" + maNganh + '\'' +
                ", heTN='" + heTN + '\'' +
                ", ngayTN=" + ngayTN +
                ", loaiTN='" + loaiTN + '\'' +
                ", sinhVien=" + (sinhVien != null ? sinhVien.toString() : "null") +
                ", truong=" + (truong != null ? truong.toString() : "null") +
                ", nganh=" + (nganh != null ? nganh.toString() : "null") +
                '}';
    }
}
