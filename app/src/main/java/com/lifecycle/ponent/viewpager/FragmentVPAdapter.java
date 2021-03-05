package com.lifecycle.ponent.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Page滑走时
 * FragmentPagerAdapter 只执行 Fragment 的 destroyView，不会 destroy 和 detach
 * 适用于数量较少的场景，用空间换时间
 * <p>
 * 参考 instantiateItem  和 destroyItem 方法
 */
public class FragmentVPAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public FragmentVPAdapter(FragmentManager fm, List<Fragment> fragments) {
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