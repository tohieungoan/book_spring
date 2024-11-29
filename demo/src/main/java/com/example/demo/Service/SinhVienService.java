package com.example.demo.service;

import com.example.demo.models.*;
import com.example.demo.repository.NganhRepository;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.repository.TotNghiepRepository;
import com.example.demo.repository.TruongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {
    private static final Logger logger = LoggerFactory.getLogger(SinhVienService.class);
    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private TotNghiepRepository totNghiepRepository;
    private TruongRepository truongRepository;
    private NganhRepository nganhRepository;
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public void saveSinhVienAndTotNghiep(SinhVien sinhVien2) {
        sinhVienRepository.save(sinhVien2);
    }

    // Tìm sinh viên theo email
    public SinhVien getSinhVienByEmail(String email) {
        return sinhVienRepository.findByEmail(email);
    }

    public Optional<SinhVien> getSinhVienBySoCMND(String cmnd) {
        return sinhVienRepository.findBySoCMND(cmnd);  // Giả sử bạn đang sử dụng phương thức này trong repository
    }
    public SinhVien getSinhVienWithDetails(String soCMND) {
        List<Object[]> results = sinhVienRepository.findSinhVienWithCongViecAndTotNghiepNative(soCMND);

        if (results != null && !results.isEmpty()) {
            // Lấy dòng đầu tiên từ kết quả
            Object[] row = results.get(0);

            // In ra toàn bộ dữ liệu trong mảng row
            System.out.println("Dữ liệu trả về từ truy vấn:");
            for (int i = 0; i < row.length; i++) {
                System.out.println("row[" + i + "]: " + row[i]);
            }

            // Tạo đối tượng SinhVien từ kết quả truy vấn
            try {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setSoCMND((String) row[0]);
                sinhVien.setHoTen((String) row[3]);
                sinhVien.setEmail((String) row[2]);
                sinhVien.setSoDT((String) row[4]);
                sinhVien.setDiaChi((String) row[1]);

                // Tạo danh sách công việc
                List<CongViec> congViecList = new ArrayList<>();
                CongViec congViec = new CongViec();
                congViec.setTenCongTy((String) row[10]);
                congViec.setDiaChiCongTy((String) row[7]);
                congViecList.add(congViec); // Thêm công việc vào danh sách

                sinhVien.setCongViecList(congViecList); // Gán danh sách công việc vào SinhVien

                // Tạo thông tin tốt nghiệp
                List<TotNghiep> totNghiepList = new ArrayList<>();
                TotNghiep totNghiep = new TotNghiep();
                totNghiep.setNgayTN((Date) row[5]);

                // Tìm kiếm Nganh từ database và gán vào TotNghiep

                totNghiep.setMaNganh((String)row[12]);

                // Tìm kiếm Truong từ database và gán vào TotNghiep
                totNghiep.setMaTruong((String)row[13]);

                totNghiep.setHeTN((String) row[15]);
                totNghiep.setLoaiTN((String) row[16]);

                totNghiepList.add(totNghiep); // Thêm thông tin tốt nghiệp vào danh sách
                sinhVien.setTotNghiepList(totNghiepList); // Gán danh sách tốt nghiệp vào SinhVien

                return sinhVien;
            } catch (Exception e) {
                System.err.println("Lỗi khi tạo SinhVien từ kết quả truy vấn: " + e.getMessage());
                return null;
            }
        }
        return null; // Trả về null nếu không có kết quả
    }



    public List<SinhVien> getSinhVienByHoTen(String hoTen) {
        return sinhVienRepository.findByHoTen(hoTen);
    }

}
