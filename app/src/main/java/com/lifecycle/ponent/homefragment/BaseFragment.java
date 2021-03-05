package com.lifecycle.ponent.homefragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基础 Fragment
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected View mRootView;
    private String TAG = "BaseFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Log.d(TAG, this.getClass().getSimpleName() + "-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.getClass().getSimpleName() + "-onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, this.getClass().getSimpleName() + "-onCreateView");
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, this.getClass().getSimpleName() + "-onViewCreated");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, this.getClass().getSimpleName() + "-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, this.getClass().getSimpleName() + "-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, this.getClass().getSimpleName() + "-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, this.getClass().getSimpleName() + "-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, this.getClass().getSimpleName() + "-onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, this.getClass().getSimpleName() + "-onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this.getClass().getSimpleName() + "-onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, this.getClass().getSimpleName() + "-onDetach");
    }

}
