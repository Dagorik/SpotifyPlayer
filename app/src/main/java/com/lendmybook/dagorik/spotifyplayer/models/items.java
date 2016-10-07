package com.lendmybook.dagorik.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dagorik on 26/09/2016.
 */

public class items {

    public album getAlbun() {
        return albun;
    }

    public void setAlbun(album albun) {
        this.albun = albun;
    }

    @SerializedName("album")
    private album albun;

}
