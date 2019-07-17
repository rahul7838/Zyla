package com.example.zyla.data;

public interface DataProvider1 {

//    ArrayList<Music> getList(Callback<Music> callback);


    interface Callback<T> {

        void onSuccess(T music);

        void onFailure(String message);
    }
}
