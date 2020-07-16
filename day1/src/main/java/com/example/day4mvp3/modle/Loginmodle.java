package com.example.day4mvp3.modle;

import com.example.day4mvp3.Apiservive;
import com.example.day4mvp3.BaseObserver;
import com.example.day4mvp3.Bean.Beanmodle;
import com.example.day4mvp3.CallBack;
import com.example.day4mvp3.DataBean;
import com.example.day4mvp3.HttpUtils;
import com.example.day4mvp3.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loginmodle extends Beanmodle {
    public void sendata(final CallBack callBack) {
        Apiservive apiserver = HttpUtils.getInstance().getApiserver(Apiservive.url, Apiservive.class);
        Observable<DataBean> observable = apiserver.data();
//compose 简化线程切换
        observable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DataBean>(this) {
                    @Override
                    protected void onSuccess(DataBean fuliBean) {
                        callBack.onsend(fuliBean.getResults());
                    }

                    @Override
                    protected void error(String err) {
                        callBack.onfile(err);
                    }
                });
//        Retrofit build = new Retrofit.Builder()
//                .baseUrl(Apiservive.url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        Apiservive apiservive = build.create(Apiservive.class);
//        Observable<DataBean> data = apiservive.data();
//        data.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<DataBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(DataBean dataBean) {
//                    callBack.onsend(dataBean.getResults());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                  callBack.onfile(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

}
