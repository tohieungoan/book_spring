package com.example.demo.repository;
import com.example.demo.model.Nganh;
import com.example.demo.model.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NganhRepository extends JpaRepository<Nganh, String> {
    Nganh findByMaNganh(String maNganh);
}