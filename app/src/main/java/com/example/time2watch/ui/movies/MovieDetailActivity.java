package com.example.time2watch.ui.movies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.time2watch.R;
import com.example.time2watch.api.MovieAPI;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        new MovieAPI(this).execute(getIntent().getExtras().getInt("id"));
    }

}