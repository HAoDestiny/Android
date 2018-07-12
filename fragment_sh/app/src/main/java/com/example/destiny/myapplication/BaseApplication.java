package com.example.destiny.myapplication;

import android.app.Application;

import com.example.destiny.myapplication.util.AudioUtil;
import com.example.destiny.myapplication.util.FontsOverride;

/**
 * created by DESTINY on 2018/7/12
 */

public final class BaseApplication extends Application {

    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/PingFang-ExtraLight.ttf");
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
