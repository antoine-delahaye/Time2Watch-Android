package com.example.time2watch;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("tmdb_sample.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("results");
            ArrayList<HashMap<String, String>> formList = new ArrayList<>();
            HashMap<String, String> m_li;
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("title"));
                String title = jo_inside.getString("title");
                String poster_path = jo_inside.getString("poster_path");
                m_li = new HashMap<>();
                m_li.put("title", title);
                m_li.put("poster_path", poster_path);
                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}