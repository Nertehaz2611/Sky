package com.nth.sky.service;

import com.nth.sky.model.Season;
import com.nth.sky.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Optional<Season> getSeasonById(int id) {
        return seasonRepository.findById(id);
    }

    public List<Season> getSeasonByName(String name) {
        return seasonRepository.findByNameContainingIgnoreCase(name);
    }

    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    public Optional<Season> updateSeason(Season seasonDetails) {
        return seasonRepository.findById(seasonDetails.getId()).map(season -> {
            season.setName(seasonDetails.getName());
            season.setTitle(seasonDetails.getTitle());
            season.setStory(seasonDetails.getStory());
            season.setQuests(seasonDetails.getQuests());
            season.setSpirits(seasonDetails.getSpirits());
            season.setIcon(seasonDetails.getIcon());
            season.setBg_img(seasonDetails.getBg_img());
            season.setVideo(seasonDetails.getVideo());
            season.setStart(seasonDetails.getStart());
            season.setEnd(seasonDetails.getEnd());
            return seasonRepository.save(season);
        });
    }

    public void deleteSeason(int id) {
        seasonRepository.deleteById(id);
    }
}
