package com.nth.sky.repository;

import com.nth.sky.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Integer> {
    List<Cosmetic> findByType(Cosmetic.Type type);
    List<Cosmetic> findBySpiritId(Integer spiritId);
    Optional<Cosmetic> findById(int id);
    Optional<Cosmetic> findByName(String name);
}
