package com.lendmybook.dagorik.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dagorik on 04/10/2016.
 */

public class tracks {

    @SerializedName("href")
    private String href;

    @SerializedName("items")
    List<items> itemses;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<items> getItemses() {
        return itemses;
    }

    public void setItemses(List<items> itemses) {
        this.itemses = itemses;
    }
}
