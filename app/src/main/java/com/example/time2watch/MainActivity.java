package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.time2watch.api.MovieAPI;
import com.example.time2watch.api.SearchMovies;
import com.example.time2watch.api.SearchMultiAPI;
import com.example.time2watch.api.SearchTVShows;
import com.example.time2watch.api.TVShowAPI;
import com.example.time2watch.api.TrendingMoviesAPI;
import com.example.time2watch.api.TrendingTVShowsAPI;
import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // FIX ME
        //   Currently when adding path to backdrop_path and poster_path, we do not check if it's null
        AsyncTask<String, Void, Movie[]> trendingMoviesDay = new TrendingMoviesAPI().execute(TrendingMoviesAPI.DAY);
        AsyncTask<String, Void, Movie[]> trendingMoviesWeek = new TrendingMoviesAPI().execute(TrendingMoviesAPI.WEEK);
        AsyncTask<String, Void, TVShow[]> trendingTVShowsDay = new TrendingTVShowsAPI().execute(TrendingTVShowsAPI.DAY);
        AsyncTask<String, Void, TVShow[]> trendingTVShowsWeek = new TrendingTVShowsAPI().execute(TrendingTVShowsAPI.WEEK);
        AsyncTask<Integer, Void, Movie> movie581389 = new MovieAPI().execute(581389);
        AsyncTask<Integer, Void, TVShow> tvShows85271 = new TVShowAPI().execute(85271);
        AsyncTask<String, Void, Object[]> searchMulti = new SearchMultiAPI().execute("Interstellar");
        AsyncTask<String, Void, Movie[]> searchMovie = new SearchMovies().execute("Interstellar");
        AsyncTask<String, Void, TVShow[]> searchTVShow = new SearchTVShows().execute("Breaking Bad");
    }
}