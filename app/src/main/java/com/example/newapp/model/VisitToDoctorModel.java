package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class VisitToDoctorModel {
    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private long date;

    @SerializedName("doctor")
    private DoctorModel doctor;

    // Геттеры и сеттеры для каждого поля

    public int getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }
}
