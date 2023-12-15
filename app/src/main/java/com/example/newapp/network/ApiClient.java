package com.example.newapp.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.0.103:8080/api/";
    private static Retrofit retrofit = null;

    private ApiClient() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    }

    public static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        Log.d("ApiClient", "Retrofit instance created");
        Log.d("ApiClient", String.valueOf(retrofit == null));
        return retrofit;
    }

    public static ApiService getApiService() {
        ApiService apiService = getRetrofitInstance().create(ApiService.class);
        Log.d("ApiClient", "ApiService instance created");
        return apiService;
    }
}