package com.example.myapplication5;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.Bean.BeanActivity;
import com.example.myapplication5.Bean.BeanData;
import com.example.myapplication5.Presenter.MainPresenter;
import com.example.myapplication5.View.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BeanActivity<MainPresenter> implements MainView {

    @BindView(R.id.Recy)
    RecyclerView mRecy;
    @BindView(R.id.zuo)
    Button mZuo;
    @BindView(R.id.shan)
    Button mShan;
    @BindView(R.id.wan)
    Button mWan;
    private ArrayList<BeanData.T1348647909107Bean> list;
    private RecyAdapter adapter;


    @OnClick({R.id.zuo, R.id.shan, R.id.wan})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zuo:
                adapter.setData(true);
                adapter.notifyDataSetChanged();
                break;
            case R.id.shan:
                for (int i = 0; i < list.size(); i++) {
                    boolean xuan = list.get(i).isXuan();
                    if (xuan==true)
                    {
                        list.remove(i);
                        i--;
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.wan:
                adapter.setDataa(false);
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
   mPresenter.setData();
    }

    @Override
    protected void initView() {
        mRecy.setLayoutManager(new LinearLayoutManager(this));
     mRecy.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        adapter = new RecyAdapter(list, this);
        mRecy.setAdapter(adapter);
    }

    @Override
    protected void initPresenter() {
         mPresenter=new MainPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void shouToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Send(List<BeanData.T1348647909107Bean> beanList) {
       list.addAll(beanList);
       adapter.notifyDataSetChanged();
    }
}
