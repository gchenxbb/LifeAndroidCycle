package com.pa.chen.appipc.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.launchmode.R;
import com.pa.chen.appipc.constants.Constants;
import com.pa.chen.appipc.ipcinterface.IAppThreadCallBack;
import com.pa.chen.appipc.ipcinterface.ICountManagerService;
import com.pa.chen.appipc.service.CountService;
import com.pa.chen.appipc.utils.Utils;


//该组件用于绑定一个服务进程Service
public class SecActivity extends Activity {
    public String className = "SecActivity:";
    TextView mTvSec;

    private IAppThreadCallBack mAppThreadCb;//回调主进程的业务接口
    ICountManagerService countManagerService;//进程通信业务接口
    final MHandler mH = new MHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        mAppThreadCb = new AppThreadCallBack();
        //
        initView();

        //建立与Service的连接
        connect();
    }


    private void initView() {
        mTvSec = findViewById(R.id.tv_sec);
        mTvSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getServiceConut();
            }
        });
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disConnect();
        countManagerService = null;
    }

    //其他进程回调
    class AppThreadCallBack extends IAppThreadCallBack.Stub {
        @Override
        public void implementAction(int counts) throws RemoteException {
            //打印线程名,当线程休眠等待服务Binder线程工作时，服务线程回调主进程会重用请求线程
            Log.d(Constants.TAG, className + ":currentThread:" + Thread.currentThread().getName());
            Message msg = Message.obtain();
            msg.what = MHandler.ACTION;
            msg.obj = counts;
            mH.sendMessage(msg);
        }

        @Override
        public void scheduleHandleActivity(String isActivity) throws RemoteException {
            //打印线程名
            Log.d(Constants.TAG, className + ":currentThread:" + Thread.currentThread().getName());
            Message msg = Message.obtain();
            msg.what = MHandler.ACTIVITY;
            msg.obj = isActivity;
            mH.sendMessage(msg);
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接成功后立即这时会阻塞线程一小段时间，这里会看服务完成事件的时间为准。
            Log.d(Constants.TAG, className + ":onServiceConnected:");
            countManagerService = ICountManagerService.Stub.asInterface(service);
            getServiceConut();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //正常unbind不会调用,杀掉进程，adb shell kill pid可以触发此方法,然后会Service自动重启
            Log.d(Constants.TAG, className + ":onServiceDisconnected:");
            countManagerService = null;
        }
    };

    void connect() {
        bindService(new Intent(this, CountService.class), mConnection, Context.BIND_AUTO_CREATE + Context.BIND_DEBUG_UNBIND);
    }

    void disConnect() {
        //解绑后，再次bing，服务进程重用，Service会经历onCreate和onDestory
        unbindService(mConnection);
    }

    //获取服务进程数据
    private void getServiceConut() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (countManagerService != null) {
                        countManagerService.invokeCallback(mAppThreadCb, 2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("thread-req-service");
        thread.start();
    }

    private class MHandler extends Handler {
        public static final int ACTIVITY = 0x10;
        public static final int ACTION = 0x11;

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ACTION: {
                    int count = (int) msg.obj;
                    Utils.showToast(SecActivity.this, "currentCount:"+count);
                }
                break;
                case ACTIVITY: {
                }break;
                default:
                    break;
            }
        }
    }
}
