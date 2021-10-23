package com.example.rickandmortyapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Characters {
    @SerializedName("id")
    private int chid;
    @SerializedName("name")
    private String chname;
    @SerializedName("status")
    private String status;
    @SerializedName("species")
    private String species;
    @SerializedName("gender")
    private String gender;
    @SerializedName("location")
    private LocationCh location;
    @SerializedName("image")
    private String imageurl;
    @SerializedName("episode")
    private ArrayList<String> episodes;

    public int getChid() {
        return chid;
    }

    public String getChname() {
        return chname;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() { return gender; }

    public LocationCh getLocation() {
        return location;
    }

    public String getImageurl() {
        return imageurl;
    }

    public ArrayList<String> getEpisodes() {
        return episodes;
    }
}
/*
{
  "id": 2,
  "name": "Morty Smith",
  "status": "Alive",
  "species": "Human",
  "type": "",
  "gender": "Male",
  "origin": {
    "name": "Earth",
    "url": "https://rickandmortyapi.com/api/location/1"
  },
  "location": {
    "name": "Earth",
    "url": "https://rickandmortyapi.com/api/location/20"
  },
  "image": "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
  "episode": [
    "https://rickandmortyapi.com/api/episode/1",
    "https://rickandmortyapi.com/api/episode/2",
    // ...
  ],
  "url": "https://rickandmortyapi.com/api/character/2",
  "created": "2017-11-04T18:50:21.651Z"
}        */
