package com.example.dombrovsky_de.network.service;

import com.example.dombrovsky_de.network.Cats.CatsResponce;
import com.example.dombrovsky_de.network.Cats.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("cats.json")
    Call<Data> doCats();

}
