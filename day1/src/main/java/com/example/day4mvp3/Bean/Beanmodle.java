package com.example.day4mvp3.Bean;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class Beanmodle {
    ///这也是一个容器,Rxjava专门写的用来放Disposable,调用dispose()可以把容器所有的
    //Disposable 的网络请求和订阅关系取消
    public CompositeDisposable mDisposable = null;
    public void addDisposable(Disposable disposable){
        if(mDisposable == null){
            synchronized (Beanmodle.class){
                if(mDisposable == null)
                    mDisposable = new CompositeDisposable();//创建CompositeDisposable对象
            }
        }
        mDisposable.add(disposable);//把网络请求保存在CompositeDisposable中
    }

    public void dispose(){
        if(mDisposable != null){
            mDisposable.dispose();//解除rxjava和网络请求的关联关系，销毁网络请求
        }
    }

    //移除disposable
    public void removeDisposable(Disposable disposable){
        if(mDisposable != null)
            mDisposable.remove(disposable);
    }

}
