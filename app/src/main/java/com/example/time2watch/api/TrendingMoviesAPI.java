package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.MovieAdapter;
import com.example.time2watch.classes.TrendingMovie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static com.example.time2watch.utils.Utils.getJSON;

public class TrendingMoviesAPI extends AsyncTask<String, Void, TrendingMovie[]> {

    public final static String WEEK = "week";

    public final static String DAY = "day";

    private final RecyclerView recyclerView;

    public TrendingMoviesAPI(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TrendingMovie[] doInBackground(String... strings) {
        String apiKey = "ccbc42c4b357545c785bb0d1caba6301"; // TODO Transfer this into string global to project
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/trending/movie/" + strings[0] + "?api_key=" + apiKey + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TrendingMovies", "Please choose between WEEK or DAY in execute()");
            return new TrendingMovie[]{};
        }
        Gson gson = new Gson();
        JsonElement jsonElement = jsonObject.get("results");
        TrendingMovie[] moviesArray = gson.fromJson(jsonElement, TrendingMovie[].class);

        for (TrendingMovie movie : moviesArray) {
            movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
            movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
        }
        return moviesArray;
    }

    @Override
    protected void onPostExecute(TrendingMovie[] movies) {
        super.onPostExecute(movies);
        this.recyclerView.setAdapter(new MovieAdapter(movies));
    }

}
