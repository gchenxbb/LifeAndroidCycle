package com.lifecycle.launchmode.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lifecycle.launchmode.R;

//生命周期-Activity-B
public class BActivity extends AppCompatActivity {
    private String TAG = "ActivityLifeCycle";
    private String className = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, className + " onCreate");
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, className + " onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, className + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, className + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, className + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, className + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, className + " onDestroy");
    }

}