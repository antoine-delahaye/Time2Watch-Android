package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;


public class MovieAPI extends AsyncTask<Integer, Void, Movie> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie doInBackground(Integer... integers) {
        String API_KEY = BuildConfig.API_KEY;
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/movie/" + integers[0] + "?api_key=" + API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("Movie", "Not a valid movie ID");
            return new Movie();
        }
        Gson gson = new Gson();
        Movie movie = gson.fromJson(jsonObject, Movie.class);
        fixImageURL(movie);
        return movie;
    }

    @Override
    protected void onPostExecute(Movie movie) {
        super.onPostExecute(movie);
        Log.d("Movie", movie.toString());
    }
}
