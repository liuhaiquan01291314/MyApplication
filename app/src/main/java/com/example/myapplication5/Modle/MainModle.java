package com.example.myapplication5.Modle;

import com.example.myapplication5.Apiservice;
import com.example.myapplication5.Bean.BeanData;
import com.example.myapplication5.Bean.BeanModle;
import com.example.myapplication5.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModle extends BeanModle {
    public void getData(CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservice.url)
                .build();
        Apiservice apiservice = build.create(Apiservice.class);
        Observable<BeanData> bend = apiservice.bend();
        bend.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanData beanData) {
                         callBack.Send(beanData.getT1348647909107());
                    }

                    @Override
                    public void onError(Throwable e) {
                           callBack.File(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
