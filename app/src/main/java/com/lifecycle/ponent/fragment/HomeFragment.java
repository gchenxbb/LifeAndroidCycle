package com.lifecycle.ponent.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifecycle.ponent.intentfilter.IntentActivity;
import com.lifecycle.ponent.R;
import com.lifecycle.ponent.life.AActivity;
import com.lifecycle.ponent.mode.LaunchModeActivity;
import com.lifecycle.ponent.receiver.AlReceiver;
import com.lifecycle.ponent.saverestore.SaveActivity;
import com.lifecycle.ponent.service.ServiceLifeCycleActivity;
import com.lifecycle.ponent.startup.StartupOneAct;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TextView mBtnLifeA;
    private TextView mBtnSave;
    private TextView mBtnLifeS;
    private TextView mBtnLaunch;
    private TextView mBtnStartUp;
    private TextView mBtnSendReceiver;
    private TextView mBtnIntentFilter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        return mRootView;
    }

    protected void initView(View root) {

        mBtnLaunch = root.findViewById(R.id.btn_launch);
        mBtnLifeA = root.findViewById(R.id.btn_life_a);
        mBtnLifeS = root.findViewById(R.id.btn_life_s);
        mBtnStartUp = root.findViewById(R.id.btn_startup_ams);
        mBtnSave = root.findViewById(R.id.btn_life_save);
        mBtnSendReceiver = root.findViewById(R.id.btn_receiver_send);
        mBtnIntentFilter = root.findViewById(R.id.btn_intent_filter);

        mBtnSave.setOnClickListener(this);
        mBtnLaunch.setOnClickListener(this);
        mBtnLifeA.setOnClickListener(this);
        mBtnLifeS.setOnClickListener(this);
        mBtnStartUp.setOnClickListener(this);
        mBtnSendReceiver.setOnClickListener(this);
        mBtnIntentFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_launch) {
            startActivity(new Intent(mActivity, LaunchModeActivity.class));
        } else if (id == R.id.btn_life_a) {
            startActivity(new Intent(mActivity, AActivity.class));
        } else if (id == R.id.btn_life_s) {
            startActivity(new Intent(mActivity, ServiceLifeCycleActivity.class));
        } else if (id == R.id.btn_startup_ams) {
            startActivity(new Intent(mActivity, StartupOneAct.class));
        } else if (id == R.id.btn_life_save) {
            startActivity(new Intent(mActivity, SaveActivity.class));
        } else if (id == R.id.btn_receiver_send) {
            Intent intent = new Intent(mActivity, AlReceiver.class);
            intent.setAction("com.pachen.cool.service.AL_ACTION");
            mActivity.sendBroadcast(intent);
        } else if (id == R.id.btn_intent_filter) {
            startActivity(new Intent(mActivity, IntentActivity.class));
        }
    }

}
