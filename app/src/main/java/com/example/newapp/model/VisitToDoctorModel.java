package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class VisitToDoctorModel {
    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private long date;

    @SerializedName("reason")
    private String reason;

    @SerializedName("address")
    private String address;

    @SerializedName("doctor")
    private DoctorModel doctor;

    // Геттеры и сеттеры для каждого поля

    public int getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getReason() {
        return reason;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }
}
