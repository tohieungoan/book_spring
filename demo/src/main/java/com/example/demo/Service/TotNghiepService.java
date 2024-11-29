package com.example.demo.Service;
import com.example.demo.model.TotNghiep;
import com.example.demo.repository.TotNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotNghiepService {
    @Autowired
    TotNghiepRepository totNghiepRepository;
    public List<TotNghiep> findallTotNghiep() {
        return totNghiepRepository.findAll();
    }
    public void saveTotNghiep(TotNghiep totNghiep) {
        totNghiepRepository.save(totNghiep);
    }
    public TotNghiep findTotNghiepBySoCMND(String soCMND) {
        return totNghiepRepository.findBySoCMND(soCMND);
    }
    public TotNghiep findTotNghiepByMaTruong(String MaTruong){
        return totNghiepRepository.findByMaTruong(MaTruong);
    }
    public TotNghiep findTotNghiepByMaNganh(String MaNganh){
        return totNghiepRepository.findByMaNganh(MaNganh);
    }
}
