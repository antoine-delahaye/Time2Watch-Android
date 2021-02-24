package com.example.time2watch;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.classes.Movie;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Movie[] movies;

    public MovieAdapter(Movie[] movies) {
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
        Movie movie = this.movies[position];
        Picasso.get().load(movie.poster_path).into(holder.poster);
        holder.title.setText(movie.title);
        holder.vote_average.setText(String.valueOf(movie.vote_average));
        holder.overview.setText(movie.overview);
        holder.release_date.setText(movie.release_date);
    }

    @Override
    public int getItemCount() {
        return this.movies != null ? this.movies.length : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        protected ImageView poster;

        protected TextView title;

        protected TextView release_date;

        protected TextView overview;

        protected TextView vote_average;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.poster);
            this.title = itemView.findViewById(R.id.title);
            this.release_date = itemView.findViewById(R.id.release_date);
            this.overview = itemView.findViewById(R.id.overview);
            this.vote_average = itemView.findViewById(R.id.vote_average);
        }

    }

}
