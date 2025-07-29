package com.nth.sky.service;

import com.nth.sky.model.Cosmetic;
import com.nth.sky.repository.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticService {
    @Autowired
    private CosmeticRepository cosmeticRepository;

    public List<Cosmetic> getAllCosmetics() {
        return cosmeticRepository.findAll();
    }

    public List<Cosmetic> getCosmeticsBySpiritId(int spiritId) {
        return cosmeticRepository.findBySpiritId(spiritId);
    }

    public List<Cosmetic> getCosmeticsByType(Cosmetic.Type type) {
        return cosmeticRepository.findByType(type);
    }

    public Optional<Cosmetic> getCosmeticById(int id) {
        return cosmeticRepository.findById(id);
    }

    public Optional<Cosmetic> getCosmeticByName(String name) {
        return cosmeticRepository.findByName(name);
    }

    public Cosmetic createCosmetic(Cosmetic cosmetic) {
        return cosmeticRepository.save(cosmetic);
    }

    public Optional<Cosmetic> updateCosmetic(int id, Cosmetic cosmeticDetails) {
        return cosmeticRepository.findById(id).map(cosmetic -> {
            cosmetic.setName(cosmeticDetails.getName());
            cosmetic.setType(cosmeticDetails.getType());
            cosmetic.setImg(cosmeticDetails.getImg());
            cosmetic.setSpirit(cosmeticDetails.getSpirit());
            return cosmeticRepository.save(cosmetic);
        });
    }

    public void deleteCosmetic(int id) {
        cosmeticRepository.deleteById(id);
    }
}
