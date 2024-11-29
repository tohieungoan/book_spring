package com.example.demo.Service;
import com.example.demo.model.Nganh;
import com.example.demo.repository.NganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NganhService {
    @Autowired
    private NganhRepository nganhRepository;
    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }
    public void saveNganh(Nganh nganh) {
        nganhRepository.save(nganh);
    }
    public Nganh getNganhByMaNganh(String MaNganh) {
        return nganhRepository.findByMaNganh(MaNganh);
    }

}
