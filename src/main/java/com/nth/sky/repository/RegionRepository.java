package com.nth.sky.repository;

import com.nth.sky.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    List<Region> findByRealmId(int realmId);
    List<Region> findByRealmName(String realmName);
    Optional<Region> findById(int id);
    Optional<Region> findByName(String name);
}
