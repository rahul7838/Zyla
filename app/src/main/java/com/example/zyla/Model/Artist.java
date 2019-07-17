package com.example.zyla.Model;

import java.util.ArrayList;

public class Artist {
    private String name;
    private ArrayList<String> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSongList() {
        return songs;
    }

    public void setSongList(ArrayList<String> songList) {
        this.songs = songList;
    }
}
