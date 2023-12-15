package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationModelWithPhone {

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("phone")
    private String phone;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("genderType")
    private String genderType;

    @SerializedName("userType")
    private String userType;

    public RegistrationModelWithPhone(String name,String username, String password, String phone, String imageUrl , String genderType , String userType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.genderType = genderType;
        this.userType = userType;
    }

}
