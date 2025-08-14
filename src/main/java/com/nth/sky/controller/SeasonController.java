package com.nth.sky.controller;

import com.nth.sky.model.Season;
import com.nth.sky.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/season")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping()
    public List<Season> getSeasons() {
        return seasonService.getAllSeasons();
    }

    @GetMapping("/{id}")
    public Optional<Season> getSeasonById(@PathVariable int id) {
        return seasonService.getSeasonById(id);
    }

    @GetMapping("/name")
    public List<Season> getSeasonByName(@RequestParam String name) {
        return seasonService.getSeasonByName(name);
    }

    @PostMapping("/create")
    public Season createSeason(@RequestBody Season season) {
        return seasonService.createSeason(season);
    }

    @PutMapping("/update/{id}")
    public Optional<Season> updateSeason(@PathVariable int id, @RequestBody Season season) {
        Season existingSeason = seasonService.getSeasonById(id).orElseThrow(() -> new RuntimeException("Season not found"));
        existingSeason.setName(season.getName());
        existingSeason.setIcon(season.getIcon());
        existingSeason.setStart(season.getStart());
        existingSeason.setEnd(season.getEnd());
        existingSeason.setVideo(season.getVideo());
        existingSeason.setSpirits(season.getSpirits());
        existingSeason.setBg_img(season.getBg_img());
        existingSeason.setStory(season.getStory());
        existingSeason.setTitle(season.getTitle());
        existingSeason.setQuests(season.getQuests());
        return seasonService.updateSeason(existingSeason);
    }

    @DeleteMapping("/delete")
    public void deleteSeason(@RequestParam int id) {
        seasonService.deleteSeason(id);
    }
}
