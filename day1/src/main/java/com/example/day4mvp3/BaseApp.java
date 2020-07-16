package com.example.day4mvp3;

import android.app.Application;
import android.content.res.Resources;

public class BaseApp extends Application {
    public static BaseApp sBaseApp;
    @Override
    public void onCreate() {
        super.onCreate();

        sBaseApp = this;//引用本App对象
    }

    public static Resources getRes(){//用来获取value下的strings.xml中的字符串资源
        return sBaseApp.getResources();
    }
}
