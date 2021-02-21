package com.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.life.ipc.activity.IPCMainActivity;
import com.lifecycle.ponent.R;

public class FindFragment extends BaseFragment implements View.OnClickListener {
    private TextView mBtnIPC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_find, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        return mRootView;
    }

    protected void initView(View root) {
        mBtnIPC = root.findViewById(R.id.btn_ipc);
        mBtnIPC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_ipc) {
            startActivity(new Intent(mActivity, IPCMainActivity.class));
        }
    }

}
