package com.lifecycle.launchmode.life;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lifecycle.launchmode.TagLog;
import com.lifecycle.launchmode.R;

//生命周期-activity-a
public class AActivity extends AppCompatActivity {
    private TextView mBtnB;
    private String className = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TagLog.TAG, className + " onCreate");
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
        Log.d(TagLog.TAG, className + " onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TagLog.TAG, className + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TagLog.TAG, className + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TagLog.TAG, className + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagLog.TAG, className + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagLog.TAG, className + " onDestroy");
    }
}
