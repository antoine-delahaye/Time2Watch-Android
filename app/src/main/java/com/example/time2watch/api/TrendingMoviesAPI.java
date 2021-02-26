package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.TrendingMovie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingMoviesAPI extends AsyncTask<String, Void, TrendingMovie[]> {
    public final static String WEEK = "week";
    public final static String DAY  = "day";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TrendingMovie[] doInBackground(String... strings) {
        String API_KEY = BuildConfig.API_KEY;
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/trending/movie/" + strings[0] + "?api_key=" + API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TrendingMovies", "Please choose between WEEK or DAY in execute()");
            return new TrendingMovie[]{};
        }
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        TrendingMovie[] moviesArray = gson.fromJson(jsonElement, TrendingMovie[].class);

        for (TrendingMovie movie : moviesArray) {
            movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
            movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
        }
        return moviesArray;
    }

    @Override
    protected void onPostExecute(TrendingMovie[] movies) {
        super.onPostExecute(movies);
        Log.d("TrendingMovies", Arrays.toString(movies));
        Log.d("TrendingMovies", movies.length + " Movies");
    }
}
