package com.example.time2watch.ui.search;

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
import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;
import com.example.time2watch.ui.movies.MovieDetailActivity;
import com.example.time2watch.ui.tvshows.TVShowDetailActivity;
import com.squareup.picasso.Picasso;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private final Object[] result;

    private Context context;

    public SearchAdapter(Object[] result) {
        this.result = result;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new SearchAdapter.SearchViewHolder(LayoutInflater.from(this.context).inflate(R.layout.search_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        if (this.result[position] instanceof Movie) {
            Movie movie = (Movie) this.result[position];
            Picasso.get().load(movie.getPoster_path()).into(holder.poster);
            holder.title.setText(movie.getTitle());
            holder.release_date.setText(this.context.getString(R.string.release_date, movie.getRelease_date()));
            holder.media_type.setText(R.string.menu_movies);
            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("id", Integer.valueOf(movie.getId()));
                context.startActivity(intent);
            });
        } else {
            TVShow tvShow = (TVShow) this.result[position];
            Picasso.get().load(tvShow.getPoster_path()).into(holder.poster);
            holder.title.setText(tvShow.getName());
            holder.release_date.setText(this.context.getString(R.string.release_date, tvShow.getFirst_air_date()));
            holder.media_type.setText(R.string.menu_tvshows);
            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, TVShowDetailActivity.class);
                intent.putExtra("id", Integer.valueOf(tvShow.getId()));
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.result != null ? this.result.length : 0;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        protected ImageView poster;

        protected TextView title;

        protected TextView release_date;

        protected TextView media_type;

        public SearchViewHolder(View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.search_row_poster);
            this.title = itemView.findViewById(R.id.search_row_title);
            this.release_date = itemView.findViewById(R.id.search_row_release_date);
            this.media_type = itemView.findViewById(R.id.search_row_media_type);
        }

    }

}
