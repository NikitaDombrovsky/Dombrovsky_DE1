package com.example.dombrovsky_de.network;

import com.example.dombrovsky_de.network.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
    private static ApiHandler mInstance;

    private static final String BASE_URL = "http://developer.alexanderklimov.ru/android/apk/";
    private Retrofit retrofit;

    public ApiHandler() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiHandler getInstance(){
        if (mInstance == null){
            mInstance = new ApiHandler();
        }
        return mInstance;
    }
    public ApiService getService(){return retrofit.create(ApiService.class);}
}
