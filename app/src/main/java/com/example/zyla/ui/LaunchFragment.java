package com.example.zyla.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zyla.Model.Artist;
import com.example.zyla.R;

import java.util.ArrayList;
import java.util.Objects;

public class LaunchFragment extends Fragment implements Contract.ViewInterface {
    private static final String TAG = LaunchFragment.class.getSimpleName();
    private VerticalRecyclerViewAdapter adapter;
    private RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.action_sort, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        AppCompatSpinner spinner = view.findViewById(R.id.spinner);
//        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, );
//        spinner.setAdapter(ad);
        rv = view.findViewById(R.id.vertical_recycler);
        LinearLayoutManager ll = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv.setLayoutManager(ll);
        rv.setHasFixedSize(true);
        new Presenter(this).getData();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.One:
                adapter.refreshVerticalView(1);
                break;
            case R.id.Two:
                adapter.refreshVerticalView(2);
                break;
            case R.id.Three:
                adapter.refreshVerticalView(3);
                break;
            case R.id.Four:
                adapter.refreshVerticalView(4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showUi(ArrayList<Artist> artistArrayList) {
        Log.i(TAG, artistArrayList.get(0).getName());
        adapter = new VerticalRecyclerViewAdapter(artistArrayList, getContext());
        rv.setAdapter(adapter);
    }
}
