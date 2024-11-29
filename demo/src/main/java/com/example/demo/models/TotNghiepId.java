package com.example.demo.models;
import java.io.Serializable;
import java.util.Objects;

public class TotNghiepId implements Serializable {

    private String soCMND;
    private String maTruong;
    private String maNganh;

    // Constructor không tham số
    public TotNghiepId() {
    }

    // Constructor đầy đủ tham số
    public TotNghiepId(String soCMND, String maTruong, String maNganh) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
    }

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

    // Ghi đè equals() và hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotNghiepId that = (TotNghiepId) o;
        return Objects.equals(soCMND, that.soCMND) &&
                Objects.equals(maTruong, that.maTruong) &&
                Objects.equals(maNganh, that.maNganh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, maTruong, maNganh);
    }
}
