package com.example.time2watch.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.time2watch.MainActivity;
import com.example.time2watch.R;
import com.example.time2watch.api.SearchMultiAPI;

public class SearchFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        MainActivity.searchRecyclerView = view.findViewById(R.id.search_recycler_view);
        MainActivity.searchRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.isEmpty()) {
                    search(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()) {
                    search(newText);
                }
                return false;
            }
        });
        return view;
    }

    public void search(String input) {
        new SearchMultiAPI().execute(input);
    }

}
