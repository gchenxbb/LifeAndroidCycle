package com.lifecycle.launchmode;

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

//生命周期-Service
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mBtnStart;
    private TextView mBtnStop;
    private TextView mBtnBind;
    private TextView mBtnUnBind;
    ServiceConnection mCon;

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
            startService(new Intent(ServiceActivity.this, LifeCycleService.class));
        } else if (id == R.id.btn_stop_service) {
            stopService(new Intent(ServiceActivity.this, LifeCycleService.class));
        } else if (id == R.id.btn_bind_service) {
            bindService(new Intent(ServiceActivity.this, LifeCycleService.class), mCon = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            }, Service.BIND_AUTO_CREATE);
        } else if (id == R.id.btn_unbind_service) {
            if (mCon == null) {
                Log.d(LogTag.TAG_SERVICE, "Service not registered");
            } else {
                unbindService(mCon);
                mCon = null;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onPause");
    }
}
