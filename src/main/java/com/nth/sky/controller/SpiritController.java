package com.nth.sky.controller;

import com.nth.sky.model.Realm;
import com.nth.sky.model.Season;
import com.nth.sky.model.Spirit;
import com.nth.sky.service.RealmService;
import com.nth.sky.service.SeasonService;
import com.nth.sky.service.SpiritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spirit")
public class SpiritController {

    @Autowired
    private SpiritService spiritService;
    @Autowired
    private RealmService realmService;
    @Autowired
    private SeasonService seasonService;

    @GetMapping()
    public List<Spirit> getSpirits() {
        return spiritService.getSpirits();
    }

    @GetMapping("/{id}")
    public Optional<Spirit> getSpiritById(@PathVariable int id) {
        return spiritService.getSpiritById(id);
    }

    @GetMapping("/name")
    public List<Spirit> getSpiritByName(@RequestParam String name) {
        return spiritService.searchSpiritsByName(name);
    }

    @GetMapping("/realm/{id}")
    public List<Spirit> getSpiritByRealm(@PathVariable int id) {
        return spiritService.getSpiritsByRealmId(id);
    }

    @GetMapping("/season/{id}")
    public List<Spirit> getSpiritBySeason(@PathVariable int id) {
        return spiritService.getSpiritsBySeason(id);
    }

    @PostMapping("/create/realm/{id}")
    public Spirit createSpiritByRealm(@PathVariable int id, @RequestBody Spirit spirit) {
        Realm realm = realmService.getRealmById(id).orElseThrow(() -> new RuntimeException("Realm not found"));
        spirit.setRealm(realm);
        spirit.setSeason(null);
        return spiritService.createSpirit(spirit);
    }

    @PostMapping("/create/season/{id}")
    public Spirit createSpiritBySeason(@PathVariable int id, @RequestBody Spirit spirit) {
        Season season = seasonService.getSeasonById(id).orElseThrow(() -> new RuntimeException("Season not found"));
        spirit.setSeason(season);
        spirit.setRealm(null);
        return spiritService.createSpirit(spirit);
    }

    @PutMapping("/update/{id}")
    public Optional<Spirit> updateSpirit(@PathVariable int id, @RequestBody Spirit spirit) {
        Spirit existingSpirit = spiritService.getSpiritById(id).orElseThrow(() -> new RuntimeException("Spirit not found"));
        existingSpirit.setName(spirit.getName());
        existingSpirit.setSeason(spirit.getSeason());
        existingSpirit.setRealm(spirit.getRealm());
        existingSpirit.setImg(spirit.getImg());
        existingSpirit.setSnippet(spirit.getSnippet());
        existingSpirit.setCosmetics(spirit.getCosmetics());
        return spiritService.updateSpirit(existingSpirit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSpirit(@PathVariable int id) {
        spiritService.deleteSpirit(id);
    }
}
