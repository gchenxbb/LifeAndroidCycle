package com.lifecycle.ponent.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.lifecycle.ponent.ICountAidlInterface;

/**
 * 在Activity中绑定该service时会调OnBind方法，将IBinder返回
 * 它将service中的内容传递给activity，相当于通过Ibinder来进行通信。
 * startService()开启服务,(一开始没有Service,创建onCreate()开启),运行onStartCommand(),只能通过stopService()来Destory();
 * bindService()开启的服务(一开始没有Service创建onCreate()开启),运行onBind(), stopService()无法Destory,通过unbindService()来Destory();
 */
public class LifeCycleService extends Service {
    private final static String TAG_SERVICE = "LifeCycleService";
    private String className = getClass().getSimpleName();
    private int mCount = 10;

    public LifeCycleService() {
        Log.d(TAG_SERVICE, className + " 构造方法");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG_SERVICE, className + " onBind() 方法：" + mBinder.toString());
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG_SERVICE, className + " onUnbind() 方法");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG_SERVICE, className + " onDestroy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG_SERVICE, className + " onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG_SERVICE, className + " onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    private ICountAidlInterface.Stub mBinder = new ICountAidlInterface.Stub() {

        @Override
        public int getCount() throws RemoteException {
            return mCount;
        }
    };

}
