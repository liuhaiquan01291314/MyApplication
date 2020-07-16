package com.example.day07view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {
    private EditText mEtKey;
    private ImageView mImgDown;
    private ArrayList<String> mData;
    private PopupWindow mpw;

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.veiw_spinner, this);
        initView();
        initData();
    }
    private void initView() {
        mEtKey = findViewById(R.id.et_key);
        mImgDown = findViewById(R.id.img_down);
        mImgDown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dealPopup();
            }
        });
    }

    private void dealPopup() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,mData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mData.get(position);
                mEtKey.setText(s);
                mEtKey.setSelection(s.length());
               mpw.dismiss();
            }
        });
        mpw = new PopupWindow(listView,mEtKey.getWidth(),600);
      mpw.setBackgroundDrawable(null);
      mpw.setOutsideTouchable(true);
      mpw.showAsDropDown(mEtKey);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("班级"+i);
        }
    }




}
