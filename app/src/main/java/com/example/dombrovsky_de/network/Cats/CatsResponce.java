package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatsResponce {
    @SerializedName("data")
    @Expose
    private List<CatsMain> data;

    public List<CatsMain> getData() {
        return data;
    }

    public void setData(List<CatsMain> data) {
        this.data = data;
    }


}
