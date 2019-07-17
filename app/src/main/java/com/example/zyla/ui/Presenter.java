package com.example.zyla.ui;

import com.example.zyla.Model.Artist;
import com.example.zyla.Model.Response;
import com.example.zyla.data.MockProvider;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Presenter implements Contract.PresenterInterface {
    private Contract.ViewInterface view;
    public Presenter(Contract.ViewInterface view) {
        this.view = view;
    }

    @Override
    public void getData() {
        String jsonString = MockProvider.json();
        Gson gson = new Gson();
        Response response = gson.fromJson(jsonString, Response.class);
        ArrayList<Artist> artistList = response.getArtist();
        view.showUi(artistList);
    }
}
