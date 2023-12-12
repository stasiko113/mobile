package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {
    @SerializedName("registrationSuccessful")
    private boolean registrationSuccessful;

    public boolean isRegistrationSuccessful() {
        return registrationSuccessful;
    }
}
