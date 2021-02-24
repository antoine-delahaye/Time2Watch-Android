package com.example.time2watch;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.time2watch.api.TrendingMovies;
import com.example.time2watch.api.TrendingTVShows;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<HashMap<String, String>> movies = new ArrayList<>();

    public String loadJsonFromAsset() {
        String data = null;
        try {
            InputStream file = this.getAssets().open("tmdb_movies_sample.json");
            byte[] buffer = new byte[file.available()];
            file.read(buffer);
            file.close();
            data = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            Log.d("loadJsonFromAsset", String.valueOf(exception));
        }
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONArray jsonArray = new JSONObject(loadJsonFromAsset()).getJSONArray("data");
            HashMap<String, String> movie;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String release_date = jsonObject.getString("release_date");
                String overview = jsonObject.getString("overview");
                String vote_average = jsonObject.getString("vote_average");
                String posterPath = jsonObject.getString("poster_path");
                movie = new HashMap<>();
                movie.put("title", title);
                movie.put("release_date", release_date);
                movie.put("overview", overview);
                movie.put("vote_average", vote_average);
                movie.put("poster_path", posterPath);
                this.movies.add(movie);
            }
        } catch (JSONException exception) {
            Log.d("onCreate", String.valueOf(exception));
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MovieAdapter adapter = new MovieAdapter(this.movies);
        recyclerView.setAdapter(adapter);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
        AsyncTask trendingMoviesDay = new TrendingMovies().execute(TrendingMovies.DAY);
        AsyncTask trendingMoviesWeek = new TrendingMovies().execute(TrendingMovies.WEEK);
        AsyncTask trendingTVShowsDay = new TrendingTVShows().execute(TrendingTVShows.DAY);
        AsyncTask trendingTVShowsWeek = new TrendingTVShows().execute(TrendingTVShows.WEEK);
    }

}