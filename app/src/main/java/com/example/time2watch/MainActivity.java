package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import com.example.time2watch.api.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
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
            return gson.fromJson(jsonElement, Movie[].class);
        }

        @Override
        protected void onPostExecute(Movie[] movies) {
            super.onPostExecute(movies);
        }
    }
}