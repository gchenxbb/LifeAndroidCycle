package com.chen.pa.activity;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chen.pa.R;
import com.chen.pa.service.LifeCycleService;

//Activity生命周期
public class MainActivity extends Activity {
    private boolean willGoSecondActivity = false;
    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnBind;
    private Button mBtnUnBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onCreate");
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        ((TextView) findViewById(R.id.tv_main)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                willGoSecondActivity = true;
                MainActivity.this.startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        //Service
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startService(new Intent(MainActivity.this, LifeCycleService.class));
            }
        });
        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.stopService(new Intent(MainActivity.this, LifeCycleService.class));
            }
        });
        findViewById(R.id.btn_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.bindService(new Intent(MainActivity.this, LifeCycleService.class), mCon = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {

                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                }, Service.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.btn_unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCon == null) {
                    Log.d(LogTag.TAG_SERVICE, "Service not registered");
                } else {
                    MainActivity.this.unbindService(mCon);
                    mCon = null;
                }
            }
        });
    }

    ServiceConnection mCon;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onPause");
//        if (willGoSecondActivity) {
//            //打开可模拟一个耗时操作，看是否影响SecondActivity的启动，默认注释掉
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e) {
//            }
//            willGoSecondActivity = false;
//        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onDestroy");
    }
}
