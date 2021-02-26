package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class SearchTVShows extends AsyncTask<String, Void, TVShow[]> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow[] doInBackground(String... strings) {
        String API_KEY = BuildConfig.API_KEY;
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/search/tv?api_key=" + API_KEY + "&language=fr&page=1&query=" + strings[0] + "&include_adult=false");
        } catch (IndexOutOfBoundsException e) {
            Log.d("SearchTVShows", "Please enter a name to search...");
            return new TVShow[]{};
        }
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        TVShow[] tvShowsArray = gson.fromJson(jsonElement, TVShow[].class);

        for (TVShow tvShows : tvShowsArray)
            fixImageURL(tvShows);
        return tvShowsArray;
    }

    @Override
    protected void onPostExecute(TVShow[] tvShows) {
        super.onPostExecute(tvShows);
        Log.d("SearchTVShows", Arrays.toString(tvShows));
    }
}
