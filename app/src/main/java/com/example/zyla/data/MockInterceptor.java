package com.example.zyla.data;

import android.content.res.AssetManager;

import com.example.zyla.ZylaApplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MockInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return getResponse(chain);
    }

    private Response getResponse(Chain chain) {
        return new Response.Builder()
                .body(json())
                .request(chain.request())
                .code(200)
                .message("responseString")
                .protocol(Protocol.HTTP_1_0)
                .build();
    }

    private ResponseBody json() {
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
        return ResponseBody.create(MediaType.parse("application/json"),stringBuilder.toString());
    }

}

