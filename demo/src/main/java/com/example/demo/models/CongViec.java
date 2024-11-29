package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@IdClass(CongViecId.class)
@Table(name = "CONG_VIEC")
public class CongViec {

    @Id
    private String soCMND;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Id
    private Date ngayVaoCongTy;

    private String tenCongViec;
    private String tenCongTy;
    private String diaChiCongTy;

    @Column(name = "ma_nganh", insertable = false, updatable = false)
    private String maNganh;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoiGianLamViec; // Tính bằng tháng hoặc năm, tùy thuộc vào quy ước

    // Ánh xạ ManyToOne với Nganh
    @ManyToOne
    @JoinColumn(name = "ma_nganh", referencedColumnName = "maNganh", insertable = false, updatable = false)
    private Nganh nganh;

    // Ánh xạ ManyToOne với SinhVien
    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;

    // Getters và Setters

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Date getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(Date ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public Date getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(Date thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }
    @Override
    public String toString() {
        return "CongViec{" +
                "soCMND='" + soCMND + '\'' +
                ", ngayVaoCongTy=" + ngayVaoCongTy +
                ", tenCongViec='" + tenCongViec + '\'' +
                ", tenCongTy='" + tenCongTy + '\'' +
                ", diaChiCongTy='" + diaChiCongTy + '\'' +
                ", maNganh='" + maNganh + '\'' +
                ", thoiGianLamViec=" + thoiGianLamViec +
                ", nganh=" + (nganh != null ? nganh.toString() : "null") +
                ", sinhVien=" + (sinhVien != null ? sinhVien.toString() : "null") +
                '}';
    }
}
