package com.example.demo.repository;

import com.example.demo.models.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    SinhVien findByEmail(String email);

    SinhVien findBySoDT(String soDT);

    Optional<SinhVien> findBySoCMND(String cmnd);

    List<SinhVien> findByHoTen(String hoTen);
    @Query(value = "SELECT * FROM SINHVIEN sv " +
            "LEFT JOIN CONG_VIEC cv ON sv.soCMND = cv.soCMND " +
            "LEFT JOIN totnghiep tn ON sv.soCMND = tn.soCMND " +
            "WHERE sv.soCMND = :soCMND", nativeQuery = true)
    List<Object[]> findSinhVienWithCongViecAndTotNghiepNative(@Param("soCMND") String soCMND);

}
