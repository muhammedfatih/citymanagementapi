package com.mfatih.citymanagementapi.models;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public City(){
        this.name="";
        this.photoUrl="";
    }
    public City(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    private final String name;
    private final String photoUrl;
}