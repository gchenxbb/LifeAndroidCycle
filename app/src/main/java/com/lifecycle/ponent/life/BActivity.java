package com.lifecycle.ponent.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lifecycle.ponent.R;

/**
 * 生命周期-Activity-B
 */
public class BActivity extends BaseActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ALog();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ALog();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ALog();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ALog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ALog();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ALog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ALog();
    }

}