package com.lifecycle.launchmode.life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.launchmode.R;

//生命周期-activity-a
public class AActivity extends AppCompatActivity {
    private String TAG = "ActivityLifeCycle";
    private String className = getClass().getSimpleName();
    private TextView mBtnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TAG, className + " onCreate");
        mBtnB = findViewById(R.id.btn_life_b);
        mBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this, BActivity.class));
            }
        });
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
