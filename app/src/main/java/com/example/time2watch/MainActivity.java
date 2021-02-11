package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.time2watch.api.Movie;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public String apiKey = "ccbc42c4b357545c785bb0d1caba6301";

    public JSONObject JSONFromURL(String urlPage) {
        URL url = null;
        Scanner sc = null;
        JSONObject jsonObject = null;
        try {
            url = new URL(urlPage);
            sc = new Scanner(url.openStream());
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }
            String result = sb.toString();
            jsonObject = new JSONObject(result);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // https://api.themoviedb.org/3/trending/movie/week?api_key=ccbc42c4b357545c785bb0d1caba6301&language=fr
    }

    private class getTrendingMoviesWeek extends AsyncTask<Void, Void, ArrayList<Movie>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Movie> doInBackground(Void... voids) {

            return new ArrayList<Movie>();
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            super.onPostExecute(movies);
        }
    }
}