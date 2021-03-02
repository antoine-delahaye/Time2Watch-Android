package com.example.time2watch;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.example.time2watch.api.TrendingMoviesAPI;
import com.example.time2watch.api.TrendingTVShowsAPI;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    public static RecyclerView moviesRecyclerView;

    public static RecyclerView tvShowsRecyclerView;

    public final static String WEEK = "week";

    public final static String DAY = "day";

    private boolean rbMovies = false;

    private boolean rbTVShows = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        this.appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_movies, R.id.nav_tvshows, R.id.nav_about).setDrawerLayout(findViewById(R.id.drawer_layout)).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, this.appBarConfiguration);
        NavigationUI.setupWithNavController((NavigationView) findViewById(R.id.nav_view), navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), this.appBarConfiguration) || super.onSupportNavigateUp();
    }

    public void onMoviesRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.movies_radio_button_week:
                if (checked) {
                    this.rbMovies = false;
                    new TrendingMoviesAPI().execute(WEEK);
                    break;
                }
            case R.id.movies_radio_button_day:
                if (checked) {
                    this.rbMovies = true;
                    new TrendingMoviesAPI().execute(DAY);
                    break;
                }
        }
    }

    public void onTVShowsRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.tvshows_radio_button_week:
                if (checked) {
                    this.rbTVShows = false;
                    new TrendingTVShowsAPI().execute(WEEK);
                    break;
                }
            case R.id.tvshows_radio_button_day:
                if (checked) {
                    this.rbTVShows = true;
                    new TrendingTVShowsAPI().execute(DAY);
                    break;
                }
        }
    }
}