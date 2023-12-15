package com.example.newapp.network;

import com.example.newapp.model.AuthRequest;
import com.example.newapp.model.LoginResponse;
import com.example.newapp.model.RegistrationModelWithEmail;
import com.example.newapp.model.RegistrationModelWithPhone;
import com.example.newapp.model.RegistrationResponse;
import com.example.newapp.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("yourApiEndpoint")
    Call<UserModel> getUserData(@Query("id") int id);

    @POST("login")
    Call<LoginResponse> authenticate(@Body AuthRequest authRequest);

    @POST("register")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithPhone registrationModel);

    @POST("register")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithEmail registrationModel);
}
