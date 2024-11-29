package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;  // Thêm import cho @Id
import jakarta.persistence.ManyToOne; // Thêm import cho @ManyToOne
import jakarta.persistence.JoinColumn; // Thêm import cho @JoinColumn
import jakarta.persistence.Table;
import jakarta.persistence.IdClass; // Thêm import cho @IdClass
import java.util.Date;

@Entity
@Table(name = "TOT_NGHIEP")
@IdClass(TotNghiepId.class)  // Sử dụng @IdClass cho khóa chính composite
public class TotNghiep {

    @Id
    private String soCMND;
    @Id
    private String maTruong;
    @Id
    private String maNganh;
    private String heTN;
    private Date ngayTN;
    private String loaiTN;

    // Mối quan hệ ManyToOne với SinhVien
    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;

    // Mối quan hệ ManyToOne với Truong
    @ManyToOne
    @JoinColumn(name = "maTruong", referencedColumnName = "maTruong", insertable = false, updatable = false)
    private Truong truong;

    // Mối quan hệ ManyToOne với Nganh
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
}
