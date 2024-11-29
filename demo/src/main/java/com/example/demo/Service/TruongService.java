package com.example.demo.Service;
import com.example.demo.model.Truong;
import com.example.demo.repository.TruongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TruongService {
    @Autowired
    private TruongRepository truongRepository;
    public List<Truong> getAllTruong() {
        return truongRepository.findAll();
    }
    public void saveTruong (Truong truong) {
        truongRepository.save(truong);
    }
    public Truong getTruongById(String MaTruong) {
        return truongRepository.findByMaTruong(MaTruong);
    }
}
