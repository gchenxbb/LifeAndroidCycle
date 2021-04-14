package com.lifecycle.ponent.receiver;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.lifecycle.ponent.R;

/**
 *
 */
public class ReceiverActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "ReceiverActivity";
    private TextView mBtnStart;
    private TextView mBtnDyStart;
    private BroadcastReceiver mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        initView();
        mBroadcast = new DynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ponent.receiver.DY_ACTION");
        registerReceiver(mBroadcast, intentFilter);
    }

    protected void initView() {
        mBtnStart = findViewById(R.id.btn_send_receiver);
        mBtnStart.setOnClickListener(this);
        mBtnDyStart = findViewById(R.id.btn_send_dyreceiver);
        mBtnDyStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_send_receiver) {
            Intent intent = new Intent();
            intent.setAction("com.ponent.receiver.AL_ACTION");
            sendBroadcast(intent);
        } else if (id == R.id.btn_send_dyreceiver) {
            Intent intent = new Intent();
            intent.setAction("com.ponent.receiver.DY_ACTION");
            sendBroadcast(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcast);
    }
}
