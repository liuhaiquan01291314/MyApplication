package com.example.day6;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager service;
    private int[] musics = {R.raw.a,R.raw.b};
    int index = 0;
    private MediaPlayer mMp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = (SensorManager) getSystemService(SENSOR_SERVICE);
//        userOrien();
//        userLight();
        getOreient();
       getAllSensor();
        getAccele();
        }

    private void userLight() {
        Sensor light = service.getDefaultSensor(Sensor.TYPE_LIGHT);
        service.registerListener(new List2(),light,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void userOrien() {
        Sensor orien = service.getDefaultSensor(Sensor.TYPE_ORIENTATION);//获得方向传感器
        service.registerListener(new Lis1(),orien,SensorManager.SENSOR_DELAY_NORMAL);//注册
    }
    public class Lis1 implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float i = event.values[0];
            Log.i("111", "方向角度: "+i);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
//    private void getAllSensor() {
//        //得到传感器管理器
//
//        List<Sensor> sensorList = service.getSensorList(Sensor.TYPE_ALL);//得到此手机的所有传感器
//        for (int i = 0; i < sensorList.size(); i++) {
//            Sensor sensor = sensorList.get(i);
//            String name = sensor.getName();//得到名字
//            String vendor = sensor.getVendor();//得到生成厂商
//            int version = sensor.getVersion();//得到版本
//            Log.i("111", "onCreate: "+name+","+vendor+","+version);
//        }
//    }

    public class List2 implements SensorListener, SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()==Sensor.TYPE_LIGHT){
               float f=event.values[0];
                Log.i("111", "onSensorChanged: 光线亮度"+f
                );
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(int sensor, float[] values) {

        }

        @Override
        public void onAccuracyChanged(int sensor, int accuracy) {

        }
    }
    private SensorEventListener lis3 = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ORIENTATION){
                float f = event.values[0];
                Log.i("1111", "方向的角度: "+f);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private void getOreient() {
        Sensor sensor = service.getDefaultSensor(Sensor.TYPE_ORIENTATION);//得到方向传感器
        service.registerListener(lis3,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    private SensorEventListener lis1 = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){//加速度感应器发生变化
                float[] value = event.values;//得到xyz三个方向的数据的变化
                float x = value[0];//x轴的新值
                float y = value[1];//y轴的新值
                float z = value[2];//z轴的新值
                Log.i("111", "x="+x+",y="+y+",z="+z);
                if(z > 12){//甩动切歌
                    if(mMp != null){
                        mMp.stop();
                        mMp.release();
                    }
                    index++;//下标加1
                    index = index%musics.length;//防止越界

                    mMp = MediaPlayer.create(MainActivity.this,musics[index]);
                    mMp.start();
                }

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    private void getAccele() {
        //先播放音乐
        mMp = MediaPlayer.create(this, musics[index]);
        mMp.start();

        Sensor sensor = service.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //lis1监听器  sensor是感应器  SensorManager.SENSOR_DELAY_NORMAL感应器的灵敏度
        service.registerListener(lis1,sensor,SensorManager.SENSOR_DELAY_NORMAL);//注册感应器的监听器
    }

    private void getAllSensor() {

        List<Sensor> sensorList = service.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            Sensor sensor = sensorList.get(i);
            Log.i("1111", i+"  "+sensor.getName());
        }

    }
}
