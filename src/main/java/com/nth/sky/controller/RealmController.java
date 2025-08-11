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

    @PostMapping()
    public Realm createRealm(@RequestBody Realm realm) {
        return realmService.createRealm(realm);
    }

    @PutMapping()
    public Optional<Realm> updateRealm(@RequestBody Realm realm) {
        return realmService.updateRealm(realm);
    }

    @DeleteMapping("/{id}")
    public void deleteRealmById(@PathVariable int id) {
        realmService.deleteRealm(id);
    }
}
