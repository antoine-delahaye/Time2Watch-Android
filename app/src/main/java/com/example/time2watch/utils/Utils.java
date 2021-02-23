package com.example.time2watch.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Utils {
    public static JsonObject getJSON(String url) {
        JsonObject jsonObject = null;
        try {
            URL u = new URL(url);
            Scanner sc = new Scanner(u.openStream());
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
}
