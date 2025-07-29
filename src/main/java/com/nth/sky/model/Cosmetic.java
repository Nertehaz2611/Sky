package com.nth.sky.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Generated;

@Entity
@Table(name = "cosmetic")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String img;

    @ManyToOne
    @JoinColumn(name = "spirit_id")
    private Spirit spirit;

    public Cosmetic() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Spirit getSpirit() {
        return spirit;
    }

    public void setSpirit(Spirit spirit) {
        this.spirit = spirit;
    }
}
