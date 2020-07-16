package com.example.day4mvp3.presenter;

import com.example.day4mvp3.Bean.BeanPresenter;
import com.example.day4mvp3.CallBack;
import com.example.day4mvp3.DataBean;
import com.example.day4mvp3.Loginview.Loginview;
import com.example.day4mvp3.modle.Loginmodle;

import java.util.List;

public class Loginpresenter extends BeanPresenter<Loginview> implements CallBack {
    private Loginmodle loginmodle;
    @Override
    public void initModel() {
 loginmodle =new Loginmodle();
    addModel(loginmodle);
    }

    @Override
    public void onsend(List<DataBean.ResultsBean> beans) {
         Mview.send(beans);
    }

    @Override
    public void onfile(String file) {
     Mview.shouToast(file);
    }

    public void sendata() {
        loginmodle.sendata(this);
    }
}
