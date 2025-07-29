package com.nth.sky.repository;

import com.nth.sky.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {
    Optional<Quest> findById(int id);
    Optional<Quest> findByTitle(String title);
    List<Quest> findBySeasonId(int seasonId);
}
