package com.life.ipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.life.ipc.Constants;
import com.life.ipc.R;
import com.life.ipc.bean.People;

/**
 * IPCActivity组件运行于独立进程
 * <p>
 * Bundle传递数据
 */
public class IPCActivity extends Activity {
    public String className = "IPCActivity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
        //在主页面中修改过，看打印值，打印的是修改前的值。
        //该组件运行于一个独立进程中,有独立的虚拟机和堆栈。
        //两个进程虚拟机都会加载Constants类，这两个类变量互相不影响。
        Log.d(Constants.TAG, getClass().getSimpleName() + ":" + Constants.id);

        Intent mIntent = getIntent();
        if (mIntent != null && mIntent.getExtras() != null) {
            Bundle bundle = mIntent.getExtras().getBundle(Constants.INTENT_BUNDLE);
            People mPeople = bundle.getParcelable(Constants.BUNDLE_PARCE);
            if (mPeople != null) {
                Log.d(Constants.TAG, className + "People:" + mPeople.toString());
            }
        }
    }
}
