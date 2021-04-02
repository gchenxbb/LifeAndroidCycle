package com.lifecycle.ponent.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lifecycle.ponent.R;

/**
 * singleTop
 */
public class SingleTopActivity extends LaunchModeActivity {

    public static final String TAG = "BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootScView.setBackgroundResource(R.color.bg_green_700);
    }

    //栈顶，singleTop模式，调用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        rootScView.setBackgroundResource(R.color.bg_green_700);
        Log.d(TAG, getClass().getSimpleName() + ":" + "onNewIntent == > 调用");
        Toast.makeText(SingleTopActivity.this, getClass().getSimpleName() + ":" +"onNewIntent == > 调用", Toast.LENGTH_LONG).show();
    }

}
