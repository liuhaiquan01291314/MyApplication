package com.example.day08view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day08view.MyProgressBar;
import com.example.day08view.R;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 进度开始
     */
    private Button mBtnStart;
    /**
     * day8myview2
     */
    private MyProgressBar mMyProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(this);
        mMyProgressBar = (MyProgressBar) findViewById(R.id.myProgressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_start:
                addProgress();
                break;
        }
    }

    private void addProgress() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mMyProgressBar.setProgress(i);
                }
            }
        }.start();
    }
}
