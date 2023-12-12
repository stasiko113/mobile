package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class AuthRequest {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
