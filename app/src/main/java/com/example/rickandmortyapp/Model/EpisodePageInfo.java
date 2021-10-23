package com.example.rickandmortyapp.Model;

import com.google.gson.annotations.SerializedName;

public class EpisodePageInfo {
    @SerializedName("count")
    private int count;
    @SerializedName("pages")
    private int pages;
    @SerializedName("next")
    private String nexturl;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNexturl() {
        return nexturl;
    }

    public void setNexturl(String nexturl) {
        this.nexturl = nexturl;
    }

    public String getPrevurl() {
        return prevurl;
    }

    public void setPrevurl(String prevurl) {
        this.prevurl = prevurl;
    }

    @SerializedName("prev")
    private String prevurl;
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