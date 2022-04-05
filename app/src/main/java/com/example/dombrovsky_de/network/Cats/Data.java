package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;

public class Data {
    //@SerializedName("data")
    //private String data;
    @SerializedName("cats")
    List<CatsResponce> cats;


    public List<CatsResponce> getDoCats() {
        return cats;
    }

//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }

    public void setDoCats(List<CatsResponce> doCats) {
        this.cats = doCats;
    }
}
