package com.lifecycle.launchmode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.lifecycle.app.R;

//生命周期-Activity-B
public class BActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onCreate");
        setContentView(R.layout.activity_b);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LogTag.TAG, getClass().getSimpleName() + " onDestroy");
    }

}
