package com.example.rickandmortyapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Episodes {
    @SerializedName("id")
    private int epid;
    @SerializedName("name")
    private String epname;
    @SerializedName("air_date")
    private String airdate;
    @SerializedName("episode")
    private String epno;
    @SerializedName("characters")
    private ArrayList<String> charactersurl;
    @SerializedName("url")
    private String epurl;
    @SerializedName("created")
    private String created;

    public int getEpid() {
        return epid;
    }

    public String getEpname() {
        return epname;
    }

    public String getAirdate() {
        return airdate;
    }

    public String getEpno() {
        return epno;
    }

    public ArrayList<String> getCharactersurl() {
        return charactersurl;
    }

    public String getEpurl() {
        return epurl;
    }

    public String getCreated() {
        return created;
    }
}
/*
{
        "info": {
        "count": 41,
        "pages": 3,
        "next": "https://rickandmortyapi.com/api/episode?page=2",
        "prev": null
        },
        "results": [
        {
        "id": 1,
        "name": "Pilot",
        "air_date": "December 2, 2013",
        "episode": "S01E01",
        "characters": [
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2",
        //...
        ],
        "url": "https://rickandmortyapi.com/api/episode/1",
        "created": "2017-11-10T12:56:33.798Z"
        },
        // ...
        ]
        }*/
