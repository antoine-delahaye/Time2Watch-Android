package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static com.example.time2watch.utils.Utils.getJSON;


public class MovieAPI extends AsyncTask<Integer, Void, Movie> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie doInBackground(Integer... integers) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/movie/" + integers[0] + "?api_key=" + apiKey + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("GetMovie", "Not a valid movie ID");
            return new Movie();
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, Movie.class);
    }

    @Override
    protected void onPostExecute(Movie movie) {
        super.onPostExecute(movie);
        Log.d("GetMovie", movie.toString());
    }
}
