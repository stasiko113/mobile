package com.example.newapp.network;

import com.example.newapp.model.AuthRequest;
import com.example.newapp.model.LoginResponse;
import com.example.newapp.model.UserExistenceResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("auth")
    Call<LoginResponse> authenticate(@Body AuthRequest authRequest);

}
