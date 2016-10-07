package com.lendmybook.dagorik.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dagorik on 26/09/2016.
 */

public class album {


    @SerializedName("name")
    private String name;

    @SerializedName("images")
    List<images> images_album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<images> getImages_album() {
        return images_album;
    }

    public void setImages_album(List<images> images_album) {
        this.images_album = images_album;
    }

}
