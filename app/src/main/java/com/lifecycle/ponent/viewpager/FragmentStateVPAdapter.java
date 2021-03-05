package com.lifecycle.ponent.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Page滑走时
 * FragmentStatePagerAdapter 会执行 destroy 和detach，滑回来再次执行 attach 和 create；
 * 适用于数量较多的场景，每次 destroy，节约内存。
 * <p>
 * 参考 instantiateItem  和 destroyItem 方法
 */
public class FragmentStateVPAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public FragmentStateVPAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}