package com.life.ipc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.life.ipc.Constants;
import com.life.ipc.ipcinterface.IAppThreadCallBack;
import com.life.ipc.ipcinterface.ICountManagerService;


//Service两个作用：后台服务(主线程)和服务进程。
//Service服务进程
//startService()开启服务,一开始没有Service,创建,onCreate(),运行onStartCommand(),只能通过stopService()来Destory()销毁;
//bindService()开启的服务,一开始没有Service,创建,onCreate(),onBind(), stopService()无法Destory,通过unbindService()来Destory()销毁;
public class CountService extends Service {
    protected final String className = "CountService";
    private CountManagerImpl mCountManagerImpl;
    private int mCount = 1;
    private boolean mQuit;

    public CountService() {
    }

    public class CountManagerImpl extends ICountManagerService.Stub {

        @Override
        public void invokeCallback(IAppThreadCallBack cb, int counts) throws RemoteException {
            //打印线程名,这是新进程的binder线程
            Log.d(Constants.TAG, className + ":currentThread:" + Thread.currentThread().getName());
            //模拟一个10秒的耗时,Binder线程处理事件过长，导致主进程的发起者线程一直阻塞
//            try {
//                Thread.sleep(10000);
//            } catch (Exception e) {
//            }
            if (cb != null) {
                cb.implementAction(mCount);//回调主进程
                cb.scheduleHandleActivity("calling Main process!");
            }
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return mCountManagerImpl;
    }

    //Service被断开连接时回调
    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, className + ":onDestroy:");
        this.mQuit = true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, className + ":myPid:" + Process.myPid());
        mCountManagerImpl = new CountManagerImpl();
        mQuit = false;
        new Thread() {
            @Override
            public void run() {
                while (!mQuit) {
                    Log.d(Constants.TAG, className + ":currentCount:" + mCount);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    addCount();
                }
            }
        }.start();

    }

    private void addCount() {
        synchronized (this) {
            mCount++;
        }
    }

}
