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

public class DiscoverTVShowsAPI extends AsyncTask<String, Void, TVShow[]> {
    public static final String POPULARITY_ASC = "popularity.asc";
    public static final String POPULARITY_DESC = "popularity.desc";
    public static final String FIRST_AIR_DATE_ASC = "first_air_date.asc";
    public static final String FIRST_AIR_DATE_DESC= "first_air_date.desc";
    public static final String VOTE_AVERAGE_ASC = "vote_average.asc";
    public static final String VOTE_AVERAGE_DESC = "vote_average.desc";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow[] doInBackground(String... strings) {

        String choice;
        if (strings[0] != null)
            choice = strings[0];
        else
            choice = POPULARITY_DESC;

        JsonObject jsonObject = null;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/discover/tv?api_key=" +
                    BuildConfig.API_KEY +
                    "&language=fr&sort_by=" + choice + "&include_adult=false&include_video=false&page=1");
        } catch (IndexOutOfBoundsException e) {
            Log.d("DiscoverTVShowsAPI", "Please choose only one filter...");
        }

        TVShow[] tvShowsArray = new Gson().fromJson(jsonObject.get("results"), TVShow[].class);

        for (TVShow tvShows : tvShowsArray)
            fixImageURL(tvShows);
        return tvShowsArray;
    }

    @Override
    protected void onPostExecute(TVShow[] tvShows) {
        super.onPostExecute(tvShows);
        Log.d("DiscoverTVShowsAPI", Arrays.toString(tvShows));
    }
}
