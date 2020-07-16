package com.example.myapplication5.Bean;

import com.example.myapplication5.Modle.MainModle;

import java.util.ArrayList;

public abstract class BeanPresenter<V extends BeanView> {
    public V Mview;
    public ArrayList<MainModle> mModels = new ArrayList<MainModle>();

    public BeanPresenter(){
        initModel();//处理model
    }
    public void addModel(MainModle model){
        mModels.add(model);//收集model，便于管理
    }
    public abstract void initModel();

    public void bindView(V view){//绑定view
        this.Mview = view;
    }
}
