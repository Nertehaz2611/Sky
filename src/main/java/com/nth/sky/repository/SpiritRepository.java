package com.nth.sky.repository;

import com.nth.sky.model.Spirit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpiritRepository extends JpaRepository<Spirit, Integer> {
    Optional<Spirit> findById(int id);
    List<Spirit> findByName(String name);
    List<Spirit> findByRealmId(int realmId);
    List<Spirit> findBySeasonId(int seasonId);
}
