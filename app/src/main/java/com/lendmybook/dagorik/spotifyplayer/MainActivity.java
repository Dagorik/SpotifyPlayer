package com.lendmybook.dagorik.spotifyplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lendmybook.dagorik.spotifyplayer.interfaces.SpotifyTracksClient;
import com.lendmybook.dagorik.spotifyplayer.models.album;
import com.lendmybook.dagorik.spotifyplayer.models.items;
import com.lendmybook.dagorik.spotifyplayer.models.object;
import com.lendmybook.dagorik.spotifyplayer.models.tracks;
import com.lendmybook.dagorik.spotifyplayer.models.images;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView tracksRecyclerViews;
    private List<object> trackList = new ArrayList<>();
    private TrackAdapter trackAdapter;
    private EditText findArtist;
    private Button buttonBusqueda;
    private String busquedaDeArtistaUltimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findArtist = (EditText) findViewById(R.id.et_buscar);
        buttonBusqueda = (Button) findViewById(R.id.btn_buscar);

        buttonBusqueda.setOnClickListener(this);
        settingRecyclerView();
    }

    private void settingRecyclerView() {
        tracksRecyclerViews = (RecyclerView) findViewById(R.id.rv_tracks);
        tracksRecyclerViews.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        tracksRecyclerViews.setHasFixedSize(true);

    }

    private void LoadJson(final String artistaName) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpotifyTracksClient client = retrofit.create(SpotifyTracksClient.class);

        client.getArtista(artistaName).enqueue(new Callback<object>() {
            @Override
            public void onResponse(Call<object> call, Response<object> response) {

                object objects = response.body();
                tracks trackss = objects.getTrackse();
                List<items> itemses = trackss.getItemses();
                album albums = itemses.get(0).getAlbun();
                List<images> imagess = albums.getImages_album();
                String imgUrl = imagess.get(0).getUrl();


                Log.e("MylogI", "" + imgUrl);

                trackAdapter = new TrackAdapter(itemses);
                tracksRecyclerViews.setAdapter(trackAdapter);
            }

            @Override
            public void onFailure(Call<object> call, Throwable t) {
                Log.e("MylogI", "" + t.getMessage());

            }

        });
    }

    @Override
    public void onClick(View view) {
        busquedaDeArtistaUltimate = findArtist.getText().toString();


        LoadJson(busquedaDeArtistaUltimate);

    }
}


