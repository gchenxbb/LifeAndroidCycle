package com.chen.pa.app_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//Activity生命周期
public class MainActivity extends Activity {
    private boolean willGoSecondActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onCreate");
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        ((TextView) findViewById(R.id.tv_main)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                willGoSecondActivity = true;
                MainActivity.this.startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onPause");
//        if (willGoSecondActivity) {
//            //打开可模拟一个耗时操作，看是否影响SecondActivity的启动，默认注释掉
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e) {
//            }
//            willGoSecondActivity = false;
//        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ActivityLogTag.TAG, getClass().getSimpleName() + " onDestroy");
    }
}
