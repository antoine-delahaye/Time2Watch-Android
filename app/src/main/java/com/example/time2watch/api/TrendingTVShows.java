package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingTVShows extends AsyncTask<String, Void, TVShow[]> {
    public final static String WEEK = "week";
    public final static String DAY  = "day";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow[] doInBackground(String... strings) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project

        JsonObject jsonObject = getJSON("https://api.themoviedb.org/3/trending/tv/" + strings[0] + "?api_key=" + apiKey + "&language=fr");
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        TVShow[] tvShowArray = gson.fromJson(jsonElement, TVShow[].class);

        for (TVShow tvShow : tvShowArray) {
            tvShow.setBackdrop_path("https://www.themoviedb.org/t/p/original" + tvShow.getBackdrop_path());
            tvShow.setPoster_path("https://www.themoviedb.org/t/p/original" + tvShow.getPoster_path());
        }
        return tvShowArray;
    }

    @Override
    protected void onPostExecute(TVShow[] tvShow) {
        super.onPostExecute(tvShow);
        Log.d("TrendingTVShows", Arrays.toString(tvShow));
        Log.d("TrendingTVShows", tvShow.length + " TVShows");
    }
}
