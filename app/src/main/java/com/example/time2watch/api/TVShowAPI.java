package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static com.example.time2watch.utils.Utils.getJSON;

public class TVShowAPI extends AsyncTask<Integer, Void, TVShow> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow doInBackground(Integer... integers) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/tv/" + integers[0] + "?api_key=" + apiKey + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TVShow", "Not a valid tv show ID");
            return new TVShow();
        }
        Gson gson = new Gson();
        TVShow tvShow = gson.fromJson(jsonObject, TVShow.class);
        tvShow.setBackdrop_path("https://www.themoviedb.org/t/p/original" + tvShow.getBackdrop_path());
        tvShow.setPoster_path("https://www.themoviedb.org/t/p/original" + tvShow.getPoster_path());
        return tvShow;
    }

    @Override
    protected void onPostExecute(TVShow tvShows) {
        super.onPostExecute(tvShows);
        Log.d("TVShow", tvShows.toString());
    }
}
