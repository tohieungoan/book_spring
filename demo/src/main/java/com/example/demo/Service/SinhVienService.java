package com.example.demo.Service;

import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    // Lưu một sinh viên
    public void saveSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    // Tìm sinh viên theo email
    public SinhVien getSinhVienByEmail(String email) {
        return sinhVienRepository.findByEmail(email);
    }

    public SinhVien getSinhVienBySoCMND(String SoCMND) {
        return sinhVienRepository.findBySoDT(SoCMND);
    }
    public SinhVien getSinhVienWithDetails(String soCMND) {
        return sinhVienRepository.findSinhVienWithTotNghiepAndCongViec(soCMND);
    }
    public List<SinhVien> getSinhVienByHoTen(String hoTen) {
        return sinhVienRepository.findByHoTen(hoTen);
    }
}
