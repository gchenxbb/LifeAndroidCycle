package com.lifecycle.ponent.homefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifecycle.ponent.R;
import com.lifecycle.ponent.viewpager.ViewPagerStateActivity;

public class PageFragment extends BaseFragment implements View.OnClickListener {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_page, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        return mRootView;
    }


    protected void initView(View root) {
        textView = root.findViewById(R.id.btn_loading);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_loading) {
            startActivity(new Intent(getActivity(), ViewPagerStateActivity.class));
        }
    }
}
