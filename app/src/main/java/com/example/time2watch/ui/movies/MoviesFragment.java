package com.example.time2watch.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.time2watch.MainActivity;
import com.example.time2watch.R;
import com.example.time2watch.api.TrendingMoviesAPI;

public class MoviesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        MainActivity.moviesRecyclerView = view.findViewById(R.id.movies_recycler_view);
        MainActivity.moviesRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        new TrendingMoviesAPI().execute(MainActivity.WEEK);
        return view;
    }

}