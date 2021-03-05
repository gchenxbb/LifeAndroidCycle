package com.lifecycle.ponent.homefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifecycle.ponent.R;

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
