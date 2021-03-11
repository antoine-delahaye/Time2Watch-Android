package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.time2watch.R;
import com.example.time2watch.classes.Movie;
import com.example.time2watch.ui.movies.MovieDetailActivity;
import com.example.time2watch.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;


public class MovieAPI extends AsyncTask<Integer, Void, Movie> {

    private final MovieDetailActivity movieDetailActivity;

    public MovieAPI(MovieDetailActivity movieDetailActivity) {
        this.movieDetailActivity = movieDetailActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie doInBackground(Integer... integers) {
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/movie/" + integers[0] + "?api_key=" + BuildConfig.API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("Movie", "Not a valid movie ID");
            return new Movie();
        }
        Movie movie = new Gson().fromJson(jsonObject, Movie.class);
        fixImageURL(movie);
        return movie;
    }

    @Override
    protected void onPostExecute(Movie movie) {
        super.onPostExecute(movie);
        Picasso.get().load(movie.getPoster_path()).into((ImageView) this.movieDetailActivity.findViewById(R.id.movie_detail_poster));
        TextView textView = this.movieDetailActivity.findViewById(R.id.movie_detail_title);
        textView.setText(movie.getTitle());
        textView = this.movieDetailActivity.findViewById(R.id.movie_detail_release_date);
        textView.setText(this.movieDetailActivity.getString(R.string.release_date, movie.getRelease_date()));
        textView = this.movieDetailActivity.findViewById(R.id.movie_detail_vote_average);
        textView.setText(this.movieDetailActivity.getString(R.string.vote_average, movie.getVote_average()));
        textView = this.movieDetailActivity.findViewById(R.id.movie_detail_overview);
        textView.setText(this.movieDetailActivity.getString(R.string.overview, movie.getOverview()));
        Log.d("MovieAPI", movie.toString());
    }
}
