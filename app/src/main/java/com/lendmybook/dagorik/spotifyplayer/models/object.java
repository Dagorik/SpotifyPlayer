package com.lendmybook.dagorik.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dagorik on 26/09/2016.
 */

public class object {

@SerializedName("tracks")
    private tracks trackse;

    public tracks getTrackse() {
        return trackse;
    }

    public void setTrackse(tracks trackse) {
        this.trackse = trackse;
    }
}
