package com.example.day4mvp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;


import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day4mvp3.Bean.BeanActivity;
import com.example.day4mvp3.Loginview.Loginview;
import com.example.day4mvp3.presenter.Loginpresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BeanActivity<Loginpresenter>implements Loginview {

    @BindView(R.id.Recy)
    RecyclerView mRecy;
    private ArrayList<DataBean.ResultsBean> list;
    private RecyAdapter adapter;



    @Override
    protected void initData() {
   mPresenter.sendata();
    }

    @Override
    protected void initView() {
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        mRecy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        adapter = new RecyAdapter(list, this);
        mRecy.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (i != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }
    }
    @Override
    protected void initPresenter() {
        mPresenter=new Loginpresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void send(List<DataBean.ResultsBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void shouToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
