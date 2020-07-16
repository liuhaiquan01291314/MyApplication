package com.example.day4mvp3;

import java.util.List;

public interface CallBack {
    void onsend(List<DataBean.ResultsBean> beans);
    void onfile(String file);
}
