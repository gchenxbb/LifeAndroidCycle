package com.lifecycle.ponent.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

public class HomeVPAdapter extends FragmentPagerAdapter {
    private String TAG = "HomeVPAdapter";
    private List<Fragment> fragmentList;
    private FragmentManager mFragmentManager;

    public HomeVPAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mFragmentManager = fm;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        long itemId = this.getItemId(position);
        String name = makeFragmentName(container.getId(), itemId);

        Log.d(TAG, "instantiateItem:" + container.getClass().getName() + "-position:" + position + "-tagname:" + name);
        Fragment fragment = this.mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            Log.d(TAG, "fragment:" + fragment.toString());
        }

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d(TAG, "destroyItem:" + "-position:" + position);
        super.destroyItem(container, position, object);
    }

    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}
