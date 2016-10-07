package com.lendmybook.dagorik.spotifyplayer.interfaces;

import com.lendmybook.dagorik.spotifyplayer.models.object;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dagorik on 04/10/2016.
 */

public interface SpotifyTracksClient {


    @GET("/v1/search?type=track&limit=10")
    Call<object> getArtista(@Query("q") String artistName);
}
