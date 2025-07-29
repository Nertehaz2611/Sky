package com.nth.sky.service;

import com.nth.sky.model.Quest;
import com.nth.sky.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {
    @Autowired
    private QuestRepository questRepository;

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public Optional<Quest> getQuestById(int id) {
        return questRepository.findById(id);
    }

    public Optional<Quest> getQuestByTitle(String title) {
        return questRepository.findByTitle(title);
    }

    public List<Quest> getQuestsBySeasonId(int seasonId) {
        return questRepository.findBySeasonId(seasonId);
    }

    public Quest createQuest(Quest quest) {
        return questRepository.save(quest);
    }

    public Optional<Quest> updateQuest(int id, Quest questDetails) {
        return questRepository.findById(id).map(quest -> {
            quest.setTitle(questDetails.getTitle());
            quest.setImg(questDetails.getImg());
            quest.setSeason(questDetails.getSeason());
            quest.setStory(questDetails.getStory());
            return questRepository.save(quest);
        });
    }

    public void deleteQuest(int id) {
        questRepository.deleteById(id);
    }
}
