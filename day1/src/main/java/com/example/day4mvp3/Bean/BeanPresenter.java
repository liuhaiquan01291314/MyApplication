package com.example.day4mvp3.Bean;

import com.example.day4mvp3.modle.Loginmodle;

import java.util.ArrayList;

public abstract class BeanPresenter<V extends Beanview> {
   public V Mview;
    public ArrayList<Loginmodle> mModels = new ArrayList<Loginmodle>();

    public BeanPresenter(){
        initModel();//处理model
    }
    public void addModel(Loginmodle model){
        mModels.add(model);//收集model，便于管理
    }
    public abstract void initModel();

    public void bindView(V view){//绑定view
        this.Mview = view;
    }
}
