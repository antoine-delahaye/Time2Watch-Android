package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.time2watch.classes.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public String apiKey = "ccbc42c4b357545c785bb0d1caba6301";

    public static JsonObject getJSON(String urlPage) {
        JsonObject jsonObject = null;
        try {
            URL url = new URL(urlPage);
            Scanner sc = new Scanner(url.openStream());
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }
            Gson gson = new Gson();
            jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
        AsyncTask jsonObject = new getTrendingMoviesWeek().execute();
    }

    private class getTrendingMoviesWeek extends AsyncTask<Void, Void, Movie[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Movie[] doInBackground(Void... voids) {
            JsonObject jsonObject = getJSON("https://api.themoviedb.org/3/trending/movie/week?api_key=" + apiKey + "&language=fr");
            Gson gson = new Gson();
            JsonElement jsonElement = jsonObject.get("results");
            Movie[] moviesArray = gson.fromJson(jsonElement, Movie[].class);
            for (Movie movie : moviesArray) {
                movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
                movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
            }
            return moviesArray;
        }

        @Override
        protected void onPostExecute(Movie[] movies) {
            super.onPostExecute(movies);
            Log.d("getTrendingMoviesWeek", Arrays.toString(movies));
            Log.d("getTrendingMoviesWeek", String.valueOf(movies.length) + " Movies");
        }
    }
}