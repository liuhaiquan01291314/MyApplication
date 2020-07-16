package com.example.myapplication5;

import com.example.myapplication5.Bean.BeanData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    String url="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<BeanData> bend();
}
