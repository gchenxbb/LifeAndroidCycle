package com.lifecycle.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//生命周期-activity-a
public class AActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mBtnB;
    private TextView mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d(LogTag.TAG, getClass().getSimpleName() + " onCreate");

        mBtnB = findViewById(R.id.btn_life_b);
        mBtnSave = findViewById(R.id.btn_life_save);

        mBtnB.setOnClickListener(this);
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_life_b) {
            startActivity(new Intent(AActivity.this, BActivity.class));
        } else if (id == R.id.btn_life_save) {
            startActivity(new Intent(AActivity.this, SaveActivity.class));
        }
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
