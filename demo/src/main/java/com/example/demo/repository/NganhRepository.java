package com.example.demo.repository;

import com.example.demo.models.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NganhRepository extends JpaRepository<Nganh, String> {
    Nganh findByMaNganh(String maNganh);
}