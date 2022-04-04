package com.example.dombrovsky_de.network.service;

import com.example.dombrovsky_de.network.Cats.CatsResponce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("cats.json")
    Call<List<CatsResponce>> doCats();

}
