package com.example.newapp.network;

import com.example.newapp.model.AuthRequest;
import com.example.newapp.model.LoginResponse;
import com.example.newapp.model.RegistrationModelWithEmail;
import com.example.newapp.model.RegistrationModelWithPhone;
import com.example.newapp.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<LoginResponse> authenticate(@Body AuthRequest authRequest);

    @POST("register")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithPhone registrationModel);

    @POST("register")
    Call<RegistrationResponse> authenticate(@Body RegistrationModelWithEmail registrationModel);
}
