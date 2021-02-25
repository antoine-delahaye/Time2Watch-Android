package com.example.time2watch;

import android.content.Context;
import android.content.Intent;
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

    private Context context;

    public MovieAdapter(Movie[] movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(this.context).inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = this.movies[position];
        Picasso.get().load(movie.poster_path).into(holder.poster);
        holder.title.setText(movie.title);
        holder.release_date.setText(this.context.getString(R.string.release_date, movie.release_date));
        holder.vote_average.setText(this.context.getString(R.string.vote_average, String.valueOf(movie.vote_average)));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("poster_path", movie.poster_path);
            intent.putExtra("title", movie.title);
            intent.putExtra("release_date", movie.release_date);
            intent.putExtra("vote_average", movie.vote_average);
            intent.putExtra("overview", movie.overview);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.movies != null ? this.movies.length : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        protected ImageView poster;

        protected TextView title;

        protected TextView release_date;

        protected TextView vote_average;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.RowPoster);
            this.title = itemView.findViewById(R.id.RowTitle);
            this.release_date = itemView.findViewById(R.id.RowReleaseDate);
            this.vote_average = itemView.findViewById(R.id.RowVoteAverage);
        }

    }

}
