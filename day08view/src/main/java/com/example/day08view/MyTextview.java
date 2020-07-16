package com.example.day08view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class MyTextview extends TextView {

    public MyTextview(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public MyTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.RED);
        canvas.rotate(35,getMeasuredWidth()/10,getMeasuredHeight()/10);
        super.onDraw(canvas);
    }
}
