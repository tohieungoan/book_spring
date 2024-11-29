package com.example.demo.service;

import com.example.demo.models.CongViec;
import com.example.demo.models.CongViecId;
import com.example.demo.repository.CongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CongViecService {

    @Autowired
    private CongViecRepository congViecRepository;

    public List<CongViec> getAllCongViec() {
        return congViecRepository.findAll();
    }

    public void saveCongViec(CongViec congViec) {
        congViecRepository.save(congViec);
    }

//    public Optional<CongViec> getCongViecById(String soCMND, String ngayVaoCongTy) {
//        return congViecRepository.findById(new CongViecId(soCMND, Date.valueOf(ngayVaoCongTy)));
//    }

//    public void deleteCongViec(String soCMND, String ngayVaoCongTy) {
//        congViecRepository.deleteById(new CongViecId(soCMND, Date.valueOf(ngayVaoCongTy)));
//    }
}
