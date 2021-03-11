package com.example.time2watch.api;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.time2watch.R;
import com.example.time2watch.BuildConfig;
import com.example.time2watch.classes.TVShow;
import com.example.time2watch.ui.tvshows.TVShowDetailActivity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import static com.example.time2watch.utils.Utils.fixImageURL;
import static com.example.time2watch.utils.Utils.getJSON;

public class TVShowAPI extends AsyncTask<Integer, Void, TVShow> {

    private final TVShowDetailActivity tvShowDetailActivity;

    public TVShowAPI(TVShowDetailActivity tvShowDetailActivity) {
        this.tvShowDetailActivity = tvShowDetailActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected TVShow doInBackground(Integer... integers) {
        JsonObject jsonObject;
        try {
            jsonObject = getJSON("https://api.themoviedb.org/3/tv/" + integers[0] + "?api_key=" + BuildConfig.API_KEY + "&language=fr");
        } catch (IndexOutOfBoundsException e) {
            Log.d("TVShow", "Not a valid tv show ID");
            return new TVShow();
        }

        TVShow tvShow = new Gson().fromJson(jsonObject, TVShow.class);
        fixImageURL(tvShow);

        return tvShow;
    }

    @Override
    protected void onPostExecute(TVShow tvShows) {
        super.onPostExecute(tvShows);
        Picasso.get().load(tvShows.getPoster_path()).into((ImageView) this.tvShowDetailActivity.findViewById(R.id.tvshow_detail_poster));
        TextView textView = this.tvShowDetailActivity.findViewById(R.id.tvshow_detail_name);
        textView.setText(tvShows.getName());
        textView = this.tvShowDetailActivity.findViewById(R.id.tvshow_detail_air_date);
        textView.setText(this.tvShowDetailActivity.getString(R.string.release_date, tvShows.getFirst_air_date()));
        textView = this.tvShowDetailActivity.findViewById(R.id.tvshow_detail_vote_average);
        textView.setText(this.tvShowDetailActivity.getString(R.string.vote_average, tvShows.getVote_average()));
        textView = this.tvShowDetailActivity.findViewById(R.id.tvshow_detail_overview);
        textView.setText(this.tvShowDetailActivity.getString(R.string.overview, tvShows.getOverview()));
        Log.d("TVShowAPI", tvShows.toString());
    }
}
