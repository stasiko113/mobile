package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChildModel {
    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("visitToDoctors")
    private List<VisitToDoctorModel> visitToDoctors;

    // Геттеры и сеттеры для каждого поля

    public int getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<VisitToDoctorModel> getVisitToDoctors() {
        return visitToDoctors;
    }
}
