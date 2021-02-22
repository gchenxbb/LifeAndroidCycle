package com.lifecycle.ponent.mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * singleTask
 */
public class SingleTaskActivity extends BaseModeActivity {

    public static final String TAG = "CActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //栈中，singleTask模式，调用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent == > 调用");
        Toast.makeText(SingleTaskActivity.this, "onNewIntent == > 调用", Toast.LENGTH_LONG).show();
    }

}

