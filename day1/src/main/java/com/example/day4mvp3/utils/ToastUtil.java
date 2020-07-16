package com.example.day4mvp3.utils;

import android.widget.Toast;

import com.example.day4mvp3.BaseApp;


public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_LONG).show();
    }
}
