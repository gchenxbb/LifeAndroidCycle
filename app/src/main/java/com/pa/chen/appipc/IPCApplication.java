package com.pa.chen.appipc;

import android.app.Application;
import android.os.Process;
import android.util.Log;

import com.pa.chen.appipc.constants.Constants;


//Application
public class IPCApplication extends Application {

    public IPCApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //观察打印多个进程创建IPCApplication并触发onCreate方法
        Log.d(Constants.TAG, getClass().getSimpleName() + ":onCreate!,"+Process.myPid());
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
