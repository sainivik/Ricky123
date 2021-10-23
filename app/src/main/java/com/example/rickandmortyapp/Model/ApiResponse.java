package com.example.rickandmortyapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {
    @SerializedName("info")
    private EpisodePageInfo info;
    @SerializedName("results")
    private ArrayList<Episodes> episodes;


    public EpisodePageInfo getInfo() {
        return info;
    }

    public void setInfo(EpisodePageInfo info) {
        this.info = info;
    }

    public ArrayList<Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episodes> episodes) {
        this.episodes = episodes;
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
