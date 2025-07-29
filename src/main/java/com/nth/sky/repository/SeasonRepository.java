package com.nth.sky.repository;

import com.nth.sky.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
    Optional<Season> findById(int id);
    Optional<Season> findByName(String name);
}
