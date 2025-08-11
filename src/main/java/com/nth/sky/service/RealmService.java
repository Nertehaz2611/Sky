package com.nth.sky.service;

import com.nth.sky.model.Realm;
import com.nth.sky.repository.RealmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealmService {
    @Autowired
    private RealmRepository realmRepository;

    public List<Realm> getAllRealms() {
        return realmRepository.findAll();
    }

    public Optional<Realm> getRealmById(int id) {
        return realmRepository.findById(id);
    }

    public List<Realm> searchRealmsByName(String name) {
        return realmRepository.findByNameContainingIgnoreCase(name);
    }

    public Realm createRealm(Realm realm) {
        return realmRepository.save(realm);
    }

    public Optional<Realm> updateRealm(Realm realmDetails) {
        return realmRepository.findById(realmDetails.getId()).map(realm -> {
           realm.setName(realmDetails.getName());
           realm.setRegions(realmDetails.getRegions());
           realm.setTitle(realmDetails.getTitle());
           realm.setStory(realmDetails.getStory());
           realm.setSpirits(realmDetails.getSpirits());
           realm.setBg_img(realmDetails.getBg_img());
           realm.setVideo(realmDetails.getVideo());
           return realmRepository.save(realm);
        });
    }

    public void deleteRealm(int id) {
        realmRepository.deleteById(id);
    }
}
