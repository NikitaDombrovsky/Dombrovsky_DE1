package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatsMain {
    @SerializedName("cats")
    @Expose
    private List<Cats> cats;
    public List<Cats> getCats() {
        return cats;
    }

    public void setCats(List<Cats> cats) {
        this.cats = cats;
    }

}
