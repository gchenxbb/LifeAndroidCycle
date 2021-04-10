package com.lifecycle.ponent.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * singleTask with taskAffinity
 */
public class TaskAffinity2Activity extends LaunchModeActivity {
    public static final String TAG = "TaskAffinity2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //栈中，singleTask模式，调用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, getClass().getSimpleName() + ":" + "onNewIntent == > 调用");
        Toast.makeText(TaskAffinity2Activity.this, getClass().getSimpleName() + ":" + "onNewIntent == > 调用", Toast.LENGTH_LONG).show();
    }
}

