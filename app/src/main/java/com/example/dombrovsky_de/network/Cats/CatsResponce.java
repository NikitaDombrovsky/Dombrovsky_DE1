package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatsResponce {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("contact")
    Contact contact;

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
