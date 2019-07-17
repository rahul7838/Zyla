package com.example.zyla.ui;

import com.example.zyla.Model.Artist;

import java.util.ArrayList;

public interface Contract {

    interface PresenterInterface {
       void getData();
    }

    interface ViewInterface {
        void showUi(ArrayList<Artist> artistArrayList);
    }
}
