package com.example.demo.repository;

import com.example.demo.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    SinhVien findByEmail(String email);
    SinhVien findBySoDT(String soDT);
    SinhVien findBySoCMND(String soCMND);
    List<SinhVien> findByHoTen(String hoTen);

    @Query("SELECT sv FROM SinhVien sv " +
            "LEFT JOIN FETCH sv.totNghiep tn " +
            "LEFT JOIN FETCH sv.congViec cv " +
            "WHERE sv.soCMND = :soCMND")
    SinhVien findSinhVienWithTotNghiepAndCongViec(@Param("soCMND") String soCMND);
}
