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

public class SearchMoviesAPI extends AsyncTask<String, Void, Movie[]> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(String... strings) {
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/search/movie?api_key=" + BuildConfig.API_KEY + "&language=fr&page=1&query=" + strings[0] + "&include_adult=false");
        } catch (IndexOutOfBoundsException e) {
            Log.d("SearchMovies", "Please enter a name to search...");
            return new Movie[]{};
        }

        Movie[] moviesArray = new Gson().fromJson(jsonObject.get("results"), Movie[].class);

        for (Movie movie : moviesArray)
            fixImageURL(movie);

        return moviesArray;
    }

    @Override
    protected void onPostExecute(Movie[] movie) {
        super.onPostExecute(movie);
        Log.d("SearchMovies", Arrays.toString(movie));
    }
}
