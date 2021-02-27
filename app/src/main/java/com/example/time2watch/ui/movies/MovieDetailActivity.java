package com.example.time2watch.ui.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.time2watch.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Bundle extras = getIntent().getExtras();
        Picasso.get().load(extras.getString("poster_path")).into((ImageView) findViewById(R.id.movie_detail_poster));
        TextView textView = findViewById(R.id.movie_detail_title);
        textView.setText(extras.getString("title"));
        textView = findViewById(R.id.movie_detail_release_date);
        textView.setText(getString(R.string.release_date, extras.getString("release_date")));
        textView = findViewById(R.id.movie_detail_vote_average);
        textView.setText(getString(R.string.vote_average, extras.getString("vote_average")));
        textView = findViewById(R.id.movie_detail_overview);
        textView.setText(getString(R.string.overview, extras.getString("overview")));
    }

}