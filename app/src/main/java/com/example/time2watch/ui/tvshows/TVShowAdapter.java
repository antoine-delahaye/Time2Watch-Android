package com.example.time2watch.ui.tvshows;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.R;
import com.example.time2watch.classes.TVShow;
import com.squareup.picasso.Picasso;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {

    private final TVShow[] tvShows;

    private Context context;

    public TVShowAdapter(TVShow[] tvShows) {
        this.tvShows = tvShows;
    }


    @NonNull
    @Override
    public TVShowAdapter.TVShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new TVShowAdapter.TVShowViewHolder(LayoutInflater.from(this.context).inflate(R.layout.tvshow_row, parent, false));
    }

    @Override
    public void onBindViewHolder(TVShowAdapter.TVShowViewHolder holder, int position) {
        TVShow tvShow = this.tvShows[position];
        Picasso.get().load(tvShow.getPoster_path()).into(holder.poster);
        holder.name.setText(tvShow.getName());
        holder.air_date.setText(this.context.getString(R.string.release_date, tvShow.getFirst_air_date()));
        holder.vote_average.setText(this.context.getString(R.string.vote_average, tvShow.getVote_average()));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, TVShowDetailActivity.class);
            intent.putExtra("id", Integer.valueOf(tvShow.getId()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.tvShows != null ? this.tvShows.length : 0;
    }

    public static class TVShowViewHolder extends RecyclerView.ViewHolder {

        protected ImageView poster;

        protected TextView name;

        protected TextView air_date;

        protected TextView vote_average;

        public TVShowViewHolder(View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.tvshow_row_poster);
            this.name = itemView.findViewById(R.id.tvshow_row_name);
            this.air_date = itemView.findViewById(R.id.tvshow_row_air_date);
            this.vote_average = itemView.findViewById(R.id.tvshow_row_vote_average);
        }

    }
}
