package com.lifecycle.ponent.mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * singleTask with taskAffinity
 */
public class TaskAffinity1Activity extends BaseModeActivity {
    public static final String TAG = "TaskAffinity1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //栈中，singleTask模式，调用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent == > 调用");
        Toast.makeText(TaskAffinity1Activity.this, "onNewIntent == > 调用", Toast.LENGTH_LONG).show();
    }
}