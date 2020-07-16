package com.example.umengday09;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class BaseAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化友盟AK  5ea8e6a00cafb2d93c0001ec友盟创建的应用的AK'
        UMConfigure.init(this,"5f0fb4ed9540fd07a29ff0da","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        //新浪微博  AK的生产需要报名和此项目一致，所以要到微博中申请
        PlatformConfig.setSinaWeibo("1873289174", "5258957647fe33b8f82cf83a6d5fb3bd","http://sns.whalecloud.com");
        //微信的AK  现在微信平台限制严格，用不了
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //qq空间  现在QQ平台限制严格，用不了
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

//        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
//        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
//        PlatformConfig.setAlipay("2015111700822536");
//        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
//        PlatformConfig.setPinterest("1439206");
//        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
//        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
//        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
//        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
//        PlatformConfig.setYnote("9c82bf470cba7bd2f1819b0ee26f86c6ce670e9b");
    }
}
