package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.time2watch.api.GetTrendingMovies;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
        AsyncTask trendingMoviesDay = new GetTrendingMovies().execute(GetTrendingMovies.DAY);
        AsyncTask trendingMoviesWeek = new GetTrendingMovies().execute(GetTrendingMovies.WEEK);
    }
}