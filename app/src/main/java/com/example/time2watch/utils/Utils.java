package com.example.time2watch.utils;

import com.example.time2watch.classes.Movie;
import com.example.time2watch.classes.TVShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static void fixImageURL(TVShow tvShow) {
        if (tvShow.getPoster_path() != null)
            tvShow.setPoster_path("https://www.themoviedb.org/t/p/original" + tvShow.getPoster_path());
        if (tvShow.getBackdrop_path() != null)
            tvShow.setBackdrop_path("https://www.themoviedb.org/t/p/original" + tvShow.getBackdrop_path());
    }

    public static void fixImageURL(Movie movie) {
        if (movie.getPoster_path() != null)
            movie.setPoster_path("https://www.themoviedb.org/t/p/original" + movie.getPoster_path());
        if (movie.getBackdrop_path() != null)
            movie.setBackdrop_path("https://www.themoviedb.org/t/p/original" + movie.getBackdrop_path());
    }


    public static JsonObject getJSON(String url) {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            Gson gson = new Gson();
            return gson.fromJson(jsonText, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
