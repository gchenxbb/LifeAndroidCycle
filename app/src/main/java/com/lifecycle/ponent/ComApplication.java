package com.lifecycle.ponent;

import android.app.Application;
import android.os.Process;
import android.util.Log;

import com.life.ipc.Constants;

/**
 * Application
 */
public class ComApplication extends Application {
    public final String TAG = getClass().getSimpleName();


    public ComApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //观察打印多个进程创建 ComApplication 并触发 onCreate() 方法
        Log.d(Constants.TAG, TAG + ":onCreate!," + Process.myPid());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
