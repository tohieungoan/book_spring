package com.example.demo.Service;

import com.example.demo.model.CongViec;
import com.example.demo.repository.CongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CongViec getCongViecBySoCMND(String soCMND) {
        return congViecRepository.findBySoCMND(soCMND);
    }



}
