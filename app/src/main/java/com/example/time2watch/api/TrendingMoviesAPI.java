package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingMoviesAPI extends AsyncTask<String, Void, Movie[]> {
    public final static String WEEK = "week";
    public final static String DAY  = "day";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(String... strings) {
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/trending/movie/" + strings[0] + "?api_key=" + BuildConfig.API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TrendingMovies", "Please choose between WEEK or DAY in execute()");
            return new Movie[]{};
        }

        Movie[] moviesArray = new Gson().fromJson(jsonObject.get("results"), Movie[].class);

        for (Movie movie : moviesArray)
            fixImageURL(movie);
        return moviesArray;
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        super.onPostExecute(movies);
        Log.d("TrendingMovies", Arrays.toString(movies));
    }
}
