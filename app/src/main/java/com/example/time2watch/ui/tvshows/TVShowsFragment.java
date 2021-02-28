package com.example.time2watch.ui.tvshows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.MainActivity;
import com.example.time2watch.R;
import com.example.time2watch.api.TrendingTVShowsAPI;

public class TVShowsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);
        MainActivity.tvShowsRecyclerView = view.findViewById(R.id.tvshows_recycler_view);
        MainActivity.tvShowsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        new TrendingTVShowsAPI().execute(MainActivity.WEEK);
        return view;
    }

}