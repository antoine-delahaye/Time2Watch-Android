package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class TopRatedTVShows extends AsyncTask<Void, Void, TVShow[]> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow[] doInBackground(Void... voids) {
        JsonObject jsonObject = getJSON("https://api.themoviedb.org/3/tv/top_rated?api_key=" + BuildConfig.API_KEY + "&language=fr&page=1");
        TVShow[] tvShowsArray = new Gson().fromJson(jsonObject.get("results"), TVShow[].class);

        for (TVShow tvShows : tvShowsArray)
            fixImageURL(tvShows);
        return tvShowsArray;
    }

    @Override
    protected void onPostExecute(TVShow[] tvShows) {
        super.onPostExecute(tvShows);
        Log.d("TopRatedTVShows", Arrays.toString(tvShows));
    }
}
