package com.example.time2watch.ui.tvshows;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.time2watch.R;
import com.example.time2watch.api.TVShowAPI;
import com.squareup.picasso.Picasso;

public class TVShowDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);
        new TVShowAPI(this).execute(getIntent().getExtras().getInt("id"));
    }

}
