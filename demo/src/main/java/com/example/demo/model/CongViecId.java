package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CongViecId implements Serializable {

    private String soCMND;
    private Date ngayVaoCongTy;

    // Constructor
    public CongViecId() {}

    public CongViecId(String soCMND, Date ngayVaoCongTy) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    // Getters and Setters
    public String getsoCMND() {
        return soCMND;
    }

    public void setsoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Date getngayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setngayVaoCongTy(Date ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongViecId that = (CongViecId) o;
        return Objects.equals(soCMND, that.soCMND) &&
                Objects.equals(ngayVaoCongTy, that.ngayVaoCongTy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, ngayVaoCongTy);
    }
}
