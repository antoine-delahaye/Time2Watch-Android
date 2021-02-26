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

import static com.example.time2watch.utils.Utils.getJSON;

public class SearchMulti extends AsyncTask<String, Void, Object[]> {
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
            jsonObject = getJSON("https://api.themoviedb.org/3/search/multi?api_key=" + API_KEY + "&language=fr&query=" + strings[0] + "&page=1&include_adult=true");
        } catch (IndexOutOfBoundsException e) {
            Log.d("GetMovie", "Not a valid movie ID");
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
                if (movie.getPoster_path() != null)
                    movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
                if (movie.getBackdrop_path() != null)
                    movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
                resultList.add(movie);

            } else if (mediaType.equals("tv")) {
                TVShow tvShow = gson.fromJson(jsonObject1, TVShow.class);
                if (tvShow.getPoster_path() != null)
                    tvShow.setPoster_path("https://www.themoviedb.org/t/p/original" + tvShow.getPoster_path());
                if (tvShow.getBackdrop_path() != null)
                    tvShow.setBackdrop_path("https://www.themoviedb.org/t/p/original" + tvShow.getBackdrop_path());
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
