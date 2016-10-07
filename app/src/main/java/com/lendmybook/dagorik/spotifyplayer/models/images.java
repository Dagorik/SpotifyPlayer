package com.lendmybook.dagorik.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dagorik on 26/09/2016.
 */

public class images {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
