package com.example.newapp.model;

import com.google.gson.annotations.SerializedName;

public class UserExistenceResponse {
    @SerializedName("userExists")
    private boolean userExists;

    public boolean isUserExists() {
        return userExists;
    }
}
