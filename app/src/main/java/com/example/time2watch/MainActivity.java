package com.example.time2watch;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.example.time2watch.api.DiscoverMoviesAPI;
import com.example.time2watch.api.PopularMoviesAPI;
import com.example.time2watch.api.PopularTVShowsAPI;
import com.example.time2watch.api.TopRatedMoviesAPI;
import com.example.time2watch.api.TopRatedTVShowsAPI;
import com.example.time2watch.api.UpcomingMoviesAPI;
import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    public static RecyclerView moviesRecyclerView;

    public static RecyclerView tvShowsRecyclerView;

    public final static String WEEK = "week";

    public final static String DAY = "day";

    public static boolean rbMovies = false;

    public static boolean rbTVShows = false;

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
//        AsyncTask<String, Void, Movie[]> trendingMoviesDay = new TrendingMoviesAPI().execute(TrendingMoviesAPI.DAY);
//        AsyncTask<String, Void, Movie[]> trendingMoviesWeek = new TrendingMoviesAPI().execute(TrendingMoviesAPI.WEEK);
//        AsyncTask<String, Void, TVShow[]> trendingTVShowsDay = new TrendingTVShowsAPI().execute(TrendingTVShowsAPI.DAY);
//        AsyncTask<String, Void, TVShow[]> trendingTVShowsWeek = new TrendingTVShowsAPI().execute(TrendingTVShowsAPI.WEEK);
//        AsyncTask<Integer, Void, Movie> movie581389 = new MovieAPI().execute(581389);
//        AsyncTask<Integer, Void, TVShow> tvShows85271 = new TVShowAPI().execute(85271);
//        AsyncTask<String, Void, Object[]> searchMulti = new SearchMultiAPI().execute("Interstellar");
//        AsyncTask<String, Void, Movie[]> searchMovie = new SearchMoviesAPI().execute("Interstellar");
//        AsyncTask<String, Void, TVShow[]> searchTVShow = new SearchTVShowsAPI().execute("Breaking Bad");
//        AsyncTask<Void, Void, TVShow[]> popularTVShows = new PopularTVShowsAPI().execute();
//        AsyncTask<Void, Void, TVShow[]> topRatedTVShows = new TopRatedTVShowsAPI().execute();
//        AsyncTask<Void, Void, Movie[]> popularMovie = new PopularMoviesAPI().execute();
//        AsyncTask<Void, Void, Movie[]> topRatedMovies = new TopRatedMoviesAPI().execute();
//        AsyncTask<Void, Void, Movie[]> upcomingMovies = new UpcomingMoviesAPI().execute();
//        AsyncTask<String, Void, Movie[]> discoverMovies = new DiscoverMoviesAPI().execute(DiscoverMoviesAPI.POPULARITY_DESC);
    }

    public void filtersActivity(MenuItem item) {
        startActivity(new Intent(this, FiltersActivity.class));
    }

}