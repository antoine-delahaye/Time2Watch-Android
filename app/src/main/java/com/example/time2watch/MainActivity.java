package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.time2watch.api.TrendingMovies;
import com.example.time2watch.api.TrendingTVShows;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
        AsyncTask trendingMoviesDay = new TrendingMovies().execute(TrendingMovies.DAY);
        AsyncTask trendingMoviesWeek = new TrendingMovies().execute(TrendingMovies.WEEK);
        AsyncTask trendingTVShowsDay = new TrendingTVShows().execute(TrendingTVShows.DAY);
        AsyncTask trendingTVShowsWeek = new TrendingTVShows().execute(TrendingTVShows.WEEK);
    }
}