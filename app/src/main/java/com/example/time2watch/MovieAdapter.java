package com.example.time2watch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final ArrayList<HashMap<String, String>> movies;


    public MovieAdapter(ArrayList<HashMap<String, String>> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + this.movies.get(position).get("poster_path")).into(holder.poster);
        holder.title.setText(this.movies.get(position).get("title"));
    }

    @Override
    public int getItemCount() {
        if (this.movies != null) {
            return movies.size();
        } else {
            return 0;
        }
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;

        protected ImageView poster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.poster = itemView.findViewById(R.id.poster);
        }

    }

}
