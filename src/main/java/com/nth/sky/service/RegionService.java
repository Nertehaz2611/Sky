package com.nth.sky.service;

import com.nth.sky.model.Region;
import com.nth.sky.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Optional<Region> getRegionById(int id) {
        return regionRepository.findById(id);
    }

    public List<Region> getRegionByName(String name) {
        return regionRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Region> getRegionsByRealmId(int realmId) {
        return regionRepository.findByRealmId(realmId);
    }

    public List<Region> getRegionsByRealmName(String realmName) {
        return regionRepository.findByRealmName(realmName);
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public Optional<Region> updateRegion(Region regionDetails) {
        return regionRepository.findById(regionDetails.getId()).map(region -> {
            region.setName(region.getName());
            region.setTitle(region.getTitle());
            region.setSnippet(region.getSnippet());
            region.setRealm(region.getRealm());
            region.setImg(region.getImg());
            return regionRepository.save(region);
        });
    }

    public void deleteRegion(int id) {
        regionRepository.deleteById(id);
    }
}
