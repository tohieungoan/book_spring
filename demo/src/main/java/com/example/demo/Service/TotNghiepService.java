package com.example.demo.service;

import com.example.demo.models.CongViec;
import com.example.demo.models.TotNghiep;
import com.example.demo.repository.TotNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TotNghiepService {

    @Autowired
    private TotNghiepRepository totNghiepRepository;

    // Lưu thông tin tốt nghiệp
    public TotNghiep save(TotNghiep totNghiep) {
        return totNghiepRepository.save(totNghiep);
    }

    // Tìm kiếm thông tin tốt nghiệp theo số CMND của sinh viên
    public List<TotNghiep> findBySinhVienSoCMND(String soCMND) {
        return totNghiepRepository.findBySinhVien_SoCMND(soCMND);
    }
    public List<TotNghiep> getAllTotNghiep() {
        return totNghiepRepository.findAll();
    }

    // Tìm kiếm theo loại tốt nghiệp
    public List<TotNghiep> findByLoaiTN(String loaiTN) {
        return totNghiepRepository.findByLoaiTN(loaiTN);
    }

    // Tìm kiếm theo hệ tốt nghiệp và mã ngành
    public List<TotNghiep> findByHeTNAndMaNganh(String heTN, String maNganh) {
        return totNghiepRepository.findByHeTNAndMaNganh(heTN, maNganh);
    }

    // Tìm kiếm theo mã trường
    public List<TotNghiep> findByMaTruong(String maTruong) {
        return totNghiepRepository.findByMaTruong(maTruong);
    }

    // Tìm kiếm thông tin tốt nghiệp theo ID
    public Optional<TotNghiep> findById(Long id) {
        return totNghiepRepository.findById(id);
    }

    // Xóa thông tin tốt nghiệp theo ID
    public void deleteById(Long id) {
        totNghiepRepository.deleteById(id);
    }
}
