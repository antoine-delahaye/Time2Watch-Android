package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.time2watch.api.GetTrendingMoviesDay;
import com.example.time2watch.api.GetTrendingMoviesWeek;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
        AsyncTask trendingMoviesWeek = new GetTrendingMoviesWeek().execute();
        AsyncTask trendingMoviesDay = new GetTrendingMoviesDay().execute();
    }
}