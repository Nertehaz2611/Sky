package com.nth.sky.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;


@Entity
@Table(name = "realm")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Realm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String story;

    @Column(columnDefinition = "TEXT")
    private String bg_img;

    @Column(columnDefinition = "TEXT")
    private String video;

    @OneToMany(mappedBy = "realm", cascade = CascadeType.ALL)
    private List<Region> regions;

    @OneToMany(mappedBy = "realm", cascade = CascadeType.ALL)
    private List<Spirit> spirits;

    public Realm() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Spirit> getSpirits() {
        return spirits;
    }

    public void setSpirits(List<Spirit> spirits) {
        this.spirits = spirits;
    }
}
