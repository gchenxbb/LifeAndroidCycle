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
import com.lifecycle.ponent.launchmode.LaunchModeActivity;
import com.lifecycle.ponent.life.AActivity;
import com.lifecycle.ponent.receiver.AlReceiver;
import com.lifecycle.ponent.saverestore.SaveActivity;
import com.lifecycle.ponent.service.ServiceLifeCycleActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        return mRootView;
    }

    protected void initView(View root) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }

}
