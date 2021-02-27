package com.example.time2watch.ui.tvshows;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.time2watch.R;
import com.squareup.picasso.Picasso;

public class TVShowDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);
        Bundle extras = getIntent().getExtras();
        Picasso.get().load(extras.getString("poster_path")).into((ImageView) findViewById(R.id.tvshow_detail_poster));
        TextView textView = findViewById(R.id.tvshow_detail_name);
        textView.setText(extras.getString("name"));
        textView = findViewById(R.id.tvshow_detail_air_date);
        textView.setText(getString(R.string.release_date, extras.getString("air_date")));
        textView = findViewById(R.id.tvshow_detail_vote_average);
        textView.setText(getString(R.string.vote_average, extras.getString("vote_average")));
        textView = findViewById(R.id.tvshow_detail_overview);
        textView.setText(getString(R.string.overview, extras.getString("overview")));
    }

}
