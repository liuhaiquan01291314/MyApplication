package com.example.day4mvp3.Bean;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BeanActivity<P extends BeanPresenter >extends AppCompatActivity implements Beanview {
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());//布局不是是固定死的，子类传什么用什么
        ButterKnife.bind(this);//每一页面都需要ButterKnife找组件，此处写上，由子类继续共享
        initPresenter();//子类必须创建P对象，在initPresenter中创建  给mPresenter赋值，new对象
        if(mPresenter != null)
            mPresenter.bindView(this);//把view和presenter进行结合绑定
        initView();//处理组件
        initData();//加载数据
        initListener();//设置一些监听
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresenter();

    public abstract int getLayout();
}
