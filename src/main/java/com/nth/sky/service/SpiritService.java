package com.nth.sky.service;

import com.nth.sky.model.Spirit;
import com.nth.sky.repository.SpiritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpiritService {
    @Autowired
    private SpiritRepository spiritRepository;

    public List<Spirit> getSpirits() {
        return spiritRepository.findAll();
    }

    public Optional<Spirit> getSpiritById(int id) {
        return spiritRepository.findById(id);
    }

    public Optional<Spirit> getSpiritByName(String name) {
        return spiritRepository.findByName(name);
    }

    public List<Spirit> getSpiritsByRealmId(int realmId) {
        return spiritRepository.findByRealmId(realmId);
    }

    public List<Spirit> getSpiritsBySeason(int seasonId) {
        return spiritRepository.findBySeasonId(seasonId);
    }

    public Spirit createSpirit(Spirit spirit) {
        return spiritRepository.save(spirit);
    }

    public Optional<Spirit> updateSpirit(int id, Spirit spiritDetails) {
        return spiritRepository.findById(id).map(spirit -> {
            spirit.setName(spiritDetails.getName());
            spirit.setSnippet(spiritDetails.getSnippet());
            spirit.setCosmetics(spiritDetails.getCosmetics());
            spirit.setRealm(spiritDetails.getRealm());
            spirit.setSeason(spiritDetails.getSeason());
            spirit.setImg(spiritDetails.getImg());
            return spiritRepository.save(spirit);
        });
    }

    public void deleteSpirit(int id) {
        spiritRepository.deleteById(id);
    }
}
