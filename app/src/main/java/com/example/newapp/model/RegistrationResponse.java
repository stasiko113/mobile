package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {
    @SerializedName("user")
    private UserModel user;

    @SerializedName("token")
    private String token;

    public UserModel getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

}
