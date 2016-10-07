package com.lendmybook.dagorik.spotifyplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lendmybook.dagorik.spotifyplayer.models.items;
import com.lendmybook.dagorik.spotifyplayer.models.tracks;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dagorik on 04/10/2016.
 */

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private List<items> tracksList;
    private Context context;

    public TrackAdapter(List<items> tracksList) {
        this.tracksList = tracksList;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_track, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {

        items items = tracksList.get(position);
        holder.bindTrack(items);

    }

    @Override
    public int getItemCount() {
        return tracksList.size();
    }


    public class TrackViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTrack, itemPlay;
        private TextView tvTrackName;

        public TrackViewHolder(View itemView) {
            super(itemView);

            imgTrack = (ImageView) itemView.findViewById(R.id.Image_Track);
            tvTrackName = (TextView) itemView.findViewById(R.id.Name_Track);
            itemPlay = (ImageView) itemView.findViewById(R.id.item_play);

        }

        public void bindTrack(items items) {
           String superUrl=items.getAlbun().getImages_album().get(0).getUrl();
//            tvTrackName.setText(items.getAlbun().getImages_album().get(0).getUrl());
                Picasso.with(context).load(superUrl).into(imgTrack);
        }

    }
}

