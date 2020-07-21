package com.example.umengday09;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 分享-带面板
     */
    private Button mDan;
    private String e="5454545";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        requestPermiss();
    }
    private void requestPermiss() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    //授权的回调
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    private void initView() {
        mDan = (Button) findViewById(R.id.dan);
        mDan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.dan:
                shareBoard();
                break;
        }
    }
    private void shareBoard() {
        new ShareAction(MainActivity.this)
                .withText("hello")//分享的信息  hello
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)//分享到的平台 微博，qq，微信
                .setCallback(umShareListener)//添加监听
                .open();
//        UMImage image = new UMImage(MainActivity.this, "imageurl");//网络图片
//        UMImage image = new UMImage(MainActivity.this, file);//本地文件
        UMImage image = new UMImage(MainActivity.this, R.drawable.an);//资源文件
//        UMImage image = new UMImage(MainActivity.this, bitmap);//bitmap文件
//        UMImage image = new UMImage(MainActivity.this, byte[]);//字节流
       UMImage thumb =  new UMImage(this, R.drawable.an);
        image.setThumb(thumb);
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
//        压缩格式设置
//        image.compressFormat = Bitmap.CompressFormat.PNG;//用户分享透明背景的图片可以设置这种方式，但是qq好友，微信朋友圈，不支持透明背景图片，会变成黑色
        new ShareAction(MainActivity.this).withText("hello").withMedia(image).share();
    }
    //分享的监听
    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @param platform 平台类型
         * @descrption 分享开始的回调
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @param platform 平台类型
         * @descrption 分享成功的回调
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @param platform 平台类型
         * @param t        错误原因
         * @descrption 分享失败的回调
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @param platform 平台类型
         * @descrption 分享取消的回调
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };
}
