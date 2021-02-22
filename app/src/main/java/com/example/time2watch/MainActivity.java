package com.example.time2watch;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<HashMap<String, String>> movies = new ArrayList<>();

    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    public String loadJsonFromAsset() {
        String data = null;
        try {
            InputStream file = this.getAssets().open("tmdb_sample.json");
            byte[] buffer = new byte[file.available()];
            file.read(buffer);
            file.close();
            data = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            Log.d("loadJsonFromAsset", String.valueOf(exception));
        }
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONArray jsonArray = new JSONObject(loadJsonFromAsset()).getJSONArray("results");
            HashMap<String, String> movie;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.d("onCreate", jsonObject.getString("title"));
                String title = jsonObject.getString("title");
                String posterPath = jsonObject.getString("poster_path");
                movie = new HashMap<>();
                movie.put("title", title);
                movie.put("poster_path", posterPath);
                this.movies.add(movie);
            }
        } catch (JSONException exception) {
            Log.d("onCreate", String.valueOf(exception));
        }
        this.recyclerView = findViewById(R.id.recyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(layoutManager);
        this.adapter = new MovieAdapter(this.movies);
        this.recyclerView.setAdapter(this.adapter);
    }

}