package com.example.demo.repository;
import com.example.demo.model.TotNghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, String> {
    TotNghiep findBySoCMND(String SoCMND);
    TotNghiep findByMaTruong(String MaTruong);
    TotNghiep findByMaNganh(String MaNganh);
}