package com.mfatih.citymanagementapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "photoUrl"})
public class CityCsv {
    @JsonProperty("id")
    long id;
    @JsonProperty("name")
    String name;

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    String photo;

    public CityCsv() {
    }
}
