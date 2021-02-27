package com.example.time2watch.ui.movies;

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
import com.example.time2watch.classes.TrendingMovie;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final TrendingMovie[] movies;

    private Context context;

    public MovieAdapter(TrendingMovie[] movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MovieViewHolder(LayoutInflater.from(this.context).inflate(R.layout.movie_row, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        TrendingMovie movie = this.movies[position];
        Picasso.get().load(movie.getPoster_path()).into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.release_date.setText(this.context.getString(R.string.release_date, movie.getRelease_date()));
        holder.vote_average.setText(this.context.getString(R.string.vote_average, movie.getVote_average()));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("poster_path", movie.getPoster_path());
            intent.putExtra("title", movie.getTitle());
            intent.putExtra("release_date", movie.getRelease_date());
            intent.putExtra("vote_average", movie.getVote_average());
            intent.putExtra("overview", movie.getOverview());
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
            this.poster = itemView.findViewById(R.id.movie_row_poster);
            this.title = itemView.findViewById(R.id.movie_row_title);
            this.release_date = itemView.findViewById(R.id.movie_row_release_date);
            this.vote_average = itemView.findViewById(R.id.movie_row_vote_average);
        }

    }

}
