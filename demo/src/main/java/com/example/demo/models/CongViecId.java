package com.example.demo.models;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CongViecId implements Serializable {
    private String soCMND;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayVaoCongTy;


    public CongViecId() {
    }


    public CongViecId(String soCMND, Date ngayVaoCongTy) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

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
