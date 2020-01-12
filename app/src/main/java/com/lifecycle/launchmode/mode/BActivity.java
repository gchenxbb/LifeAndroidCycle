package com.lifecycle.launchmode.mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * singleTop
 */
public class BActivity extends BaseActivity {

    public static final String TAG = "BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //栈顶，singleTop模式，调用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent == > 调用");
        Toast.makeText(BActivity.this, "onNewIntent == > 调用", Toast.LENGTH_LONG).show();
    }
}
