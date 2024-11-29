package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CONG_VIEC")
@IdClass(CongViecId.class)
public class CongViec {



    @Id
    private String soCMND;

    @Id
    @Temporal(TemporalType.DATE)
    private Date ngayVaoCongTy;

    @ManyToOne
    @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false)
    private Nganh nganh;

    private String tenCongViec;
    private String tenCongTy;
    private String diaChiCongTy;
    private String maNganh;
    private int thoiGianLamViec;

    @ManyToOne
    @JoinColumn(name = "soCMND", referencedColumnName = "soCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;

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

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
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

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public int getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(int thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
}
