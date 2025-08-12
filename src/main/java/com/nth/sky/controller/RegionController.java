package com.nth.sky.controller;

import com.nth.sky.model.Realm;
import com.nth.sky.model.Region;
import com.nth.sky.repository.RealmRepository;
import com.nth.sky.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private RealmRepository realmRepository;

    @GetMapping()
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public Optional<Region> getRegionById(@PathVariable int id) {
        return regionService.getRegionById(id);
    }

    @GetMapping("/name")
    public List<Region> getRegionByName(@RequestParam String name) {
        return regionService.getRegionByName(name);
    }

    @GetMapping("/realm/{id}")
    public List<Region> getRegionsByRealmId(@PathVariable int id) {
        return regionService.getRegionsByRealmId(id);
    }

    @GetMapping("/realm/name")
    public List<Region> getRegionsByRealmName(@RequestParam String name) {
        return regionService.getRegionsByRealmName(name);
    }

    @PostMapping("/create/realm/{id}")
    public Region createRegion(@PathVariable int id, @RequestBody Region region) {
        Realm realm = realmRepository.findById(id).orElseThrow(() -> new RuntimeException("Realm not found"));
        region.setRealm(realm);
        return regionService.createRegion(region);
    }

    @PutMapping("/update/{id}")
    public Optional<Region> updateRegion(@PathVariable int id, @RequestBody Region region) {
        Region existingRegion = regionService.getRegionById(id).orElseThrow(() -> new RuntimeException("Region not found"));
        existingRegion.setName(region.getName());
        existingRegion.setImg(region.getImg());
        existingRegion.setSnippet(region.getSnippet());
        existingRegion.setTitle(region.getTitle());
        existingRegion.setRealm(region.getRealm());
        return regionService.updateRegion(existingRegion);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRegion(@PathVariable int id) {
        regionService.deleteRegion(id);
    }
}
