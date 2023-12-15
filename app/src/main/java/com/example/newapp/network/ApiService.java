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

    @GET("users/profile")
    Call<UserModel> getUserData(@Query("id") int id);

    @POST("users/login")
    Call<LoginResponse> authenticate(@Body AuthRequest authRequest);

    @POST("users/registration")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithPhone registrationModel);

    @POST("users/registration")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithEmail registrationModel);
}
