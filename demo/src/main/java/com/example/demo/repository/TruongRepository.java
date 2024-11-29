package com.example.demo.repository;

import com.example.demo.models.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruongRepository extends JpaRepository<Truong, String> {
    Truong findByMaTruong(String MaTruong);
}
