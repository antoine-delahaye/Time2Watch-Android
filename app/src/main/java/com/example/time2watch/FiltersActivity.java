package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.time2watch.api.TrendingMoviesAPI;
import com.example.time2watch.api.TrendingTVShowsAPI;

public class FiltersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        if (MainActivity.rbMovies) {
            ((RadioButton) findViewById(R.id.movies_radio_button_day)).setChecked(true);
        }
        if (MainActivity.rbTVShows) {
            ((RadioButton) findViewById(R.id.tvshows_radio_button_day)).setChecked(true);
        }
    }

    public void onMoviesRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.movies_radio_button_week:
                if (checked) {
                    MainActivity.rbMovies = false;
                    new TrendingMoviesAPI().execute(MainActivity.WEEK);
                    break;
                }
            case R.id.movies_radio_button_day:
                if (checked) {
                    MainActivity.rbMovies = true;
                    new TrendingMoviesAPI().execute(MainActivity.DAY);
                    break;
                }
        }
    }

    public void onTVShowsRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.tvshows_radio_button_week:
                if (checked) {
                    MainActivity.rbTVShows = false;
                    new TrendingTVShowsAPI().execute(MainActivity.WEEK);
                    break;
                }
            case R.id.tvshows_radio_button_day:
                if (checked) {
                    MainActivity.rbTVShows = true;
                    new TrendingTVShowsAPI().execute(MainActivity.DAY);
                    break;
                }
        }
    }

}