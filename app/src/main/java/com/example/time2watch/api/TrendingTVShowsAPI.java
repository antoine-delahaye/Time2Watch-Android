package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.classes.TrendingTVShow;
import com.example.time2watch.ui.movies.MovieAdapter;
import com.example.time2watch.ui.tvshows.TVShowAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingTVShowsAPI extends AsyncTask<String, Void, TrendingTVShow[]> {

    public final static String WEEK = "week";

    public final static String DAY = "day";

    private final RecyclerView recyclerView;

    public TrendingTVShowsAPI(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TrendingTVShow[] doInBackground(String... strings) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/trending/tv/" + strings[0] + "?api_key=" + apiKey + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TrendingMovies", "Please choose between WEEK or DAY in execute()");
            return new TrendingTVShow[]{};
        }
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        TrendingTVShow[] tvShowArray = gson.fromJson(jsonElement, TrendingTVShow[].class);

        for (TrendingTVShow tvShow : tvShowArray) {
            tvShow.setBackdrop_path("https://www.themoviedb.org/t/p/original" + tvShow.getBackdrop_path());
            tvShow.setPoster_path("https://www.themoviedb.org/t/p/original" + tvShow.getPoster_path());
        }
        return tvShowArray;
    }

    @Override
    protected void onPostExecute(TrendingTVShow[] tvShows) {
        super.onPostExecute(tvShows);
        this.recyclerView.setAdapter(new TVShowAdapter(tvShows));
    }
}
