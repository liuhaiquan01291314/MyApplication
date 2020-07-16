package com.example.myapplication5.Presenter;

import com.example.myapplication5.Bean.BeanData;
import com.example.myapplication5.Bean.BeanPresenter;
import com.example.myapplication5.CallBack;
import com.example.myapplication5.Modle.MainModle;
import com.example.myapplication5.View.MainView;

import java.util.List;

public class MainPresenter extends BeanPresenter<MainView> implements CallBack {
    private MainModle mainModle;
    public void setData() {
         mainModle.getData(this);
    }

    @Override
    public void initModel() {
        mainModle=new MainModle();
        addModel(mainModle);
    }

    @Override
    public void Send(List<BeanData.T1348647909107Bean> beans) {
        Mview.Send(beans);
    }

    @Override
    public void File(String str) {
        Mview.shouToast(str);
    }
}
