package com.lifecycle.ponent.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifecycle.ponent.R;
import com.lifecycle.ponent.homefragment.BaseFragment;

public class ViewPagerFragB extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.viewpager_fragment_b, container, false);
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

