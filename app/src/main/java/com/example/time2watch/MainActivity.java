package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.time2watch.classes.Movie;
import com.example.time2watch.api.GetTrendingMoviesWeek;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

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
        AsyncTask jsonObject = new GetTrendingMoviesWeek().execute();
    }
}