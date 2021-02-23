package com.example.time2watch;

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
        holder.vote_average.setText(this.movies.get(position).get("vote_average"));
        holder.overview.setText(this.movies.get(position).get("overview"));
        holder.release_date.setText(this.movies.get(position).get("release_date"));
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

        protected TextView vote_average;

        protected TextView overview;

        protected TextView release_date;

        protected ImageView poster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.vote_average = itemView.findViewById(R.id.vote_average);
            this.overview = itemView.findViewById(R.id.overview);
            this.release_date = itemView.findViewById(R.id.release_date);
            this.poster = itemView.findViewById(R.id.poster);
        }

    }

}
