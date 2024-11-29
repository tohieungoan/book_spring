package com.example.demo.model;
import java.util.Objects;
import java.io.Serializable;

public class TotNghiepId implements Serializable {
    private String soCMND;
    private String maTruong;
    private String maNganh;

    // Constructor mặc định
    public TotNghiepId() {}

    // Constructor có tham số (nếu cần thiết)
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

    // Phương thức equals() và hashCode() là bắt buộc cho lớp ID trong JPA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotNghiepId that = (TotNghiepId) o;
        return soCMND.equals(that.soCMND) && maTruong.equals(that.maTruong) && maNganh.equals(that.maNganh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, maTruong, maNganh);
    }
}
