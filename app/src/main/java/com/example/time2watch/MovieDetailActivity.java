package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Bundle extras = getIntent().getExtras();
        Picasso.get().load(extras.getString("poster_path")).into((ImageView) findViewById(R.id.DetailPoster));
        TextView textView = findViewById(R.id.DetailTitle);
        textView.setText(extras.getString("title"));
        textView = findViewById(R.id.DetailReleaseDate);
        textView.setText(getString(R.string.release_date, extras.getString("release_date")));
        textView = findViewById(R.id.DetailVoteAverage);
        textView.setText(getString(R.string.vote_average, String.valueOf(extras.getDouble("vote_average"))));
        textView = findViewById(R.id.DetailOverview);
        textView.setText(getString(R.string.overview, extras.getString("overview")));
    }
}