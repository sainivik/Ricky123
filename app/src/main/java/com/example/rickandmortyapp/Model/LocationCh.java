package com.example.rickandmortyapp.Model;

import com.google.gson.annotations.SerializedName;

public class LocationCh {
    @SerializedName("name")
    private String locationname;

    public String getLocationname() {
        return locationname;
    }
}
