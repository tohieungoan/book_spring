package com.example.demo.repository;

import com.example.demo.models.TotNghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, Long> {

    // Tìm kiếm thông tin tốt nghiệp theo sinh viên (sử dụng soCMND)
    List<TotNghiep> findBySinhVien_SoCMND(String soCMND);

    // Tìm kiếm thông tin tốt nghiệp theo loại tốt nghiệp
    List<TotNghiep> findByLoaiTN(String loaiTN);

    // Tìm kiếm thông tin tốt nghiệp theo hệ tốt nghiệp và mã ngành
    List<TotNghiep> findByHeTNAndMaNganh(String heTN, String maNganh);

    // Tìm kiếm thông tin tốt nghiệp theo mã trường
    List<TotNghiep> findByMaTruong(String maTruong);

    // Tìm kiếm thông tin tốt nghiệp theo mã ngành
    List<TotNghiep> findByMaNganh(String maNganh);

    // Lấy thông tin tốt nghiệp theo ID
    Optional<TotNghiep> findById(Long id);

    // Xóa thông tin tốt nghiệp theo ID
    void deleteById(Long id);
}
