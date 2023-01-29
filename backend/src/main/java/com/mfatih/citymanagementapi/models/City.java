package com.mfatih.citymanagementapi.models;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.Nullable;

import javax.persistence.*;

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

    private String name;
    @Column(length=1000)
    private String photoUrl;

    public void setName(String name) {
        this.name = name;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}