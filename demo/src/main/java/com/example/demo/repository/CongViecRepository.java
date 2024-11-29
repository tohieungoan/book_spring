package com.example.demo.repository;

import com.example.demo.model.CongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, Long> {
    CongViec findBySoCMND(String SoCMND);
}
