package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class TopRatedMoviesAPI extends AsyncTask<Void, Void, Movie[]> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(Void... voids) {
        JsonObject jsonObject = getJSON("https://api.themoviedb.org/3/movie/top_rated?api_key=" + BuildConfig.API_KEY + "&language=fr&page=1");
        Movie[] movieArray = new Gson().fromJson(jsonObject.get("results"), Movie[].class);

        for (Movie movie : movieArray)
            fixImageURL(movie);
        return movieArray;
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        super.onPostExecute(movies);
        Log.d("TopRatedMovies", Arrays.toString(movies));
    }
}
