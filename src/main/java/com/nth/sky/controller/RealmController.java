package com.nth.sky.controller;

import com.nth.sky.model.Realm;
import com.nth.sky.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realm")
public class RealmController {

    @Autowired
    private RealmService realmService;

    @GetMapping()
    public List<Realm> getAllRealms() {
        return realmService.getAllRealms();
    }

    @GetMapping("/{id}")
    public Optional<Realm> getRealmById(@PathVariable int id) {
        return realmService.getRealmById(id);
    }

    @GetMapping("/name")
    public List<Realm> getRealmsByName(@RequestParam String name) {
        return realmService.searchRealmsByName(name);
    }

    @PostMapping("/create")
    public Realm createRealm(@RequestBody Realm realm) {
        return realmService.createRealm(realm);
    }

    @PutMapping("/update/{id}")
    public Optional<Realm> updateRealm(@PathVariable int id, @RequestBody Realm realm) {
        Realm existRealm = realmService.getRealmById(id).orElseThrow(() -> new IllegalArgumentException("Invalid realm id: " + id));
        existRealm.setName(realm.getName());
        existRealm.setVideo(realm.getVideo());
        existRealm.setStory(realm.getStory());
        existRealm.setSpirits(realm.getSpirits());
        existRealm.setTitle(realm.getTitle());
        existRealm.setBg_img(realm.getBg_img());
        existRealm.setRegions(realm.getRegions());
        return realmService.updateRealm(existRealm);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRealmById(@PathVariable int id) {
        realmService.deleteRealm(id);
    }
}
