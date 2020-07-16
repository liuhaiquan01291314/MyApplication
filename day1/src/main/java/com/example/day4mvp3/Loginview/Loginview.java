package com.example.day4mvp3.Loginview;

import com.example.day4mvp3.Bean.Beanview;
import com.example.day4mvp3.DataBean;

import java.util.List;

public interface Loginview extends Beanview {
    void send(List<DataBean.ResultsBean> dataBeans);
}
