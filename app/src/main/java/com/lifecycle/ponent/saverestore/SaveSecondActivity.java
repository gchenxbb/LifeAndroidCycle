package com.lifecycle.ponent.saverestore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lifecycle.ponent.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SaveSecondActivity extends AppCompatActivity {
    private String TAG = "SaveStateActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName() + " onCreate");
        setContentView(R.layout.activity_save_second);
        initView();
    }

    private void initView() {
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);//savedInstanceStatet一定存在
        Log.d(TAG, getClass().getSimpleName() + " onRestoreInstanceState " + savedInstanceState.getString("savedTest"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedTest", "savedTextHi");
        Log.d(TAG, getClass().getSimpleName() + " onSaveInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, getClass().getSimpleName() + " onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, getClass().getSimpleName() + " onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, getClass().getSimpleName() + " onDestroy");
    }
}
