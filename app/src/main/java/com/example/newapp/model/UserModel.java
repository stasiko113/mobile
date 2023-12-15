package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserModel {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("phone")
    private String phone;

    @SerializedName("email")
    private String email;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("genderType")
    private String genderType;

    @SerializedName("userType")
    private String userType;

    @SerializedName("childs")
    private List<ChildModel> childs;

    // Геттеры и сеттеры для каждого поля

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGenderType() {
        return genderType;
    }

    public String getUserType() {
        return userType;
    }

    public List<ChildModel> getChilds() {
        return childs;
    }
}

