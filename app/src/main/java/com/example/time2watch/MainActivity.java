package com.example.time2watch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.time2watch.api.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TmdbMovies movies = new TmdbApi("ccbc42c4b357545c785bb0d1caba6301").getMovies();
//        MovieDb movie = movies.getMovie(5353, "fr");
//        System.out.println(movie.getHomepage());
        AsyncTask tmdbMovies = new getTrendingMoviesWeek().execute();

    }

    private class getTrendingMoviesWeek extends AsyncTask<Void, Void, ArrayList<Movie>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Movie> doInBackground(Void... voids) {
            System.out.println("teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeest");
            return new ArrayList<Movie>();
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            super.onPostExecute(movies);
        }
    }
}