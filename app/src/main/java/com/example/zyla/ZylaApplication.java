package com.example.zyla;

import android.app.Application;
import android.content.Context;

public class ZylaApplication extends Application {

static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getAppContext() {
        return context;
    }
}
