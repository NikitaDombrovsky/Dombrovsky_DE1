package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contact {
    @SerializedName("modile")
    private String id;

    @SerializedName("email")
    private String name;

    @SerializedName("skype")
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
