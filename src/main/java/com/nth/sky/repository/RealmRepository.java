package com.nth.sky.repository;

import com.nth.sky.model.Realm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RealmRepository extends JpaRepository<Realm, Integer> {
    List<Realm> findByNameContainingIgnoreCase(String name);
    Optional<Realm> findById(int id);
}
