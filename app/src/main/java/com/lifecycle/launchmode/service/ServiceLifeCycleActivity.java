package com.lifecycle.launchmode.service;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecycle.launchmode.ICountAidlInterface;
import com.lifecycle.launchmode.R;

/**
 * 生命周期-Service
 * <p>
 * 当前现象是：绑定多次，解绑，不会调用onCreate，onBind，unBind和onDestory
 */
public class ServiceLifeCycleActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG_SERVICE = "ServiceLifeCycle";

    private TextView mBtnStart;
    private TextView mBtnStop;
    private TextView mBtnBind;
    private TextView mBtnUnBind;
    ServiceConnection mCon;

    ICountAidlInterface mStubService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
    }

    protected void initView() {
        mBtnStart = findViewById(R.id.btn_start_service);
        mBtnStop = findViewById(R.id.btn_stop_service);
        mBtnBind = findViewById(R.id.btn_bind_service);
        mBtnUnBind = findViewById(R.id.btn_unbind_service);

        //Service
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mBtnBind.setOnClickListener(this);
        mBtnUnBind.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_start_service) {
            startService(new Intent(ServiceLifeCycleActivity.this, LifeCycleService.class));
        } else if (id == R.id.btn_stop_service) {
            stopService(new Intent(ServiceLifeCycleActivity.this, LifeCycleService.class));
        } else if (id == R.id.btn_bind_service) {
            Intent intent = new Intent(ServiceLifeCycleActivity.this, LifeCycleService.class);
            bindService(intent, mCon = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    //必须在onBind方法返回对象才会调用
                    Log.d(TAG_SERVICE, "Service Connected:" + name.getClassName());
                    mStubService = (ICountAidlInterface) service;
                    try{
                        int count =  mStubService.getCount();
                        Log.d(TAG_SERVICE, "Service Connected Count:" + count);
                    }catch (Exception e){
                        Log.d(TAG_SERVICE, "Service Connect Remote Exception" + name.getClassName());
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    Log.d(TAG_SERVICE, "Service DisConnected:" + name.getClassName());
                    Toast.makeText(ServiceLifeCycleActivity.this, "Service DisConnected:" + name.getClassName(), Toast.LENGTH_SHORT).show();
                }
            }, Service.BIND_AUTO_CREATE);
        } else if (id == R.id.btn_unbind_service) {
            if (mCon == null) {
                Toast.makeText(ServiceLifeCycleActivity.this, "Service not registered", Toast.LENGTH_SHORT).show();
                Log.d(TAG_SERVICE, "Service not registered");
            } else {
                Toast.makeText(ServiceLifeCycleActivity.this, "准备Service 解除绑定", Toast.LENGTH_SHORT).show();
                Log.d(TAG_SERVICE, "准备Service 解除绑定");
                unbindService(mCon);
                mCon = null;
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCon == null) {
            Log.d(TAG_SERVICE, "Service not registered");
        } else {
            Log.d(TAG_SERVICE, "准备Service 解除绑定");
            unbindService(mCon);
            mCon = null;
        }
    }


}
