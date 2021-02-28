package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingTVShowsAPI extends AsyncTask<String, Void, TVShow[]> {
    public final static String WEEK = "week";
    public final static String DAY = "day";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow[] doInBackground(String... strings) {
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/trending/tv/" + strings[0] + "?api_key=" + BuildConfig.API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TrendingTVShows", "Please choose between WEEK or DAY in execute()");
            return new TVShow[]{};
        }

        TVShow[] tvShowArray = new Gson().fromJson(jsonObject.get("results"), TVShow[].class);

        for (TVShow tvShow : tvShowArray)
            fixImageURL(tvShow);

        return tvShowArray;
    }

    @Override
    protected void onPostExecute(TVShow[] tvShow) {
        super.onPostExecute(tvShow);
        Log.d("TrendingTVShows", Arrays.toString(tvShow));
    }
}
