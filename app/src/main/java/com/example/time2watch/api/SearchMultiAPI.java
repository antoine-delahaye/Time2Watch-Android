package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class SearchMultiAPI extends AsyncTask<String, Void, Object[]> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    //         arr = arrlist.toArray(arr);
    @Override
    protected Object[] doInBackground(String... strings) {
        String API_KEY = BuildConfig.API_KEY;
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/search/multi?api_key=" + API_KEY + "&language=fr&query=" + strings[0] + "&page=1&include_adult=false");
        } catch (IndexOutOfBoundsException e) {
            Log.d("SearchMulti", "Please enter a name to search...");
            return new Object[]{};
        }
        Gson gson = new Gson();
        JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();
        List<Object> resultList = new ArrayList<>();

        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject1 = jsonElement.getAsJsonObject();
            String mediaType = jsonObject1.get("media_type").getAsString();

            if (mediaType.equals("movie")) {
                Movie movie = gson.fromJson(jsonObject1, Movie.class);
                fixImageURL(movie);
                resultList.add(movie);

            } else if (mediaType.equals("tv")) {
                TVShow tvShow = gson.fromJson(jsonObject1, TVShow.class);
                fixImageURL(tvShow);
                resultList.add(tvShow);
            }
        }
        return resultList.toArray();
    }

    @Override
    protected void onPostExecute(Object[] result) {
        super.onPostExecute(result);
        Log.d("SearchMulti", Arrays.toString(result));
    }
}
