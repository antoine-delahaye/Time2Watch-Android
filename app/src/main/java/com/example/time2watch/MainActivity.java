package com.example.time2watch;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    public static RecyclerView moviesRecyclerView;

    public static RecyclerView tvShowsRecyclerView;

    public static RecyclerView searchRecyclerView;

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
    }

    public void filtersActivity(MenuItem item) {
        startActivity(new Intent(this, FiltersActivity.class));
    }

}