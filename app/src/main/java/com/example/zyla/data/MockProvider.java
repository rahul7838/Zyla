package com.example.zyla.data;

import android.content.res.AssetManager;

import com.example.zyla.ZylaApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MockProvider {

    public static String json() {
        AssetManager assetManager = ZylaApplication.getAppContext().getAssets();
        InputStream inputStream = null;
        StringBuilder stringBuilder = null;
        try {
            inputStream = assetManager.open("artist.json");


            stringBuilder = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
