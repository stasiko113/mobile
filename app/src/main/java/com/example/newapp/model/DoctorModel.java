package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class DoctorModel {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("specialization")
    private String specialization;

    // Геттеры и сеттеры для каждого поля

    public int getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public String getSpecialization() {
        return specialization;
    }
}
