package com.nth.sky.repos;

import com.nth.sky.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmeticRepo extends JpaRepository<Cosmetic, Integer> {
    List<Cosmetic> findBySpiritId(Integer spiritId);
    Cosmetic findById(int id);
}
