package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationModelWithEmail {

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("genderType")
    private String genderType;

    @SerializedName("userType")
    private String userType;

    public RegistrationModelWithEmail(String name, String username, String password, String email, String imageUrl, String genderType, String userType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
        this.genderType = genderType;
        this.userType = userType;
    }

}
