package com.example.day4mvp3;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservive {
    String url="https://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/20/3")
    Observable<DataBean> data();
}
