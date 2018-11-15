package com.chen.pa.app_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.chen.pa.app_activity.LogTag;


/*
 * 在Activity中绑定该service时会调OnBind方法，将IBinder返回
 * 它将service中的内容传递给activity，相当于通过Ibinder来进行通信。
 * startService()开启服务,(一开始没有Service,创建onCreate()开启),运行onStartCommand(),只能通过stopService()来Destory();
 * bindService()开启的服务(一开始没有Service创建onCreate()开启),运行onBind(), stopService()无法Destory,通过unbindService()来Destory();
 * @author chenguax
 */
public class LifeCycleService extends Service {

    public LifeCycleService() {
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " LifeCycleService 构造方法");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " onDestroy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LogTag.TAG_SERVICE, getClass().getSimpleName() + " onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
