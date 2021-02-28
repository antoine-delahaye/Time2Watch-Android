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

public class DiscoverMovieAPI extends AsyncTask<String, Void, Movie[]> {
    public static final String POPULARITY_ASC = "popularity.asc";
    public static final String POPULARITY_DESC = "popularity.desc";
    public static final String RELEASE_DATE_ASC = "release_date.asc";
    public static final String RELEASE_DATE_DESC = "release_date.desc";
    public static final String REVENUE_ASC = "revenue.asc";
    public static final String REVENUE_DESC = "revenue.desc";
    public static final String PRIMARY_RELEASE_DATE_ASC = "primary_release_date.asc";
    public static final String PRIMARY_RELEASE_DATE_DESC = "primary_release_date.desc";
    public static final String ORIGINAL_TITLE_ASC = "original_title.asc";
    public static final String ORIGINAL_TITLE_DESC = "original_title.desc";
    public static final String VOTE_AVERAGE_ASC = "vote_average.asc";
    public static final String VOTE_AVERAGE_DESC = "vote_average.desc";
    public static final String VOTE_COUNT_ASC = "vote_count.asc";
    public static final String VOTE_COUNT_DESC = "vote_count.desc";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(String... strings) {

        String choice;
        if (strings[0] != null)
            choice = strings[0];
        else
            choice = POPULARITY_DESC;

        JsonObject jsonObject = null;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/discover/movie?api_key=" +
                    BuildConfig.API_KEY +
                    "&language=fr&sort_by=" + choice + "&include_adult=false&include_video=false&page=1");
        } catch (IndexOutOfBoundsException e) {
            Log.d("DiscoverMovieAPI", "Please provide a filter...");
        }

        Movie[] movieArray = new Gson().fromJson(jsonObject.get("results"), Movie[].class);

        for (Movie movie : movieArray)
            fixImageURL(movie);
        return movieArray;
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        super.onPostExecute(movies);
        Log.d("DiscoverMovieAPI", Arrays.toString(movies));
    }
}
