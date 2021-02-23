package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.getJSON;

public class GetTrendingMovies extends AsyncTask<String, Void, Movie[]> {
    public final static String WEEK = "week";
    public final static String DAY  = "day";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(String... strings) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project

        JsonObject jsonObject = getJSON("https://api.themoviedb.org/3/trending/movie/" + strings[0] + "?api_key=" + apiKey + "&language=fr");
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        Movie[] moviesArray = gson.fromJson(jsonElement, Movie[].class);

        for (Movie movie : moviesArray) {
            movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
            movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
        }
        return moviesArray;
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        super.onPostExecute(movies);
        Log.d("getTrendingMovies", Arrays.toString(movies));
        Log.d("getTrendingMovies", movies.length + " Movies");
    }
}
